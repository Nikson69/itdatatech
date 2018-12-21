import React from 'react';

export default class BlockInput extends React.Component
{
    constructor(props){
        super(props);
        this.state = {
            value:"",
            error:null,
            blocks:[]
        };
        if(this.props.categories)
            this.state.blocks = this.props.categories.split('|').filter((e)=>e!=='');
        this.onChange = this.onChange.bind(this);
        this.addBlock = this.addBlock.bind(this);
        this.removeBlock = this.removeBlock.bind(this);
        this.updateFormattedValue = this.updateFormattedValue.bind(this);
    }

    addBlock(value){
        const {blocks} = this.state;
        const index = blocks.indexOf(value);
        if (index !== -1) return;
        const newBlocks =  blocks.slice();
        newBlocks.push(value);
        this.setState({blocks:newBlocks});
        this.updateFormattedValue(newBlocks);
    }

    removeBlock(block){
        const {blocks} = this.state;
        const newBlocks =  blocks.slice();
        var index = newBlocks.indexOf(block);
        if (index !== -1) newBlocks.splice(index, 1);
        this.setState({blocks:newBlocks});
        this.updateFormattedValue(newBlocks);
    }

    updateFormattedValue(blocks){
        const formattedValue = '|'+ blocks.join('|')+'|';
        this.props.onChange(formattedValue);
        this.setState({formattedValue});
    }

    onChange(e) {
        let value = e.target.value;
        if(value.substr(0,1)===' ')
            value = value.slice(1);
        if(value.substr(-1) === ' ') {
           this.addBlock(value.slice(0, -1));
           this.setState({value: ""});
        }else
           this.setState({value});
    }


    render() {
        return(
        <div className="form-control"  style={this.props.readonly?{border:0, padding:0}:{}}>
                {this.state.blocks.map((e)=>(
                <div className="DIV_3" key={e}>
                    <div className="DIV_4">{'#'+ e}</div>
                    {!this.props.readonly &&
                    <div className="DIV_5" onClick={()=>this.removeBlock(e)}/>}
                </div>
               ))}
            {!this.props.readonly &&
                <input type="text"  className='DIV_3 DIV_4' onChange={this.onChange} value={this.state.value}/>}
            <input type="text" className="d-none" id={this.props.id} value={this.state.formattedValue} readOnly={true}/>
            </div>);

    }
}