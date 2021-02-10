import React from "react";
import { Link } from "react-router-dom";

import LoginRemote from "./remote/LoginRemote";

import {setUserSession} from "../utils/Common";
import logo from "../assets/img/logo.png";
import avatar from "../assets/img/avatar.png";

class Girisyap extends React.Component {
  constructor(props) {
    super(props);
    this.state = {
      kullaniciAdi: "",
      sifre: ""
    };
}



buttonClick=()=> {

  
  let response = {
    username: this.state.kullaniciAdi,
    password: this.state.sifre
  };
  LoginRemote.login(response).then(r => {
    if(r){
      setUserSession(r.accessToken, r);
     // this.props.history.push('/anasayfa');
      window.location.reload();
    }

  });
}


render() {
    return (
      <div  className="author-template" >
      <div className="site-wrapper">
              <nav className="main-nav overlay clearfix">
                  <Link to="/anasayfa"><img src={logo} alt="Fashion Critiques" /></Link>
      
              </nav>
      <div className="container"style={{"height":"1100px"}}>
<div className="wrapper fadeInDown" style={{"min-height":"60%"}}>
  <img src={logo} alt="" width="200px"/>
  <img src={avatar} alt="" width="64px"/>
  <div id="formContent">
    
  <Link to="/girisyap" ><h2 className="active"> Giriş Yap </h2></Link>
  <Link to="/kayitol" ><h2 className="inactive underlineHover">Kayıt Ol </h2></Link>

    
    <div className="fadeIn first">
      
    </div>

    
    
      <input type="text" id="login" className="fadeIn second" name="login" placeholder="Kullanıcı Adı" value={this.state.kullaniciAdi} 
      onChange={r=>{
            this.setState({
              kullaniciAdi:r.target.value
            })
      }}/>
  

      <input id="password" type="password" className="fadeIn third" name="login" placeholder="Şifre" value={this.state.sifre} 
      onChange={r=>{
            this.setState({
              sifre:r.target.value
            })
      }}/>
      <div>
      <button className="fadeIn fourth girisbuton"  onClick={this.buttonClick.bind(this)}> Giriş Yap</button>
      </div>
    

    
    

  </div>
</div>
</div>
</div>
</div>
        );
    }
  }
  
export default Girisyap;
  
