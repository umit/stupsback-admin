import React from 'react';

export default class NoMatch extends React.Component {

  constructor(props){
    super(props);
  }

  render(){
    return (
      <div>
        <h2>{`Whatever you were looking for, we didn't found it`}</h2>
      </div>
    )
  }
}
