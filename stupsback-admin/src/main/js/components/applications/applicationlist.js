import React from 'react';
import AppConstants from '../../constants/constants';
import Application from './application';

export default class ApplicationList extends React.Component {

  constructor(props){
    super(props);
    this.handleNavFirst = this.handleNavFirst.bind(this);
		this.handleNavPrev = this.handleNavPrev.bind(this);
		this.handleNavNext = this.handleNavNext.bind(this);
		this.handleNavLast = this.handleNavLast.bind(this);
  }

  handleNavFirst(e){
		e.preventDefault();
		this.props.onNavigate(this.props.links.first.href);
	}

	handleNavPrev(e) {
		e.preventDefault();
		this.props.onNavigate(this.props.links.prev.href);
	}

	handleNavNext(e) {
		e.preventDefault();
		this.props.onNavigate(this.props.links.next.href);
	}

	handleNavLast(e) {
		e.preventDefault();
		this.props.onNavigate(this.props.links.last.href);
	}

	render() {
		var applications = this.props.applications.map(application =>
			<Application key={application._links.self.href} application={application} onDelete={this.props.onDelete} />
		);

		var navLinks = [];
		if ("first" in this.props.links) {
			if ("prev" in this.props.links) {
				navLinks.push(<button className="btn btn-default active" key="first" onClick={this.handleNavFirst}>&lt;&lt;</button>);
			}else{
				navLinks.push(<button className="btn btn-default disabled" key="first">&lt;&lt;</button>);
			}
		}
		if ("prev" in this.props.links) {
			navLinks.push(<button className="btn btn-default active" key="prev" onClick={this.handleNavPrev}>&lt;</button>);
		}else{
			navLinks.push(<button className="btn btn-default disabled" key="prev">&lt;</button>);
		}
		if ("next" in this.props.links) {
			navLinks.push(<button className="btn btn-default active" key="next" onClick={this.handleNavNext}>&gt;</button>);
		}else{
			navLinks.push(<button className="btn btn-default disabled" key="next">&gt;</button>);
		}
		if ("last" in this.props.links) {
			if ("next" in this.props.links) {
					navLinks.push(<button className="btn btn-default active" key="last" onClick={this.handleNavLast}>&gt;&gt;</button>);
				}else{
					navLinks.push(<button className="btn btn-default disabled" key="last">&gt;&gt;</button>);
				}
		}

		return (
			<div style={{paddingTop: 15}}>
				<div style={{paddingTop: 15}}>
					<table className="table table-condensed">
						<thead>
							<tr>
								<th>Name</th>
								<th>username</th>
                <th>Password</th>
							</tr>
						</thead>
						<tbody>
							{applications}
						</tbody>
					</table>
				</div>
				<div className="row">
					<div className="col-md-4 col-md-offset-4">
						<nav>
					 		{navLinks}
						</nav>
					</div>
				</div>
			</div>
		)
	}
}
