import React from "react";
import { Component } from "react";

import { MDBContainer, MDBRow, MDBAvatar, MDBCol } from 'mdbreact';

import { Bar } from "react-chartjs-2";
import { Pie } from 'react-chartjs-2';

import { connect } from 'react-redux'

import { getEmails } from "../../configs/mailapis";

import moment from 'moment'



const backColours = ["#ef5350", "#ec407a", "#ab47bc", "#7e57c2", "#5c6bc0", "#42a5f5", "#03a9f4", "#29b6f6", "#26c6da", "#66bb6a", "#9ccc65", "#d4e157", "#ffee58", "#ffca28", "#ffa726", "#ff7043", "#8d6e63", "#bdbdbd", "#78909c"]

class UserMailAnalyticsPage extends Component {

  componentDidMount() {
    this.props.loadEmails(this.props.currentUser.id)
  }

  render() {

    const { mails } = this.props.mails
    const currentUser = this.props.currentUser

    let keyFromEmailAddress = "fromEmailAddress"

    const mailDatasFromEmailAddress = this.findOcc(mails, keyFromEmailAddress);
    const datasFromEmailAddress = mailDatasFromEmailAddress.sort((a, b) => a.fromEmailAddress.localeCompare(b.fromEmailAddress)).map(mail => mail.occurrence);
    const labelsFromEmailAddress = [...new Set(mailDatasFromEmailAddress.sort((a, b) => a.fromEmailAddress.localeCompare(b.fromEmailAddress)).map(mail => mail.fromEmailAddress))]; // [ 'A', 'B']

    const graphDataFromEmailAddress = {
      labels: labelsFromEmailAddress,
      datasets: [
        {
          data: datasFromEmailAddress,
          backgroundColor: backColours
        }
      ]
    }

    
    for(let i = 0 ; i < mails.length  ; i++) {
      mails[i].receivedDateTime = this.dateConverter(mails[i].receivedDateTime)
    }

    let keyReceivedDateTime = "receivedDateTime"
    const mailDatasReceivedDateTime = this.findOcc(mails, keyReceivedDateTime);
    const datasReceivedDateTime = mailDatasReceivedDateTime.sort((a, b) =>  a.receivedDateTime > b.receivedDateTime).map(mail => mail.occurrence)
    const labelsReceivedDateTime = [...new Set(mailDatasReceivedDateTime.sort((a, b) => a.receivedDateTime > b.receivedDateTime).map(mail =>mail.receivedDateTime))]

    const graphReceivedDateTime = {
      labels: labelsReceivedDateTime,
      datasets: [
        {
          data: datasReceivedDateTime,
          backgroundColor: backColours
        }
      ]
    }

    let keyMailRead  = "isRead"
    const mailDatasIsRead = this.findOcc(mails, keyMailRead);
    const datasIsRead = mailDatasIsRead.sort((a,b) => Number(a) - Number(b)).map(mail => mail.occurrence)
    const labelsIsRead =  ["Mails lus","mails non lus"]

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


        <MDBRow className="square border " size='3'>

          <MDBCol size="6">
            <ChoresChartPie data={graphDataFromEmailAddress} options={options} width={"30%"} />
          </MDBCol>

          <MDBCol size="6">
            <ChoresChartPie data={graphIsRead} options={options} width={"30%"} />
          </MDBCol>

          </MDBRow>
          <MDBRow className="square border " size='3'>

          <MDBCol size="6">
            <ChoresChartBar data={graphReceivedDateTime} options={options} width={"30%"} />
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

   dateConverter(date) {
    return moment(new Date(date)).format('LL')
  }

}

const ChoresChartBar = (props) => {
  const data = props.data
  const options = props.options

  return (
    <Bar data={data} options={options} />
  )
}

const ChoresChartPie = (props) => {
  const data = props.data
  const options = props.options

  return (
    <Pie data={data} options={options} />
  )
}

const mapStateToProps = (state) => (
  {
    currentUser: state.users.currentUser,
    mails: state.mails
  })

const mapDispatchToProps = (dispatch) => {
  return {
    loadEmails: (id) => dispatch(getEmails(id))
  }
}



export default connect(mapStateToProps, mapDispatchToProps)(UserMailAnalyticsPage);