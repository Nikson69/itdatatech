import ContentGrid from './components/ContentGrid.jsx';
import {getContent,getContentList} from './api.js';
import ReactDOM from 'react-dom';
import React from "react";
import ContentDetails from "./components/ContentDetails.jsx";
import {Loader} from "./components/Loader.jsx";

const mainContainer = document.getElementById('root');
const role = mainContainer.getAttribute('role');
function clearPageView() {
}

function render(element, container) {
    if(container==null)
        container = document.getElementById('root');
    window.TestComponentRender = ReactDOM.render(
        element,
        container
    );
}

export function createLoader(container) {
    if(container == null)
        render(<Loader/>);
    else
        render(<Loader/>,container);
}

export function loadContentGrid(params) {
    if(params == null)
        params = getSearchParams();
    getContentList((result) => render(<ContentGrid content={result} isAdmin={role==='ADMIN'} />),params);
}

export function loadDetails(id) {
    getContent(getDetails,id);
}


export function getDetails(content) {
    render(<ContentDetails content={content} readonly={false}/>);
}

export function getSearchParams() {
    let params = {};
    window.location.search
        .split('&')
        .map((e)=>e.replace("?","")
            .split("="))
        .forEach((e)=>params[e[0]]=e[1]);
    return params
}

export function getSearchString(params,keys) {
        let searchStr = '';
        if(keys==null)
            keys = ["count", "page","name", "category", "description", "createdBefore", "createdAfter"];
        keys.forEach((key)=>{
            if(params.hasOwnProperty(key))
                searchStr += key+'='+params[key] + "&"
        });
        return searchStr.slice(0,-1);
}

export function createContentImages() {
    return render(
        <ContentDetails readonly={false}/>);
}

function route(path,params) {
    createLoader();
    const paths = path.split('/').filter((e)=>(e!==''));
    if(paths.includes('details'))
        loadDetails(paths.reverse()[0]);
    else if((paths.length===0) ||paths.includes('filter'))
        loadContentGrid(params);
    else if (paths.includes('create'))
        createContentImages();
    else clearPageView();
}

route(window.location.pathname,getSearchParams());


