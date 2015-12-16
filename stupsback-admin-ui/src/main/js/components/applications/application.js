import React from 'react';

export default class Application extends React.Component {

  constructor(props){
    super(props);
    this.handleDelete = this.handleDelete.bind(this);
  }

  handleDelete(){
		this.props.onDelete(this.props.application);
	}

  render(){
    return (
      <tr>
				<td>{this.props.application.name}</td>
				<td>{this.props.application.partone}</td>
        <td>{this.props.application.parttwo}</td>
				<td>
					<button className="btn btn-default" onClick={this.handleDelete}>
						<span className="glyphicon glyphicon-trash" aria-hidden="true"></span>
					</button>
				</td>
			</tr>
    )
  }
}
