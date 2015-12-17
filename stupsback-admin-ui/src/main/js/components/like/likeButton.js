import React from 'react';
import client from 'components/client/client';
import follow from 'components/client/follow';
import AppConstants from 'constants/constants';
import request from 'superagent';

export default class LikeButton extends React.Component {

    constructor(props) {
        super(props);
        this.state = {
            count: props.count || 0
        };
        //this.loadLikes = this.loadLikes.bind(this);
    }

    componentDidMount() {
        this.loadLikes();
    }

    loadLikes() {
        follow(client, this.props.likeAssociationUri, [
            {rel: 'userLikes'}
        ]).then(likesCollection => {
            this.setState({count: likesCollection.length});
        });
    }

    handleClick() {
        this.props.likeHandler();
        request
            .get(AppConstants.LIKE_RESOURCE +'/search')
            .set('Authorization', `Bearer ${tokens.get('kio')}`)
            .accept('json')
            .then(res => res.body);
    }

    render() {
        return <button className="btn btn-default" onClick={this.handleClick}>
            <span className="glyphicon glyphicon-thumbs-up" aria-hidden="true"></span>
            <span>  {this.state.count}</span>
        </button>;
    }
}
LikeButton.displayName = 'LikeButton';
LikeButton.propTypes = {
    count: React.PropTypes.number,
    likeAssociationUri: React.PropTypes.string,
    likeResourceUri: React.PropTypes.string
};