import React from 'react';
import Modal from "./Modal.jsx";
import ContentDetails from "./ContentDetails.jsx";

export default class ImagePreivew extends React.Component
{
    constructor(props){
        super(props);
    }

    render() {

        const {content} = this.props;
        this.state;
        return (
            <Modal title={content.name} onClose={this.props.onClose}>
                <ContentDetails content={content} readonly={true} />
            </Modal>
        );

    }
}