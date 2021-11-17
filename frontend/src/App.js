import React from "react";

import "./index.css";

import { createStore, applyMiddleware } from 'redux'
import { Provider } from 'react-redux'

import { composeWithDevTools } from 'remote-redux-devtools'

import thunk from "redux-thunk";
import reduxThunk from "redux-thunk";

import rootReducer from './reducers/reducers.js'

import Header from "./commons/header/Header";

const middleware = [thunk, reduxThunk];
const composeEnhancers = composeWithDevTools({ realtime: true, host: 'localhost', port: 3000 });
const store = createStore(rootReducer, composeEnhancers(applyMiddleware(...middleware)));

const App = () => {
  return (

    <Provider store={store}>
      <Header />
    </Provider>
  );

}

export default App;
