import React from 'react';
import LikeButton from '../like/likeButton';
import Icon from 'react-fa';

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
        if ("thumbsUps" in this.props.rating._links) {
            href = this.props.rating._links.thumbsUps.href;
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

                    <LikeButton likeAssociationUri={href} ratingUri={this.props.rating._links.self.href}/>
                    <button className="btn btn-default" onClick={this.handleDelete}>
                        <Icon name='github-square'/>
                    </button>
                    <button className="btn btn-default" onClick={this.handleDelete}>
                        <span className="glyphicon glyphicon-download-alt" aria-hidden="true"></span>
                    </button>
                </td>
            </tr>
        )
    }
}
