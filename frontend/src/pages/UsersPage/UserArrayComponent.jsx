
import { MDBTable, MDBTableBody, MDBTableHead } from 'mdbreact';


const UserArrayComponent = (props) => {

    return (

        <MDBTable 
        scrollY
        maxHeight="100%"
        sorting={true}
        striped
        >

            <MDBTableHead bordered>
                <tr>
                    <th></th>
                    <th>nom</th>
                    <th>poste</th>
                    <th>telephone</th>
                    <th>email</th>
                    <th>office location</th>
                </tr>
            </MDBTableHead>

            <MDBTableBody>
                {props.users.map(user =>
                    <tr onClick={() => props.onClick(user)} className=" rippleTag='div' className='bg-image hover-overlay'">
                        <td>
                            <img src={user.profilePicture ? user.profilePicture : "https://cdn-icons-png.flaticon.com/512/149/149071.png"}
                                alt=""
                                width="50"
                                height="50"
                                className="rounded-circle z-depth-1 img-fluid" />
                        </td>
                        <td>{user.displayName}</td>
                        <td> <i class="fas fa-user-tie" /> {user.jobTitle}</td>
                        <td> <i class="fas fa-phone" /> {user.mobilePhone}</td>
                        <td> <i class="fas fa-envelope" /> {user.mail}</td>
                        <td> <i class="fas fa-building" /> {user.officeLocation}</td>
                    </tr>
                )}

            </MDBTableBody>
        </MDBTable>
    );

}

export default UserArrayComponent;