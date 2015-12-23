import React from 'react';
import Icon from 'react-fa';
import Popover from 'react-popover';
import request from 'superagent';

export default class GithubButton extends React.Component {

    constructor(props) {
        super(props);
        this.state = {
            appId: props.appId || '',
            isOpen: false
        };
    }

    componentDidMount() {
    }

    handleClick() {

    }

    toggle() {
        this.setState({isOpen: !this.state.isOpen})
    }

    renderForm() {
        return (
            <div className="panel panel-primary">
                <div className="panel-heading">Create Issue</div>
                <div className="panel-body">
                    <form>
                        <fieldset className="form-group">
                            <label htmlFor="issueTitle">Title</label>
                            <input type="text" id="issueTitle" className="form-control" />
                        </fieldset>
                        <fieldset className="form-group">
                            <label htmlFor="issueDescription">Description</label>
                        <textarea className="form-control" rows="5" mref="issueDescription" id="issueDescription"
                                  placeholder="Describe here ...">
                        </textarea>
                        </fieldset>
                        <button type="submit" className="btn btn-default">Add Issue</button>
                    </form>
                </div>
            </div>
        );
    }

    render() {
        const { isOpen } = this.state;
        return (
            <Popover isOpen={isOpen} place="below" body={this.renderForm()}>
                <button className="btn btn-default" onClick={this.toggle.bind(this)}>
                    <Icon name='github' size="lg"/>
                </button>
            </Popover>
        );
    }

}