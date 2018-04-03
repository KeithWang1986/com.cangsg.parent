import * as React from 'react';
import ReactDOM from 'react-dom';
import { Button } from 'dd-button';
import { LocaleProvider, LocaleValue, LocaleLabel } from 'dd-locale';
import en_US from 'dd-locale/locales/en_US.js'
import zh_CN from 'dd-locale/locales/zh_CN.js'

import { Provider } from 'react-redux';
import store from './Store.js';

import { view as CitySelector } from './city_selector/';
import { view as Weather } from './weather/';

import { Editor, EditorState } from 'draft-js';

class MyEditor extends React.Component {
    constructor(props) {
        super(props);
        this.state = { editorState: EditorState.createEmpty() };
        this.onChange = (editorState) => this.setState({ editorState });
    }
    render() {
        return (
            <Editor editorState={this.state.editorState} onChange={this.onChange} />
        );
    }
}

class App extends React.Component {
    constructor(props, context) {
        super(props, context);
        this.state = {
            "locale": zh_CN
        }
    }

    OnClick(locale) {
        this.setState({
            "locale": locale
        });
        fetch("/api/select").then((response) => {
            if (response.status !== 200) {
                throw new Error('Fail to get response with status ' + response.status);
            }
            response.json().then((responseJson) => {
                console.log(responseJson.userName);
            }).catch((error) => {
                console.log("");
            });
        }).catch((error) => {
            console.log("");
        });
    }
    render() {
        return (
            <div>
                <Provider store={store}>
                    <LocaleProvider locale={this.state.locale}>
                        {/* <CitySelector />
                        <Weather /> */} 
                        <MyEditor />
                        <h1>1234</h1>
                        <Button value="Button.confirm" onClick={(props, e) => this.OnClick(zh_CN)} />
                        <Button value="Button.cancel" onClick={(props, e) => this.OnClick(en_US)} />
                    </LocaleProvider>
                </Provider>
            </div>
        );
    }
}

ReactDOM.render(<App />, document.getElementById('root'));