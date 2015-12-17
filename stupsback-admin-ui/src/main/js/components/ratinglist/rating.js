import React from 'react';
import LikeButton from '../like/likeButton';

export default class Rating extends React.Component {

    constructor(props) {
        super(props);
        this.handleDelete = this.handleDelete.bind(this);
    }

    handleDelete() {
        this.props.onDelete(this.props.rating);
    }

    render() {
        let href = '';
        if ("userLikes" in this.props.rating._links) {
            href = this.props.rating._links.userLikes.href;
        }
        return (
            <tr>
                <td>{this.props.rating.appId}</td>
                <td>{this.props.rating.stars}</td>
                <td>{this.props.rating.meta}</td>
                <td>{this.props.rating.comment}</td>
                <td>jbellmann</td>
                <td>17.12.2015</td>
                <td>Open</td>
                <td>n.A.</td>
                <td>

                    <LikeButton likeUrl={href} />
                    <button className="btn btn-default" onClick={this.handleDelete}>
                        <span className="glyphicon glyphicon-trash" aria-hidden="true"></span>
                    </button>
                    <button className="btn btn-default" onClick={this.handleDelete}>
                        <span className="glyphicon glyphicon-download-alt" aria-hidden="true"></span>
                    </button>
                </td>
            </tr>
        )
    }
}
