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
    }
    render() {
        return (
            <div>
                <Provider store={store}>
                    <LocaleProvider locale={this.state.locale}>
                        <CitySelector />
                        <Weather />
                        <h1>123</h1>
                        <Button value="Button.confirm" onClick={(props, e) => this.OnClick(zh_CN)} />
                        <Button value="Button.cancel" onClick={(props, e) => this.OnClick(en_US)} />
                    </LocaleProvider>
                </Provider>
            </div> 
        );
    }
}

ReactDOM.render(<App />, document.getElementById('root'));