import React from "react";
import {createContent, updateContent} from "../api";
import {loadContentGrid} from "../index";
import RestrictedInput from "./RestrictedInput.jsx";
import BlockInput from "./BlockInput.jsx";
import HashTags from "./HashTags.jsx";

export default class ContentDetails extends React.Component {

    constructor(props) {
        super(props);
        if(this.props.content)
            this.state = {
                id:this.props.content.id,
                name:this.props.content.name,
                description:this.props.content.description,
                path:this.props.content.path,
                categories:this.props.content.categories,
                created:this.props.content.created,
                showImage:true
            };
        else
        this.state = {
            id:undefined,
            name:'',
            description:'',
            path:'',
            categories:'',
            created:'',
            showImage:false
        };
        this.checkLength = this.checkLength.bind(this);
        this.onCreateClick = this.onCreateClick.bind(this);
        this.onEditClick = this.onEditClick.bind(this);
    }

    onCreateClick() {
        const {name,description,path,categories} = this.state;
        if(this.validate({name,description,path,categories}))
            createContent(()=>loadContentGrid(),{name,description,path,categories});
    };

    onEditClick() {
        const {id,name,description,path,categories} = this.state;
        if(this.validate({id,name,description,path,categories}))
            updateContent(()=>loadContentGrid(),{id,name,description,path,categories});
    };

    validate(content){
        return true;
    }

    checkLength(value,length){
        return value.length <= length;
    }


    render() {
        return (
            <div className="form-create-update col-md-8 order-md-1">
                <form className="needs-validation">
                    <input hidden="hidden" type="text" id={this.state.id}/>
                    {this.state.showImage &&
                        <img className="card-img-top" src={this.state.path} data-holder-rendered="true" style={{height: 'auto', width: '100%', display: 'block;'}} onError={()=>this.setState({showImage:false})}/>}
                        <div className="mb-3">
                            <label>Имя картинки</label>
                            <RestrictedInput placeholder="Имя картинки"
                                             validator={ (v) => this.checkLength(v,30)}
                                             errorMessage={"Имя картинки не должно превышать 30 символов"}
                                             onChange={(v)=>this.setState({name:v})}
                                             readonly={this.props.readonly}
                                             initialValue={this.state.name}/>
                        </div>
                        <div className="mb-3">
                            <label>Описание картинки</label>
                            <RestrictedInput placeholder="Описание картинки"
                                             validator={ (v) => this.checkLength(v,100)}
                                             errorMessage={"Описание картинки не должно превышать 100 символов"}
                                             onChange={(v)=>this.setState({description:v})}
                                             readonly={this.props.readonly}
                                             initialValue={this.state.description}/>
                        </div>
                        <div className="mb-3">
                            <label>URL картинки</label>
                            <RestrictedInput placeholder="URL"
                                             validator={ (v) => this.checkLength(v,255)}
                                             errorMessage={"Некорректный URL картинки"}
                                             onChange={(v)=>this.setState({path:v,showImage:true})}
                                             readonly={this.props.readonly}
                                             initialValue={this.state.path}/>
                        </div>
                        <div className="mb-3">
                            <label>Категории</label>
                            {this.props.readonly ?
                                <HashTags categories={this.state.categories}/>
                                :
                                <BlockInput onChange={(v) => this.setState({categories: v})}
                                            readonly={this.props.readonly}
                                            categories={this.state.categories}/>
                            }
                        </div>
                    {this.props.readonly?
                        null
                        :
                        this.props.content ?
                        <button type="button" className="btn btn-primary btn-lg btn-block"
                                onClick={this.onEditClick}>Изменить</button>
                        :
                        <button type="button" className="btn btn-primary btn-lg btn-block"
                                onClick={this.onCreateClick}>Добавить</button>
                    }
                        </form>
            </div>
        )
    }
}
