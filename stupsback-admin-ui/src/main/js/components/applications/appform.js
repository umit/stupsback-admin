import React from 'react';

export default class AppForm extends React.Component {

  constructor(props){
    super(props);
    this.handleFormSubmit = this.handleFormSubmit.bind(this);
  }

  handleFormSubmit(e){
    e.preventDefault();
    console.log("Clicked")
  }

  render() {
    return (
      <div className="row">
        <form className="form-horizontal">
          <div className="form-group">
            <label htmlFor="inputEmail3" className="col-sm-2 control-label">Email</label>
            <div className="col-sm-8">
              <input type="email" className="form-control" id="inputEmail3" placeholder="Email" />
            </div>
          </div>
          <div className="form-group">
            <label htmlFor="inputPassword3" className="col-sm-2 control-label">Password</label>
            <div className="col-sm-8">
              <input type="password" className="form-control" id="inputPassword3" placeholder="Password" />
            </div>
          </div>
          <div className="form-group">
            <div className="col-sm-offset-2 col-sm-8">
              <div className="checkbox">
                <label>
                  <input type="checkbox"> Remember me </input>
                </label>
              </div>
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
