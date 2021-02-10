import React from "react";
import Gallery from "react-photo-gallery";
import { Link } from "react-router-dom";
import LoginRemote from "./remote/LoginRemote";


class Kesfet extends React.Component {
  constructor(props) {
    super(props);
    this.state = {
       arama:null,
       aramaList:[]
    }
}

arama(){

  LoginRemote.kullaniciArama(this.state.arama).then(r=>{
    this.setState({
      aramaList:r
    })
  })
}


render() {
    return (
      <div>
      <header className="main-header author-head ">

    
           <div class = "form-group" style={{"margin-top":"80px"}}>
      <input name = "title" type = "text" id = "title" className = "form-control" style={{"width": "99%"}} placeholder = "Tam Olarak Neyi Aramıştınız?" value={this.state.arama} 
      onChange={r=>{
        this.setState({
          arama:r.target.value
        })
      }}></input>
      </div>
      <div class = "form-group">
      <button  id = "submit" className = "btn-primary col-xs-offset-3 col-xs-6 col-sm-6 col-sm-offset-3" style={{"max-width": "96%", "height":"50px", "font-size":"2rem"}} onClick={this.arama.bind(this)} >Ara</button>
      </div>
         
      </header>
      <dl className="list maki">
        <dt>Kullanıcılar</dt>
        <dd>{this.state.aramaList.map(r=>{
           return <Link to={"/profil/"+r.id}>{r.adSoyad}</Link>
         })}  
          
          </dd>
        
    </dl>
      
      </div>
        );
    }
  }
  
export default Kesfet;
  
