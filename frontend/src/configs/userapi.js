import API from "./apiconfig"

import { GET_USERS, GET_CURRENT_USER } from "../reducers/userReducer";

export const getUsers = () => async dispatch => {

    API.get('/users')
        .then((response) => {
            console.log("users " + response.data)

            dispatch({
                type: GET_USERS,
                payload: response.data
            })
        })

        .catch((error) => {
            console.log(error)
        })
}

export const getCurrentUser = (id) => async dispatch => {

    API.get('/users/' + id)
        .then((response) => {

            dispatch({
                type: GET_CURRENT_USER,
                payload: response.data
            })
        })

        .catch((error) => {
            console.log(error)
        })
}

