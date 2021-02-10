import React from "react";
import './App.css';
import 'bootstrap/dist/css/bootstrap.min.css';
import {BrowserRouter as Router, Switch,  Route, Redirect} from "react-router-dom";

import Anasayfa from './views/Anasayfa';
import Bildirim from './views/Bildirim';
import Girisyap from './views/Girisyap';
import Kayitol from './views/Kayitol';
import Kesfet from './views/Kesfet';
import Paylasim from './views/Paylasim';
import Profil from './views/Profil';
import YabanciProfil from './views/YabanciProfil';
import DefaultLayout from './layouts/defaultLayout';
import withTracker from './withTracker';
import PublicRoute from './layouts/PublicRoute';
import PrivateRoute from './layouts/PrivateRoute';

import {createBrowserHistory} from "history";

const hist=createBrowserHistory();


class App extends React.Component {
  constructor(props) {
    super(props);
    this.state = {
    }
  }


render(){
  const basename = process.env.NODE_ENV === 'development' ? '/' : ('/');
  return (
    <Router basename={basename} history={hist}   >
        <Switch>
       
        <PrivateRoute path="/anasayfa" component={withTracker(props => {
            return (
              <DefaultLayout >
                <Anasayfa/>
              </DefaultLayout>
            );
          })}/>
          <PrivateRoute path="/bildirim" component={withTracker(props => {
            return (
              <DefaultLayout >
                <Bildirim/>
              </DefaultLayout>
            );
          })}/>
          
          <PublicRoute path="/girisyap" component={withTracker(props => {
            return (
                <Girisyap/>
            );
            
          })}/>
          <PublicRoute path="/kayitol" component={withTracker(props => {
            return (
              
                <Kayitol/>
              
            );
          })}/>
          <PrivateRoute path="/kesfet" component={withTracker(props => {
            return (
              <DefaultLayout >
                <Kesfet/>
              </DefaultLayout>
            );
          })}/>
           <PrivateRoute path="/profil/:id" component={withTracker(props => {
            return (
              <DefaultLayout >
                <YabanciProfil {...props}/>
              </DefaultLayout>
            );
          })}/>
          <PrivateRoute path="/paylasim" component={withTracker(props => {
            return (
              <DefaultLayout >
                <Paylasim/>
              </DefaultLayout>
            );
          })}/>
          <PrivateRoute path="/profil" component={withTracker(props => {
            return (
              <DefaultLayout >
                <Profil/>
              </DefaultLayout>
            );
          })}/>
          <PublicRoute path="/" component={withTracker(props => {
            return (
                <Girisyap/>
            );
            
          })}/>


          

          </Switch>
        </Router>

    
  );
}
}

export default App;
