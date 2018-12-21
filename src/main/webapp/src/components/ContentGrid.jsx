import React from 'react';
import ContentTile from "./ContentTile.jsx";
import Pager from "./Pager.jsx";

export default class ContentGrid extends React.Component
{
    render() {
        const elements = this.props.content.contents;
        return (
            <div className="album py-5 bg-light\">
                {elements.length > 0 &&
                <div className="container">
                    <div className="row">
                        {elements.map((elem) => (
                            <ContentTile key={elem.id} content={elem} isAdmin={this.props.isAdmin}/>))}
                    </div>
                    <div className="row align-items-center justify-content-center">
                        <Pager current={this.props.content.current} pages={this.props.content.pages}/>
                    </div>
                </div>
                }
                {elements.length === 0 &&
                <div className="row align-items-center justify-content-center">
                    <h2>Элементы по вашему запросу не найдены</h2>
                </div>
                }
            </div>
        );
    }
}
