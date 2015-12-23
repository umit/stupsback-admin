import React from 'react';
import { Link } from 'react-router';
import Icon from 'react-fa';
import request from 'superagent';

export default class GithubButton extends React.Component {

    constructor(props) {
        super(props);
        this.state = {
            appId: props.appId || ''
        };
    }

    render() {
        return <Link to={`/issues/${this.props.appId}`} className="btn btn-default" >
            <Icon name='github-square'/>
        </Link>;
    }

}