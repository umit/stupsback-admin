import React from 'react';
import Icon from 'react-fa';

export default class Rating extends React.Component {

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
						<Icon name='github-square' />
					</button>
					<button className="btn btn-default" onClick={this.handleDelete}>
						<span className="glyphicon glyphicon-download-alt" aria-hidden="true"></span>
					</button>
				</td>
			</tr>
		)
	}
}
