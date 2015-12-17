import React from 'react';
import ReactDOM from 'react-dom';

export default class AppForm extends React.Component {

  constructor(props){
    super(props);
    this.handleFormSubmit = this.handleFormSubmit.bind(this);
  }

  handleFormSubmit(e){
    e.preventDefault();
    var newApplication = {};
    newApplication['name'] = ReactDOM.findDOMNode(this.refs['applicationName']).value.trim();
    this.props.onCreate(newApplication);
    ReactDOM.findDOMNode(this.refs['applicationName']).value = '';
  }

  render() {
    return (
      <div className="row">
        <form className="form-horizontal">
          <div className="form-group">
            <label htmlFor="applicationName" className="col-sm-2 control-label">Name</label>
            <div className="col-sm-8">
              <input type="text" className="form-control" ref="applicationName" id="applicationName" placeholder="Name for application" />
            </div>
          </div>
          <div className="form-group">
            <div className="col-sm-offset-2 col-sm-8">
              <button type="submit" className="btn btn-default" onClick={this.handleFormSubmit}>Add Application</button>
            </div>
          </div>
        </form>
      </div>
    )
  }
}
