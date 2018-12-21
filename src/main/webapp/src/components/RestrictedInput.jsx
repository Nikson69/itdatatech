import React from 'react';

export default class RestrictedInput extends React.Component
{
    constructor(props){
        super(props);
        this.state = {
            value:"",
            error:null
        };
        if(this.props.initialValue)
            this.state.value = this.props.initialValue;
        this.onChange = this.onChange.bind(this);
    }

    onChange(e) {
        const value = e.target.value;
        const validate = this.props.validator;
        const onChange = this.props.onChange;
        if(validate(value)) {
            onChange(value);
            this.setState({value, error: null});
        }else
             this.setState({value, error: this.props.errorMessage});
    }

    render() {
        return (
            <div>
                <input type="text" className={this.state.error?'form-control is-invalid':'form-control'}
                       placeholder={this.props.placeholder}
                       readOnly={this.props.readonly} value={this.state.value} onChange={this.onChange}/>
                {this.state.error&&
                <label className="restriction">{this.state.error}</label>}
            </div>
        );

    }
}