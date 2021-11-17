import React, { Component } from "react";

import { connect } from 'react-redux'

import { getUsers } from "../../configs/userapi";
import { actionSetCurrentUser } from '../../reducers/userReducer';

import { MDBContainer } from 'mdbreact';

import UserArrayComponent from './UserArrayComponent';


class UsersPage extends Component {

    componentDidMount() {
        this.props.loadUsers()
    }

    onUserClick = (user) => {
        let url = "/users/details";
        this.props.actionSetCurrentUser(user);
        this.props.history.push(url);
    }

    render() {
        const { users } = this.props.users

        return (

            <MDBContainer>

                <UserArrayComponent
                    users={users}
                    onClick={this.onUserClick} />

            </MDBContainer>
        )
    }
}

const mapStateToProps = (state) => ({
    users: state.users
})

const mapDispatchToProps = (dispatch) => ({
    loadUsers: () => (dispatch(getUsers())),
    actionSetCurrentUser: (user) => dispatch(actionSetCurrentUser(user))
})

export default connect(mapStateToProps, mapDispatchToProps)(UsersPage)

