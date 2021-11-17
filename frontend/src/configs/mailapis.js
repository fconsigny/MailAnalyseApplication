import API from "./apiconfig"


import { GET_EMAILS , UPDATE_EMAIL}  from "../reducers/mailReducer";


export const getEmails = (userId) => async dispatch => {

    API.get('/users/'+ userId +'/emails')
        .then((response) => {

            console.log("email " + response.data)
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

    const url = '/users/'+ userId +'/emails/' + email.id

    console.log( " email to update " + email.isRead )
    console.log( " email to update " + email.id )
    API.patch(url, email) 
    .then((response) => {

        console.log("email " + response.data)
        console.log("email " + response.data.email)
        console.log("email " + response.data.email.email)
        dispatch({
            type: UPDATE_EMAIL,
            payload: response.data.email
        })
    })

    .catch((error) => {
        console.log(error)
    })
}