'use strict';

const React = require('react');
const client = require('./client');

const follow = require('./follow');

const root = '/api';

class App extends React.Component {
	render(){
		return (
			<h2>Hello World</h2>
		);
	}
}

React.render(
	<App />,
	document.getElementById('react')
)
