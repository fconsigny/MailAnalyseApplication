import API from "./apiconfig"

import { GET_EMAILS, UPDATE_EMAIL, GET_SENDED_EMAILS } from "../reducers/mailReducer";

export const getEmails = (userId) => async dispatch => {

    API.get('/users/' + userId + '/emails')
        .then((response) => {
            dispatch({
                type: GET_EMAILS,
                payload: response.data
            })
        })

        .catch((error) => {
            console.log(error)
        })
}

export const updateEmail = (userId, email) => async dispatch => {

    const url = '/users/' + userId + '/emails/' + email.id
    
    API.patch(url, email)
        .then((response) => {
            dispatch({
                type: UPDATE_EMAIL,
                payload: response.data
            })
        })

        .catch((error) => {
            console.log(error)
        })
}

export const getEmailSended = (userId, userEmail) => async dispatch => {
    const url = '/users/' + userId + '/emails/' + userEmail

    API.get(url)
        .then((response) => {
            dispatch({
                type: GET_SENDED_EMAILS,
                payload: response.data
            })
        })

        .catch((error) => {
            console.log(error)
        })

}