


const initialState = {
    currentMail: null,
    mails: []
}

export const GET_EMAILS = 'GET_EMAILS';
export const SET_CURRENT_MAIL = 'SET_CURRENT_MAIL';
export const UPDATE_EMAIL = 'UPDATE_EMAIL';


export const actionSetCurrentMail = (mail) => {

    return {
        type: SET_CURRENT_MAIL,
        mail
    }
}


export default function mailReducer(state = initialState, action) {
    switch (action.type) {
        case GET_EMAILS:

            console.log('  mail reducer ', action.payload)
            return {
                ...state,
                mails: action.payload
            }
        case SET_CURRENT_MAIL:
            return {
                ...state,
                currentMail: action.mail
            }
        case UPDATE_EMAIL:
            return {
                ...state,
                currentMail: action.mail
            }
        default:
            return state
    }
}