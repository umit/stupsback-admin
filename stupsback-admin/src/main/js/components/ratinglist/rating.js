import React from 'react';
import LikeButton from 'components/like/likeButton';
import GithubButton from 'components/github/githubButton';
//import IssueForm from './issue';

/**<button  className="btn btn-default" onClick={this.handleDelete}>
    <Icon name='github-square'/>
</button>**/
export default class Rating extends React.Component {

    constructor(props) {
        super(props);
        this.handleDelete = this.handleDelete.bind(this);
        this.handleOnIssue = this.handleOnIssue.bind(this);
    }

    handleDelete() {
        this.props.onDelete(this.props.rating);
    }

    handleOnIssue(){
      window.location = '#issue';
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
                <td>{this.props.rating.comment}</td>
                <td>{this.props.rating.commenter}</td>
                <td>17.12.2015</td>
                <td>Open</td>
                <td>n.A.</td>
                <td>
                    <LikeButton likeAssociationUri={href} ratingUri={this.props.rating._links.self.href}/>
                    <GithubButton appId={this.props.rating.appId} />
                    <button className="btn btn-default" onClick={this.handleDelete}>
                        <span className="glyphicon glyphicon-download-alt" aria-hidden="true"></span>
                    </button>
                </td>
            </tr>
        )
    }
}
