'use strict';

const React = require('react');
const ReactDOM = require('react-dom');
const client = require('./client');

const follow = require('./follow');

const root = '/api';

class App extends React.Component {

	constructor(props){
		super(props);
		this.state = {
			ratings: [],
			attributes: [],
			pageSize: 8,
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

class RatingList extends React.Component {

	constructor(props){
		super(props);
		this.handleNavFirst = this.handleNavFirst.bind(this);
		this.handleNavPrev = this.handleNavPrev.bind(this);
		this.handleNavNext = this.handleNavNext.bind(this);
		this.handleNavLast = this.handleNavLast.bind(this);
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
			navLinks.push(<button key="first" onClick={this.handleNavFirst}>&lt;&lt;</button>);
		}
		if ("prev" in this.props.links) {
			navLinks.push(<button key="prev" onClick={this.handleNavPrev}>&lt;</button>);
		}
		if ("next" in this.props.links) {
			navLinks.push(<button key="next" onClick={this.handleNavNext}>&gt;</button>);
		}
		if ("last" in this.props.links) {
			navLinks.push(<button key="last" onClick={this.handleNavLast}>&gt;&gt;</button>);
		}

		return (
			<div>
				<input ref="pageSize" defaultValue={this.props.pageSize} onInput={this.handleInput}/>
				<table className="table table-condensed">
					<thead>
						<tr>
							<th>App-ID</th>
							<th>Stars</th>
							<th>Comment</th>
							<th></th>
						</tr>
					</thead>
					<tbody>
						{ratings}
					</tbody>
				</table>
				<div>
					{navLinks}
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
				<td>
					<button onClick={this.handleDelete}>Delete</button>
				</td>
			</tr>
		)
	}
}

ReactDOM.render(
	<App />,
	document.getElementById('react')
)
