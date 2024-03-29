import React from 'react';
import ReactDOM from 'react-dom';
import client from '../client/client';
import follow from '../client/follow';
import RatingList from './ratinglist';
import AppConstants from '../../constants/constants';
import stompClient from './websocket-listener';

// the hole Ratings-Site
export default class Ratings extends React.Component {

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

		this.refreshAndGoToLastPage = this.refreshAndGoToLastPage.bind(this);
		this.refreshCurrentPage = this.refreshCurrentPage.bind(this);
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
		var es = new EventSource("/sse");
		es.onmessage = function (event) {
  		console.log(event.data);
		};
		stompClient.register([
			{route: '/topic/newRating', callback: this.refreshAndGoToLastPage},
			{route: '/topic/updateRating', callback: this.refreshCurrentPage},
			{route: '/topic/deleteRating', callback: this.refreshCurrentPage}
		]);
	}

	refreshAndGoToLastPage(message) {
			console.log(message);
	    follow(client, AppConstants.ROOT, [{
	        rel: 'ratings',
	        params: {size: this.state.pageSize}
	    }]).done(response => {
	        this.onNavigate(response.entity._links.last.href);
	    })
	}

	refreshCurrentPage(message) {
			console.log(message);
	    follow(client, AppConstants.ROOT, [{
	        rel: 'ratings',
	        params: {
	            size: this.state.pageSize,
	            page: this.state.page.number
	        }
	    }]).then(ratingCollection => {
	        this.links = ratingCollection.entity._links;
	        this.page = ratingCollection.entity.page;

	        return ratingCollection.entity._embedded.ratings.map(rating => {
	            return client({
	                method: 'GET',
	                path: rating._links.self.href
	            })
	        });
	    }).then(ratingPromises => {
	        return when.all(ratingPromises);
	    }).then(ratings => {
	        this.setState({
	            page: this.page,
	            ratings: ratings,
	            attributes: Object.keys(this.schema.properties),
	            pageSize: this.state.pageSize,
	            links: this.links
	        });
	    });
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
