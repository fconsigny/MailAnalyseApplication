
import UsersPage from './../pages/UsersPage/UsersPage';
import UserDetailsPage from './../pages/UserDetailsPage/UserDetailsPage';
import UserMailAnalyticsPage from './../pages/UserMailAnalyticsPage/UserMailAnalyticsPage';
import MailDetailsPage from '../pages/MailDetailsPage/MailDetailsPage';

const routes = [

    { path: "/users", name: "users", Component: UsersPage },
    { path: "/users/:userId", name: "users details", Component: UserDetailsPage },
    { path: "/users/details/stats", name: "stats", Component: UserMailAnalyticsPage },
    { path: "/users/details/mails", name: "email", Component: MailDetailsPage}
]

export default routes;