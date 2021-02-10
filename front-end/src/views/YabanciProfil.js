import React from "react";
import Gallery from "react-photo-gallery";

import {getUser} from "../utils/Common";
import LoginRemote from "./remote/LoginRemote";


class Profil extends React.Component {
  constructor(props) {
    super(props);
    this.state = {
        photos : [ ],
        profil: {},
        takip:false
    }
}



componentDidMount() {
 
  LoginRemote.kullaniciGeit(this.props.match.params.id).then(r=>{
  
      this.setState({
        profil:r[0]
      })
   
  })
  LoginRemote.gonderiGetir(this.props.match.params.id).then(r=>{
      r.map(t=>{
        LoginRemote.getImage(t.gorsel).then(u=>{
          let photo;
          let image;
            photo=this.state.photos;
            console.log(1);
            image = btoa(
              new Uint8Array(u.data)
                .reduce((data, byte) => data + String.fromCharCode(byte), '')
            )
           
            console.log(2);

            photo.push({
              src:`data:${u.headers['content-type'].toLowerCase()};base64,${image}`,
              width: 4,
              height: 3
            })

            console.log(3);
        
            
              this.setState({
                photos: photo
              })
          
              console.log(4);
          
        })
      })

  });

  let kontrol={
    takipEdenId:getUser().id,
    takipEdilenId:this.props.match.params.id
  }
  LoginRemote.takipKontrol(kontrol).then(r=>{
    if(r.id) {
      this.setState({
        takip:true
      })
    }
  })


}


takipEt(){
    let response={
    takipEdenId:{id: getUser().id},
    takipEdilenId:{id:this.props.match.params.id}


    };
    LoginRemote.takipEt(response).then(r=>{
      console.log(r);
      this.componentDidMount();
    })
}



render() {
    return (

    <span>
        <header className="main-header author-head ">
            <section className="author-profile ">
               
                
                <h1 className="author-title">{this.state.profil.adSoyad}</h1>
                <h2 className="author-bio">{"@"+this.state.profil.username}&nbsp;</h2>
                <div className="author-meta">
                    <span className="author-link icon-link"><a href="#"  onClick={!this.takipEt.takip ? this.takipEt.bind(this) : null} >{this.state.takip ? "Takip Ediliyor" : "Takip Et"}</a></span>
                    <span className="author-stats"><i className="icon-stats"></i> Post Sayısı</span>
                </div>
                </section>
        </header>
        <main className="content" role="main">
        <Gallery photos={this.state.photos.length ===0  ? [{
          
          width: 4,
          height: 3
        }] : this.state.photos }  direction={"column"} />
        </main>
        
    </span>

        );
    }
  }
  
export default Profil;
  
