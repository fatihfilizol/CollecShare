import React from "react";
import { Link } from "react-router-dom";
import logo from "../assets/img/logo.png";
import avatar from "../assets/img/avatar.png";
import LoginRemote from "./remote/LoginRemote";

class Kayitol extends React.Component {
  constructor(props) {
    super(props);
    this.state = {
      kullaniciAdi: null,
      adSoyad:null,
      eposta:null,
      sifre:null
    }
}

kayitOl(){
  let response={
    ad_soyad: this.state.adSoyad,
    username: this.state.kullaniciAdi,
    email:this.state.eposta,
    password:this.state.sifre
  };
  LoginRemote.signup(response).then(r=>{
    console.log(r.message);
    
      alert(r.message);   
  })
}


render() {
    return (
      <div  className="author-template" >
      <div className="site-wrapper">
              <nav className="main-nav overlay clearfix">
                  <Link to="/anasayfa"><img src={logo} alt="Fashion Critiques" /></Link>
      
              </nav>
      <div className="container"style={{"height":"1100px"}}>
<div className="wrapper fadeInDown" style={{"min-height":"70%"}}>
  <img src={logo} alt="" width="200px"/>
  <img src={avatar} alt="" width="64px"/>
  <div id="formContent">
    
    <Link to="/girisyap" ><h2 className="inactive underlineHover"> Giriş Yap </h2></Link>
    <Link to="/kayitol" ><h2 className="active">Kayıt Ol </h2></Link>

    
    <div className="fadeIn first">
      
    </div>

    
    
      <input type="text" id="login" className="fadeIn second" name="login" placeholder="Kullanıcı Adı" value={this.state.kullaniciAdi} onChange={(r)=>{
        this.setState({
          kullaniciAdi:r.target.value
        })
      }}/>
      <input type="text" id="login" className="fadeIn second" name="login" placeholder="Ad Soyad" value={this.state.adSoyad} onChange={(r)=>{
        this.setState({
          adSoyad:r.target.value
        })
      }}/>
      <input type="text" id="login" className="fadeIn second" name="login" placeholder="E Posta" value={this.state.eposta} onChange={(r)=>{
        this.setState({
          eposta:r.target.value
        })
      }}/>

      <input type="password" id="password" className="fadeIn third" name="login" placeholder="Şifre" value={this.state.sifre} onChange={(r)=>{
        this.setState({
          sifre:r.target.value
        })
      }}/>
      <button  className="fadeIn fourth girisbuton"  onClick={this.kayitOl.bind(this)}>Kayıt Ol</button>
    

    
    
    </div>
    </div>
    </div>
  </div>
</div>
        );
    }
  }
  
export default Kayitol;
  
