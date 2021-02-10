import React from "react";
import Gallery from "react-photo-gallery";

import {getUser} from "../utils/Common";
import LoginRemote from "./remote/LoginRemote";


class Profil extends React.Component {
  constructor(props) {
    super(props);
    this.state = {
        photos : [ ]
    }
}



componentDidMount() {
  console.log(this.state.photos)
  LoginRemote.gonderiGetir(getUser().id).then(r=>{
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

  })
}




render() {
    return (

    <span>
        <header className="main-header author-head ">
            <section className="author-profile ">
               
                
                <h1 className="author-title">{getUser().ad_soyad}</h1>
                <h2 className="author-bio">{"@" + getUser().username}&nbsp;</h2>
                <div className="author-meta">
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
  
