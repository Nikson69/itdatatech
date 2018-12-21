import React from 'react';

export default class HashTags extends React.Component
{
    render() {
        return (
            <div>
                {this.props.categories.split("|").filter((e)=>(e!='')).map((elem) =>( <a key={elem} href={"filter?category="+elem}>#{elem}</a>))}
            </div>
        );
    }
}