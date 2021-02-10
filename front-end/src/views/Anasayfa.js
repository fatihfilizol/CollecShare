import React from "react";
import { getUser } from "../utils/Common";
import LoginRemote from "./remote/LoginRemote";


class Anasayfa extends React.Component {
  constructor(props) {
    super(props);
    this.state = {
        paylasim: []
    }
}


componentDidMount() {

    let ary=LoginRemote.anasayfa(getUser().id).then((r)=>{
        r.map((t,i)=>{
            LoginRemote.getImage(t.gorsel).then(y=>{
                let image;
                  image = btoa(
                    new Uint8Array(y.data)
                      .reduce((data, byte) => data + String.fromCharCode(byte), '')
                  )
                  //src=`data:${u.headers['content-type'].toLowerCase()};base64,${image}`
                  let array=this.state.paylasim;
                  array.push({
                      adSoyad:t.kullaniciId.adSoyad,
                      aciklama:t.aciklama,
                      id:t.id,
                      src:`data:${y.headers['content-type'].toLowerCase()};base64,${image}`
                  });
                  console.log(array)
                  this.setState({
                      paylasim:array
                  })
                 
           })
        });
    

    });
   

           
    
}

render() {
    return (
       

            <center>
                {this.state.paylasim.map(r=>{
                     return <div className="paylasim">
                     <label className="textAd"><ins>{r.adSoyad}</ins></label>
                     <hr/>
                     <div>
                    <img src={r.src}/>
                    </div>
                    <hr/>
                     <label className="textAciklama">{r.aciklama}</label>
                     <hr/>
                 </div>
                })}
               
               

            </center>

        );
    }
  }
  
export default Anasayfa;
  
