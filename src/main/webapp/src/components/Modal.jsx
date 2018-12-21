import React from 'react';

export default class Modal extends React.Component
{
    constructor(props){
        super(props);
        this.onClose = this.onClose.bind(this);
        document.getElementById('root').classList.add('modal-open');
    }

    onClose(){
        const {onClose} = this.props;
        document.getElementById('root').classList.remove('modal-open');
        onClose && onClose();
    }

    render() {

        return (
            <div>
                <div className="modal fade show" tabIndex="-1" role="dialog"
                     style={{paddingRight: '15px', display: 'block', width:'auto'}}>
                    <div className="modal-dialog" role="document">
                        <div className="modal-content">
                            <div className="modal-header"><h5 className="modal-title">{this.props.title}</h5>
                                <button type="button" className="close" data-dismiss="modal" aria-label="Close" onClick={this.onClose}><span
                                    aria-hidden="true">×</span></button>
                            </div>
                            <div className="modal-body">{this.props.children}</div>
                        </div>
                    </div>
                </div>
                <div className="modal-backdrop show" onClick={this.onClose}></div>
            </div>
    );

    }
}