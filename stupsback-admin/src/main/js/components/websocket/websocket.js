import React from 'react';

import SockJS from 'sockjs-client';
import Stomp from 'stompjs';

export default class StompClient extends React.Component {

	constructor(props){
		super(props);
	}

	register(registrations) {
		var socket = SockJS('/feedback-stomp');
		var stompClient = Stomp.over(socket);
		stompClient.connect({}, function(frame) {
			registrations.forEach(function (registration) {
				stompClient.subscribe(registration.route, registration.callback);
			});
		});
	}
}
