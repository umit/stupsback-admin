import React from 'react';
import client from '../client/client';
import follow from '../client/follow';

export default class Like extends React.Component {

    constructor(props) {
        super(props);
        this.state = {
            count: props.count || 0
        };
        this.loadLikes = this.loadLikes.bind(this);
    }

    componentDidMount() {
        this.loadLikes();
    }

    loadLikes(){
        follow(client, this.props.likeUrl, [
            {rel: 'userLikes'}
        ]).then(likesCollection => {
            this.setState({count: likesCollection.length});
        });
    }

    render() {
        return <button className="btn btn-default" >
            <span className="glyphicon glyphicon-thumbs-up" aria-hidden="true"></span>
            <span>  {this.state.count}</span>
        </button>;
    }
}