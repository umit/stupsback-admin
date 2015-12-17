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
    }

    componentDidMount() {
        this.loadLikes();
    }

    loadLikes() {
        follow(client, this.props.likeAssociationUri, [
            {rel: 'thumbsUps'}
        ]).then(likesCollection => {
            this.setState({count: likesCollection.length});
            let likes = likesCollection.filter((i, idx, items) => i.username === AppConstants.USERNAME);
            if (likes.length === 1) {
                this.setState({selfLike: likes[0]});
            }
            return likesCollection;
        });
    }

    handleClick() {
        if (!this.state.selfLike) {
            request
                .post(AppConstants.THUMBS_UPS_RESOURCE)
                .send({rating: this.props.ratingUri})
                .accept('json')
                .end((err, res) => {
                    if (err && err.status === 409) {

                    } else {
                        this.loadLikes();
                    }
                });
        } else {
            request
                .delete(this.state.selfLike._links.self.href)
                .accept('json')
                .then(res => {
                    delete this.state.selfLike;
                    this.loadLikes();
                });
        }


    }

    render() {
        return <button className="btn btn-default" onClick={this.handleClick.bind(this)}>
            <span className="glyphicon glyphicon-thumbs-up" aria-hidden="true"></span>
            <span>  {this.state.count}</span>
        </button>;
    }
}
LikeButton.displayName = 'LikeButton';
LikeButton.propTypes = {
    count: React.PropTypes.number,
    likeAssociationUri: React.PropTypes.string,
    ratingUri: React.PropTypes.string
};