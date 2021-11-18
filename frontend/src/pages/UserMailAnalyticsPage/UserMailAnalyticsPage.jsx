import { Component } from "react";

import { MDBContainer, MDBRow, MDBAvatar, MDBCol } from 'mdbreact';

import { ChartBar, ChartPie } from './CharComponent'


import { connect } from 'react-redux'

import { getEmails, getEmailSended } from "../../configs/mailapis";

import moment from 'moment'

const backColours = ["#ef5350", "#ec407a", "#ab47bc", "#7e57c2", "#5c6bc0", "#42a5f5", "#03a9f4", "#29b6f6", "#26c6da", "#66bb6a", "#9ccc65", "#d4e157", "#ffee58", "#ffca28", "#ffa726", "#ff7043", "#8d6e63", "#bdbdbd", "#78909c"]

class UserMailAnalyticsPage extends Component {

  componentDidMount() {
    this.props.loadEmails(this.props.currentUser.id)
    this.props.loadSendedEmails(this.props.currentUser.id, this.props.currentUser.mail);
  }

  render() {

    const { mails } = this.props.mails
    const currentUser = this.props.currentUser
    const emailSended = this.props.emailSended

    let keyFromEmailAddress = "name"

    var emails = mails.map(element => {
      console.log(element.fromEmailAddress)
      return element.fromEmailAddress
    })


    const mailDatasFromEmailAddress = this.findOcc(emails, keyFromEmailAddress);
    const datasFromEmailAddress = mailDatasFromEmailAddress.sort((a, b) => a.name.localeCompare(b.name)).map(mail => mail.occurrence);
    const labelsFromEmailAddress = [...new Set(mailDatasFromEmailAddress.sort((a, b) => a.name.localeCompare(b.name)).map(mail => mail.name))]; // [ 'A', 'B']

    const graphDataFromEmailAddress = {
      labels: labelsFromEmailAddress,
      datasets: [
        {
          data: datasFromEmailAddress,
          backgroundColor: backColours
        }
      ]
    }


    for (let i = 0; i < mails.length; i++) {
      mails[i].receivedDateTime = this.dateConverter(mails[i].receivedDateTime)
    }

    let keyReceivedDateTime = "receivedDateTime"
    const mailDatasReceivedDateTime = this.findOcc(mails, keyReceivedDateTime);
    const datasReceivedDateTime = mailDatasReceivedDateTime.sort((a, b) => a.receivedDateTime > b.receivedDateTime).map(mail => mail.occurrence)
    const labelsReceivedDateTime = [...new Set(mailDatasReceivedDateTime.sort((a, b) => a.receivedDateTime > b.receivedDateTime).map(mail => mail.receivedDateTime))]

    const graphReceivedDateTime = {
      labels: labelsReceivedDateTime,
      datasets: [
        {
          data: datasReceivedDateTime,
          backgroundColor: backColours
        }
      ]
    }

    let keyMailRead = "isRead"
    const mailDatasIsRead = this.findOcc(mails, keyMailRead);
    const datasIsRead = mailDatasIsRead.sort((a, b) => Number(a) - Number(b)).map(mail => mail.occurrence)
    const labelsIsRead = ["Mails lus", "mails non lus"]

    const graphIsRead = {
      labels: labelsIsRead,
      datasets: [
        {
          data: datasIsRead,
          backgroundColor: backColours
        }
      ]
    }


    const options = {
      title: {
        display: true,
        text: "Chore Distribution for this Month",
        fontFamily: "Roboto",
        fontSize: 20,
      }
    }

    return (
      <MDBContainer>

        <MDBRow className="square border " >


          <MDBCol size='2' >

            <MDBAvatar className=' mt-1 mb-1'>
              <img src={currentUser.profilePicture ? currentUser.profilePicture : "https://www.pngkit.com/png/detail/128-1280585_user-icon-fa-fa-user-circle.png"}
                alt=""
                className="rounded-circle z-depth-1 img-fluid" />

            </MDBAvatar>

          </MDBCol>

          <MDBCol size="7" >

            <div className="mt-4">
              <h3 className="font-weight-bold dark-grey-text">   {currentUser.displayName} </h3>

              <p> <i class="fas fa-user-tie" /> {currentUser.jobTitle}  </p>
              <p>  <i class="fas fa-envelope" />  {currentUser.mail} </p>
            </div>

          </MDBCol>

        </MDBRow>


        <MDBRow className="square border " size='6'>

          <MDBCol size="6">
            <h2>Conversations </h2>
            <ChartPie data={graphDataFromEmailAddress} options={options} width={"30%"} />
          </MDBCol>

          <MDBCol size="6">
            <h2>Unread Conversations </h2>
            <ChartPie data={graphIsRead} options={options} width={"30%"} />
          </MDBCol>

        </MDBRow>
        <MDBRow className="square border " size='3'>

          <MDBCol size="6">
            <h2>Received Frequency </h2>
            <ChartBar data={graphReceivedDateTime} options={options} width={"30%"} />
          </MDBCol>

          <MDBCol size="6">
            <p>Mails envoyés : {emailSended.length}</p>
            <p>Mails Recus : {mails.length}</p>
          </MDBCol>


        </MDBRow>

      </MDBContainer>
    )
  }

  findOcc(arr, key) {
    let arr2 = [];


    arr.forEach((x) => {

      // Checking if there is any object in arr2
      // which contains the key value
      if (arr2.some((val) => { return val[key] == x[key] })) {

        // If yes! then increase the occurrence by 1
        arr2.forEach((k) => {
          if (k[key] === x[key]) {
            k["occurrence"]++
          }
        })

      } else {
        // If not! Then create a new object initialize 
        // it with the present iteration key's value and 
        // set the occurrence to 1
        let a = {}
        a[key] = x[key]
        a["occurrence"] = 1
        arr2.push(a);
      }
    })

    return arr2
  }

  filterMailDataByFromEmailAddress(email, key) {

  }

  filterMailDataByReceivedDateTime(email, key) {

  }

  filterMailDatasByIsRead(email, key) {

  }

  dateConverter(date) {
    return moment(new Date(date)).format('LL')
  }



}


const mapStateToProps = (state) => (
  {
    currentUser: state.users.currentUser,
    mails: state.mails,
    emailSended: state.mails.emailSended
  })

const mapDispatchToProps = (dispatch) => {
  return {
    loadEmails: (id) => dispatch(getEmails(id)),
    loadSendedEmails: (id, userEmail) => dispatch(getEmailSended(id, userEmail))
  }
}



export default connect(mapStateToProps, mapDispatchToProps)(UserMailAnalyticsPage);