import React from 'react';
import {Link} from 'react-router';

export default class Issues extends React.Component {
  constructor(props){
    super(props);
    this.state = {
      appId: ''
    }
  }

  componentDidMount(){
    this.setState({
      appId: this.props.params.appId
    });
  }

  render(){
    return (
      <div>
        <Link to="/" className="btn btn-default btn-danger">Cancel</Link><h3> New Issues for {this.state.appId}</h3>
        <div style={{borderBottom: '1px solid #ccc', paddingTop: 15}} />
        <div style={{paddingTop: 15}} >
          <form className="form-horizontal">
            <div className="form-group">
              <label htmlFor="issueDescription" className="col-sm-1 control-label">Description</label>
              <div className="col-sm-8">
                <textarea className="form-control" rows="5" mref="issueDescription" id="issueDescription" placeholder="Describe here ..." >
                </textarea>
              </div>
            </div>
            <div className="form-group">
              <div className="col-sm-offset-1 col-sm-8">
                <button type="submit" className="btn btn-default">Add Issue</button>
              </div>
            </div>
          </form>
        </div>
      </div>
    )
  }
}
