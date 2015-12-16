import React from 'react';
import ReactDOM from 'react-dom';
import client from './client/client';
import follow from './client/follow';
import RatingList from './ratinglist/ratinglist';
import AppConstants from '../constants/constants';

export default class App extends React.Component {

	constructor(props){
		super(props);
		this.state = {
			ratings: [],
			attributes: [],
			pageSize: AppConstants.DEFAULT_PAGESIZE,
			links: {}
		};
		this.updatePageSize = this.updatePageSize.bind(this);
		this.onDelete = this.onDelete.bind(this);
		this.onNavigate = this.onNavigate.bind(this);
	}

	loadFromServer(pageSize){
		follow(client, AppConstants.ROOT, [
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
