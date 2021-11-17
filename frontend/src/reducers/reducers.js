

import { combineReducers } from 'redux'

import userReducer from './userReducer';
import mailReducer from './mailReducer';

const  rootReducer = combineReducers({  users: userReducer, mails: mailReducer })
export default rootReducer;
