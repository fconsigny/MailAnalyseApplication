import { MDBTable, MDBTableHead, MDBTableBody, MDBBadge } from 'mdbreact';

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

            <MDBTableBody>

                {props.mails.map(email =>
                    <tr key={email.id} onClick={() => props.onClick(email)}>

                        <td>{email.subject} {email.isRead ? null : <MDBBadge color="danger" className="ml-2">new</MDBBadge>}</td>
                        <td>{email.fromEmailAddress ? email.fromEmailAddress.name : null}</td>
                        <td numberoflines={1} >{email.bodyPreview.length < 35 ? email.bodyPreview : email.bodyPreview.substring(0, 32)}...  </td>
                        <td>{new Date(email.receivedDateTime).toLocaleString()}</td>
                    </tr>
                )}

            </MDBTableBody>
        </MDBTable>
    );
}

export default MailArrayComponent;