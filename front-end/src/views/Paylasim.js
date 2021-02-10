import React from "react";
import swal from "sweetalert";
import { getUser } from "../utils/Common";
import LoginRemote from "./remote/LoginRemote";


class Paylasim extends React.Component {
  constructor(props) {
    super(props);
    this.state = {
        tasarim:null,
        aciklama:null
    }
}

gorselEkle(){
    const formData = new FormData();
    formData.append('file', this.state.tasarim);
    LoginRemote.saveTasarim(formData);
    
    let response={
        kullaniciId:{id:getUser().id},
        gorsel:this.state.tasarim.name,
        aciklama:this.state.aciklama


    };
    console.log(response);
    LoginRemote.gonderilerEkle(response).then(r=>{
        if(r.id) {
            swal("Paylaşım yapıldı");
        }
    })
    

}


render() {
    return (
       

           <div className="container mt-5 " style={{"font-size": "20px"}}>
         
                <div className="row mt-5">
                    <div className="col-md-6 ">
                    <input type="file"  accept="image/*"   className="w-100 h-100"   id="inputGroupFile01"  onChange={r => {
                                      this.setState({
                                        tasarim: r.target.files[0]
                                      })
                                    }}
                                    aria-describedby="inputGroupFileAddon01"
                                    />
                       
    
                    </div>
                <div className="col-md-6 mt-5">
                    <form>

                        <div className="form-group">
                        
                            <textarea className="form-control"  style={{"font-size": "20px"}} placeholder="Açıklama Ekle" 
                            id="exampleFormControlTextarea1" rows="20" value={this.state.aciklama} onChange={r=>{
                                this.setState({
                                    aciklama:r.target.value
                                })
                            }}></textarea>
                        </div>
                    </form>
                </div>
                <div className="col-md-12 mt-5">
                    <button type="button" style={{"font-size":"30px"}}
                        className="btn btn-primary btn-lg btn-block" onClick={this.gorselEkle.bind(this)}>Paylaş</button>

                </div>
            </div>
           
        </div>
    
        );
    }
  }
  
export default Paylasim;
  
