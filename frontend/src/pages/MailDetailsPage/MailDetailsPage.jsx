import { Component } from "react";
import { withRouter } from 'react-router-dom';
import { compose } from 'redux'
import { connect } from 'react-redux'

import { MDBContainer, MDBRow, MDBCol, MDBAvatar } from 'mdbreact';

import moment from 'moment'


import ReactHtmlParser from 'react-html-parser';

class MailDetailsPage extends Component {


    render() {

        const mail = this.props.currentEmail

        return (

            <MDBContainer>


                <MDBRow className="square border " >

                    <MDBCol size='2'>
                        <MDBAvatar className=' mt-1 mb-1'>
                            <img src={"https://cdn-icons-png.flaticon.com/512/149/149071.png"}
                                alt=""
                                className="rounded-circle z-depth-1 img-fluid" />
                        </MDBAvatar>
                    </MDBCol>

                    <MDBCol size='8'>
                        <div className="mt-4">
                            
                            <p> <b>From:</b> {mail.fromEmailAddress ? mail.fromEmailAddress.name : null}   '{mail.fromEmailAddress ? mail.fromEmailAddress.emailAddress : null}'</p>
                            <p> <b>To: </b> {mail.senderEmailAddress ? mail.senderEmailAddress.name : null} '{mail.senderEmailAddress ? mail.senderEmailAddress.emailAddress : null}' </p>
                            <p> <b>cc: </b> {
                                mail.toRecipients.forEach(element => {
                                    console.log(element)
                                    return  <p> {element.name ? element.name : null } '{element.emailAddress ? element.emailAddress : null}'  </p>
                                })}
                            </p>

                            <p><b>Received at : </b>{
                            moment(new Date(mail.receivedDateTime)).format('LL') }  </p>
                        </div>
                    </MDBCol>
                </MDBRow>

                <MDBRow className="square border " >
                    <MDBCol > <div className="mt-1 mb-1"> <b>Subject :</b> {mail.subject} </div></MDBCol>
                </MDBRow>

                <MDBRow center className="square border" >
                    <MDBCol >
                        <div className="mt-2 mb-2">
                            <p>{ReactHtmlParser(mail.body)}</p>

                        </div>
                    </MDBCol>
                </MDBRow>


            </MDBContainer>
        )
    }
}


const mapStateToProps = (state) => ({
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