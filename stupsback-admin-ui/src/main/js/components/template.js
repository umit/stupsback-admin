import React from 'react';
import Navbar from './header/navbar';
//import Header from './header/header';

//<Header></Header>
export default ( props ) => {
  return (
    <div>
      <Navbar />
      <div className="container">
        { props.children }
      </div>
    </div>
  )
}
