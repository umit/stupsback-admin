'use strict';

const React = require('react');
const ReactDOM = require('react-dom');
const client = require('./client');

const follow = require('./follow');

const root = 'http://localhost:8080/api';

class App extends React.Component {

	constructor(props){
		super(props);
		this.state = {
			ratings: [],
			attributes: [],
			pageSize: 4,
			links: {}
		};
		this.updatePageSize = this.updatePageSize.bind(this);
		this.onDelete = this.onDelete.bind(this);
		this.onNavigate = this.onNavigate.bind(this);
	}

	loadFromServer(pageSize){
		follow(client, root, [
			{rel: 'ratings', params: {size: pageSize}}
		]).then(ratingsCollection => {
			return client({
				method: 'GET',
				path: ratingsCollection.entity._links.profile.href,
				headers: {'Accept':'application/schema+json'}
			}).then(schema => {
				this.schema = schema.entity;
				return ratingsCollection;
			}).done(ratingsCollection => {
				this.setState({
					ratings: ratingsCollection.entity._embedded.ratings,
					attributes: Object.keys(this.schema.properties),
					pageSize: pageSize,
					links: ratingsCollection.entity._links
				});
			});
		});
	}

	onDelete(rating){
		client({method: 'DELETE', path: rating._links.self.href}).done(response => {
			this.loadFromServer(this.state.pageSize);
		});
	}

	onNavigate(navUri){
		client({method: 'GET', path: navUri}).done(ratingsCollection => {
			this.setState({
				ratings: ratingsCollection.entity._embedded.ratings,
				attributes: this.state.attributes,
				pageSize: this.state.pageSize,
				links: ratingsCollection.entity._links
			});
		});
	}

	updatePageSize(pageSize){
		if(pageSize !== this.state.pageSize) {
			this.loadFromServer(pageSize);
		}
	}

	componentDidMount(){
		this.loadFromServer(this.state.pageSize);
	}

	render(){
		console.log(this.state.links);
		return (
			<div>
				<RatingList ratings={this.state.ratings}
				 						links={this.state.links}
										updatePageSize={this.updatePageSize}
										pageSize={this.state.pageSize}
							  		onNavigate={this.onNavigate}
							  		onDelete={this.onDelete}
										/>
			</div>
		);
	}
}

class SizeChooser extends React.Component {

	constructor(props){
		super(props);
		this.handleInput = this.handleInput.bind(this);
	}

	handleInput(e) {
		e.preventDefault();
		var pageSize = ReactDOM.findDOMNode(this.refs.pageSize).value;
		if (/^[0-9]+$/.test(pageSize)) {
			this.props.updatePageSize(pageSize);
		} else {
			ReactDOM.findDOMNode(this.refs.pageSize).value =
				pageSize.substring(0, pageSize.length - 1);
		}
	}

	render(){
		return(
			<div id="sizeChooser" className="row">
				<div className="form-group">
					<div className="col-lg-1">
						<label className="control-label" htmlFor="pageSize">Size:</label>
					</div>
					<div className="col-lg-1">
						<select className="form-control" ref="pageSize" id="pageSize" value={this.props.pageSize} onChange={this.handleInput} >
							<option>5</option>
							<option>10</option>
							<option>25</option>
							<option>50</option>
						</select>
					</div>
				</div>
			</div>
		)
	}
}

class RatingList extends React.Component {

	constructor(props){
		super(props);
		this.handleNavFirst = this.handleNavFirst.bind(this);
		this.handleNavPrev = this.handleNavPrev.bind(this);
		this.handleNavNext = this.handleNavNext.bind(this);
		this.handleNavLast = this.handleNavLast.bind(this);
	}

	handleNavFirst(e){
		e.preventDefault();
		this.props.onNavigate(this.props.links.first.href);
	}

	handleNavPrev(e) {
		e.preventDefault();
		this.props.onNavigate(this.props.links.prev.href);
	}

	handleNavNext(e) {
		e.preventDefault();
		this.props.onNavigate(this.props.links.next.href);
	}

	handleNavLast(e) {
		e.preventDefault();
		this.props.onNavigate(this.props.links.last.href);
	}

	render() {
		var ratings = this.props.ratings.map(rating =>
			<Rating key={rating._links.self.href} rating={rating} onDelete={this.props.onDelete} />
		);

		var navLinks = [];
		if ("first" in this.props.links) {
			if ("prev" in this.props.links) {
				navLinks.push(<button className="btn btn-default active" key="first" onClick={this.handleNavFirst}>&lt;&lt;</button>);
			}else{
				navLinks.push(<button className="btn btn-default disabled" key="first">&lt;&lt;</button>);
			}
		}
		if ("prev" in this.props.links) {
			navLinks.push(<button className="btn btn-default active" key="prev" onClick={this.handleNavPrev}>&lt;</button>);
		}else{
			navLinks.push(<button className="btn btn-default disabled" key="prev">&lt;</button>);
		}
		if ("next" in this.props.links) {
			navLinks.push(<button className="btn btn-default active" key="next" onClick={this.handleNavNext}>&gt;</button>);
		}else{
			navLinks.push(<button className="btn btn-default disabled" key="next">&gt;</button>);
		}
		if ("last" in this.props.links) {
			if ("next" in this.props.links) {
					navLinks.push(<button className="btn btn-default active" key="last" onClick={this.handleNavLast}>&gt;&gt;</button>);
				}else{
					navLinks.push(<button className="btn btn-default disabled" key="last">&gt;&gt;</button>);
				}
		}

		return (
			<div>
				<SizeChooser pageSize={this.props.pageSize}
					 						updatePageSize={this.props.updatePageSize}
											/>
				<table className="table table-condensed">
					<thead>
						<tr>
							<th>App</th>
							<th>Stars</th>
							<th>Comment</th>
							<th>Feedback</th>
							<th>FB-Geber</th>
							<th>Date</th>
							<th>Status</th>
							<th>Git-Issue</th>
							<th>Action</th>
						</tr>
					</thead>
					<tbody>
						{ratings}
					</tbody>
				</table>
				<div className="row">
					<div className="col-md-4 col-md-offset-4">
						<nav>
					 		{navLinks}
						</nav>
					</div>
				</div>
			</div>
		)
	}
}

class Rating extends React.Component {

	constructor(props){
		super(props);
		this.handleDelete = this.handleDelete.bind(this);
	}

	handleDelete(){
		this.props.onDelete(this.props.rating);
	}

	render(){
		return(
			<tr>
				<td>{this.props.rating.appId}</td>
				<td>{this.props.rating.stars}</td>
				<td>{this.props.rating.meta}</td>
				<td>{this.props.rating.comment}</td>
				<td>jbellmann</td>
				<td>17.12.2015</td>
				<td>Open</td>
				<td>n.A.</td>
				<td>
					<button className="btn btn-default" >
						<span className="glyphicon glyphicon-hand-right" aria-hidden="true"></span>
						<span>     14</span>
					</button>
					<button className="btn btn-default" onClick={this.handleDelete}>
						<span className="glyphicon glyphicon-trash" aria-hidden="true"></span>
					</button>
					<button className="btn btn-default" onClick={this.handleDelete}>
						<span className="glyphicon glyphicon-download-alt" aria-hidden="true"></span>
					</button>
				</td>
			</tr>
		)
	}
}

ReactDOM.render(
	<App />, document.getElementById('react')
)
