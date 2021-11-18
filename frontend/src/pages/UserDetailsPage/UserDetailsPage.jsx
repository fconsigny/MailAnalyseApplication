import { Component } from "react";

import { connect } from 'react-redux'

import { MDBContainer, MDBAvatar, MDBRow, MDBBtn, MDBCol } from 'mdbreact';

import { actionSetCurrentMail } from '../../reducers/mailReducer';

import { getEmails, updateEmail } from "../../configs/mailapis";

import { withRouter } from 'react-router-dom';
import { compose } from 'redux'
import MailArrayComponent from "./MailArrayComponent";



class UserDetailsPage extends Component {

    state = {
        isOpen: false
    }

    componentDidMount() {

        this.props.loadEmails(this.props.currentUser.id)

        this.onMailClick = this.onMailClick.bind(this)
        this.onNavAnalyzeButtonClick = this.onNavAnalyzeButtonClick.bind(this)

    }

    onMailClick = (mail) => {

        let url = "/users/details/mails";

        if (mail.isRead === false) {
            mail.isRead = true
            this.props.updateEmail(this.props.currentUser.id, mail);
        }

        this.props.actionSetCurrentMail(mail);

        this.props.history.push(url);
        this.setState({ isOpen: true })

    }

    onNavAnalyzeButtonClick = () => {
        let url = "/users/details/stats";
        this.props.history.push(url);
    }

    render() {

        const { mails } = this.props.mails
        const currentUser = this.props.currentUser

        return (
            <MDBContainer>

                <MDBRow className="square border " >

                    <MDBCol size='2'>

                        <MDBAvatar className=' mt-1 mb-1'>
                            <img src={currentUser.profilePicture ? currentUser.profilePicture : "https://cdn-icons-png.flaticon.com/512/149/149071.png"}
                                alt=""
                                className="rounded-circle z-depth-1 img-fluid" />
                        </MDBAvatar>

                    </MDBCol>


                    <MDBCol >
                        <div className="mt-4">

                            <h3 className="font-weight-bold dark-grey-text"> {currentUser.displayName} </h3>

                            <p> <i className="fas fa-user-tie" /> {currentUser.jobTitle}  </p>
                            <p> <i className="fas fa-envelope" />  {currentUser.mail} </p>
                        </div>
                    </MDBCol>

                    <MDBCol size='3'>
                        <div className="mt-5 mr-2">
                            <MDBBtn onClick={() => this.onNavAnalyzeButtonClick()}>Show analyse</MDBBtn>
                        </div>


                    </MDBCol>
                </MDBRow>

                <MDBRow className="square border">
                    <MailArrayComponent
                        mails={mails}
                        onClick={this.onMailClick} />

                </MDBRow>

            </MDBContainer>
        )

    }

}

const mapStateToProps = (state) => (
    {
        currentUser: state.users.currentUser,
        mails: state.mails
    })

const mapDispatchToProps = (dispatch) => {
    return {
        loadEmails: (id) => dispatch(getEmails(id)),
        actionSetCurrentMail: (mail) => dispatch(actionSetCurrentMail(mail)),
        updateEmail: (userId, mail) => dispatch(updateEmail(userId, mail))
    }
}

export default compose(withRouter, connect(mapStateToProps, mapDispatchToProps))(UserDetailsPage);
