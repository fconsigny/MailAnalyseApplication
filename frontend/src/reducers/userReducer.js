import { User } from "../models/User";


const initialState = {
    currentUser: null,
    users: []
}

export const GET_USERS = 'GET_USERS';
export const GET_CURRENT_USER = 'GET_CURRENT_USER';
export const SET_CURRENT_USER = 'SET_CURRENT_USER';

export const  actionSetCurrentUser = (user) =>  {

    return {
        type: SET_CURRENT_USER,
        user
      }
} 


export default function userReducer(state = initialState, action) {
    switch (action.type) {
        case GET_USERS:
            return {
                ...state,
                users: action.payload
            }
        case GET_CURRENT_USER:
            return {
                ...state,
                currentUser: action.payload
            }
        case SET_CURRENT_USER: 
            return {
                ...state, 
                currentUser: action.user
            }
        default:
            return state
    }
}