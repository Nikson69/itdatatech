import React from "react";
import HashTags from "./HashTags.jsx";
import {deleteContent} from "../api";
import {getDetails, loadContentGrid} from "../index"; //TODO: refactor dat shit
import ImagePreivew from "./ImagePreivew.jsx";

export default class ContentTile extends React.Component {

    constructor(props){
        super(props);
        this.onEditClick = this.onEditClick.bind(this);
        this.onDeleteClick = this.onDeleteClick.bind(this);
        this.onClosePreview = this.onClosePreview.bind(this);
        this.preview = this.preview.bind(this);
        this.state = {
            preview : false
        }
    }



    onEditClick() {
        history.pushState(null,null,'/details/'+this.props.content.id);
        getDetails(this.props.content);
    };

    onDeleteClick() {
        deleteContent(()=>loadContentGrid(),this.props.content.id);
    };

    preview() {
        this.setState({preview:true});
    }

    onClosePreview() {
        this.setState({preview:false});
    }

    render() {
        const paddingBottom  = {paddingBottom:'15px'};
        return (<div className="col-md-4">
                <div className="card mb-4 box-shadow">
                    <img className="card-img-top" src={this.props.content.path} alt="Thumbnail [100%x225]"
                         data-holder-rendered="true" style={{height: '225px', width: 'auto', display: 'block'}} data-toggle="modal" data-target={"#modal"+this.props.content.id} onClick={this.preview}/>
                    <div className="card-body">
                        <div className="card-text" style={paddingBottom}>{this.props.content.name}</div>
                        <div className="card-text"style={paddingBottom}><HashTags categories = {this.props.content.categories} /></div>
                        <div className="d-flex justify-content-between align-items-center">
                            {this.props.isAdmin &&
                            <div className="btn-group">
                                <button type="button" className="btn btn-sm btn-outline-secondary" onClick={this.onEditClick}>Редактировать</button>
                                    <button type="button" className="btn btn-sm btn-outline-secondary" onClick={this.onDeleteClick}>Удалить</button>
                            </div>}
                            <small className="text-muted">{new Date(this.props.content.created).toLocaleString('ru', {
                                year: 'numeric',
                                month: 'long',
                                day: 'numeric'
                            })}</small>
                        </div> 
                    </div>
                </div>
                {this.state.preview &&
                    <ImagePreivew content={this.props.content} onClose = {this.onClosePreview}/>}
            </div>
        );
    }
}
