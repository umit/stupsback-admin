import React from 'react';
import ReactDOM from 'react-dom';

import Ratings from './ratinglist/ratings';
import Applications from './applications/applications';
import Issues from './issues/issues';

import NoMatch from './nomatch';
import Template from './template';
import { Router, Route, IndexRoute } from 'react-router';

//<Route path="cart" component={ Cart } />}
//<Route path="item/:item" component={ CatalogDetail } />
export default () => {
  return (
    <Router>
      <Route path="/" component={ Template } >
        <IndexRoute component={ Ratings } />
				<Route path="apps" component={ Applications } />
        <Route path="/issues/:appId" component={ Issues } />
        <Route path="*" component={ NoMatch }/>
      </Route>
    </Router>
  );
}
