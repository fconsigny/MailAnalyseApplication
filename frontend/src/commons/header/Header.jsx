import routes from "../../routes/Routes";

import BreadCrump from "./HeaderTabs"
import { BrowserRouter as Router, Route, Switch } from "react-router-dom";

const Header = () => {

  return (
    <Router>
      <Route path="/" render={(history) =>

        <div className="header">
          <BreadCrump pageContext={history} />

          <Switch>
            {
              routes.map(({ path, Component }, key) => (
                <Route exact path={path} key={key} component={Component} />
              ))
            }

          </Switch>
        </div>
      } />

    </Router>
  )
};

export default (Header);


