import React, { Component } from "react";
import { withRouter } from 'react-router-dom';
import { compose } from 'redux'
import { connect } from 'react-redux'

import { MDBContainer, MDBRow, MDBCol , MDBAvatar} from 'mdbreact';

import ReactHtmlParser from 'react-html-parser';

class MailDetailsPage extends Component {


    render() {
        const mail = this.props.currentEmail
        console.log(mail)

        console.log(this.props.mails)

        return (

            <MDBContainer>


            <MDBRow className="square border " >

            <MDBCol>
            <MDBAvatar className='mx-auto mb-2'>
                            <img src={ "https://cdn-icons-png.flaticon.com/512/149/149071.png"}
                                alt=""
                                className="rounded-circle z-depth-1 img-fluid" />
                        </MDBAvatar>
            </MDBCol>

            <MDBCol md="8" className="top: 50%">
                <p> {mail.fromEmailAddress}</p>
                <p> À {mail.toRecipients}</p>
            </MDBCol>

            <MDBCol md="2">
            {new Date(mail.receivedDateTime).toDateString()}
            </MDBCol>

            </MDBRow>

            <MDBRow className="square border " >
                   <MDBCol> Subject : {mail.subject}</MDBCol> 
                </MDBRow>

                <MDBRow center className="square border" >
                <p>{ReactHtmlParser(mail.body)}</p>
                </MDBRow>

                
            </MDBContainer>

            

        )
    }
}


const mapStateToProps = (state) => (
    {
        currentEmail: state.mails.currentMail,
        mails: state.mails
    })

const mapDispatchToProps = (dispatch) => {
    return {
        loadEmails: (id) => dispatch(getEmails(id)),
        actionSetCurrentMail: (mail) => dispatch(actionSetCurrentMail(mail))
    }
}

export default compose(withRouter, connect(mapStateToProps, mapDispatchToProps))(MailDetailsPage);