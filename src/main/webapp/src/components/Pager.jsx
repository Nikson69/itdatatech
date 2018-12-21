import React from 'react';
import {getSearchParams, getSearchString} from "../index";

export default class Pager extends React.Component
{
    constructor(props){
        super(props);
        this.onClick = this.onClick.bind(this);
        this.goToPage = this.goToPage.bind(this);
    }

    onClick(e){
        this.goToPage(e)
    }

    goToPage(page){
        const params = getSearchParams();
        if(page < 2)
            delete params.page;
        else
            params.page = page;
        const searchParams =  getSearchString(params);
        window.location = window.location.pathname +(searchParams&&('?'+ getSearchString(params)));
    }

    render() {
        const { current,pages } = this.props;
        return (
            <div className="btn-group">
                <button type="button" className="btn btn-sm btn-outline-secondary" onClick={() => this.onClick(1)}>{'<<'}</button>
                {[...Array(5).keys()].map((e)=> e-2+current).map((e)=> ((e > 0) && (e <= pages)) &&
                    <button type="button" className="btn btn-sm btn-outline-secondary" key={e} onClick={() => this.onClick(e)}>{e}</button>
                )}
                <button type="button" className="btn btn-sm btn-outline-secondary" onClick={() => this.onClick(pages)}>{'>>'}</button>
            </div>
        );
    }
}