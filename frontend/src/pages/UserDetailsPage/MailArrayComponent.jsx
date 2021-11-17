
import React from "react";
import ReactHtmlParser from 'react-html-parser'; 

import { MDBContainer, MDBAvatar, MDBRow, MDBTable, MDBTableHead, MDBTableBody, MDBBadge, MDBCol, MDBPopover, MDBPopoverBody, MDBPopoverHeader } from 'mdbreact';


const MailArrayComponent = (props) => {
    return (

        <MDBTable>

            <MDBTableHead>

                <tr>
                    <th>subject</th>
                    <th>from</th>
                    <th>preview</th>
                    <th>received</th>


                </tr>

            </MDBTableHead>

            {props.mails.map(email =>




                <tr onClick={() => props.onClick(email)}>

                    <td>{email.subject} {email.isRead ? null : <MDBBadge color="danger" className="ml-2">new</MDBBadge>}</td>
                    <td>{email.fromEmailAddress}</td>
                    <td numberOfLines={1} >{email.bodyPreview.length < 35 ? email.bodyPreview : email.bodyPreview.substring(0, 32)}...  </td>
                    <td>{new Date(email.receivedDateTime).toLocaleString()}</td>
                </tr>



            )}

            <MDBTableBody>





            </MDBTableBody>
        </MDBTable>
    );
}

export default MailArrayComponent;