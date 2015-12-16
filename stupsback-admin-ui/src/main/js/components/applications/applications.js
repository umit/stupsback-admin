import React from 'react';

import client from '../client/client';
import follow from '../client/follow';

import AppForm from './appform';
import ApplicationList from './applicationlist';

import AppConstants from '../../constants/constants';


export default class Applications extends React.Component {

  constructor(props){
    super(props);
    this.state = {
      applications: [],
      attributes: [],
      pageSize: AppConstants.DEFAULT_PAGESIZE,
      links: {}
    };
    this.updatePageSize = this.updatePageSize.bind(this);
    this.onDelete = this.onDelete.bind(this);
    this.onNavigate = this.onNavigate.bind(this);
    this.onCreate = this.onCreate.bind(this);

    this.updateApplicationList = this.updateApplicationList.bind(this);
  }

  loadFromServer(pageSize){
		follow(client, AppConstants.ROOT, [
			{rel: 'applications', params: {size: pageSize}}
		]).then(applicationCollection => {
			return client({
				method: 'GET',
				path: applicationCollection.entity._links.profile.href,
				headers: {'Accept':'application/schema+json'}
			}).then(schema => {
				this.schema = schema.entity;
				return applicationCollection;
			}).done(applicationCollection => {
				this.setState({
					applications: applicationCollection.entity._embedded.applications,
					attributes: Object.keys(this.schema.properties),
					pageSize: pageSize,
					links: applicationCollection.entity._links
				});
			});
		});
	}

  onCreate(newApplication) {
		follow(client, AppConstants.ROOT, ['applications']).then(applicationCollection => {
			return client({
				method: 'POST',
				path: applicationCollection.entity._links.self.href,
				entity: newApplication,
				headers: {'Content-Type': 'application/json'}
			})
		}).then(response => {
			return follow(client, AppConstants.ROOT, [
				{rel: 'applications', params: {'size': this.state.pageSize}}]);
		}).done(response => {
			this.onNavigate(response.entity._links.last.href);
		});
	}

	onDelete(application){
		client({method: 'DELETE', path: application._links.self.href}).done(response => {
			this.loadFromServer(this.state.pageSize);
		});
	}

	onNavigate(navUri){
		client({method: 'GET', path: navUri}).done(applicationCollection => {
			this.setState({
				applications: applicationCollection.entity._embedded.applications,
				attributes: this.state.attributes,
				pageSize: this.state.pageSize,
				links: applicationCollection.entity._links
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

  updateApplicationList(){
    this.loadFromServer(this.state.pageSize);
  }

  render(){
    return(
      <div>
        <AppForm refreshList={this.updateApplicationList} onCreate={this.onCreate} />
        <div style={{borderBottom: '1px solid #ccc'}} />
        <ApplicationList applications={this.state.applications}
                    links={this.state.links}
                    updatePageSize={this.updatePageSize}
                    pageSize={this.state.pageSize}
                    onNavigate={this.onNavigate}
                    onDelete={this.onDelete}/>
      </div>
    )
  }
}
