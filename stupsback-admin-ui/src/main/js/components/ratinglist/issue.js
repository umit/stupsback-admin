import React from 'react';

export default class IssueForm extends React.Component {

  constructor(props) {
    super(props);
  }

  handleSubmit(e){
    e.preventDefault();
    console.log("hier bin ich ");
  }

  render() {
		var inputs = this.props.attributes.map(attribute =>
			<p key={attribute}>
				<input type="text" placeholder={attribute} ref={attribute} className="field" />
			</p>
		);

		return (
			<div>
				<a href="#createIssue">Create</a>

				<div id="createIssue" className="modalDialog">
					<div>
						<a href="#" title="Close" className="close">X</a>

						<h2>Create new Issue</h2>

						<form>
							<button onClick={this.handleSubmit}>Create</button>
						</form>
					</div>
				</div>
			</div>
		)
	}
}
