import React from 'react';
import ReactDOM from 'react-dom';
import AppConstants from '../../constants/constants';

export default class SizeChooser extends React.Component {

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
						<select value={AppConstants.DEFAULT_PAGESIZE} className="form-control" ref="pageSize" id="pageSize" value={this.props.pageSize} onChange={this.handleInput} >
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
