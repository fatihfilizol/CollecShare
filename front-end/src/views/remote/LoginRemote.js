
import RestConstants from "./RestConstants";
import swal from "sweetalert";
let LoginRemote = {


  login: (responce) => {
    const url = RestConstants.baseUrl+"/api/auth/signin";
    return RestConstants.jPost(url,responce).then(r => r.data).catch(err => {

      LoginRemote.handleError(err);
    });
  },

  signup: (response) => {
    const url = RestConstants.baseUrl+"/api/auth/signup";
    return RestConstants.jPost(url,response).then(r => r.data).catch(err => {

      LoginRemote.handleError(err);
    });
  },

  kullaniciArama: (adi) => {
    const url = RestConstants.baseUrl+"/api/auth/kullanicilar/"+adi;
    return RestConstants.jFetch(url).then(r => r.data).catch(err => {

      LoginRemote.handleError(err);
    });
  },

  takipEt: (response) => {
    const url = RestConstants.baseUrl+"/api/takipEt";
    return RestConstants.jPost(url,response).then(r => r.data).catch(err => {

      LoginRemote.handleError(err);
    });
  },
  takipKontrol: (response) => {
    const url = RestConstants.baseUrl+"/api/takipKontrol";
    return RestConstants.jPost(url,response).then(r => r.data).catch(err => {

      LoginRemote.handleError(err);
    });
  },

  anasayfa: (id) => {
    const url = RestConstants.baseUrl+"/api/anasayfa/"+id;
    return RestConstants.jFetch(url).then(r => r.data).catch(err => {

      LoginRemote.handleError(err);
    });
  },

  
  kullaniciGeit: (id) => {
    const url = RestConstants.baseUrl+"/api/auth/kullanicilar/id/"+id;
    return RestConstants.jFetch(url).then(r => r.data).catch(err => {

      LoginRemote.handleError(err);
    });
  },


  saveTasarim: (responce) => {
    const url = RestConstants.baseUrl+"/api/uploadPost";
    return RestConstants.jPost(url,responce).then(r => r.data).catch(err => {
      LoginRemote.handleError(err);
      
    });
  },

  gonderilerEkle: (response) => {
    const url = RestConstants.baseUrl+"/api/gonderiEkle";
    return RestConstants.jPost(url,response).then(r => r.data).catch(err => {
      LoginRemote.handleError(err);
      
    });
  },

  gonderiGetir: (id) => {
    const url = RestConstants.baseUrl+"/api/listGonderi/"+id;
    return RestConstants.jFetch(url).then(r => r.data).catch(err => {
      LoginRemote.handleError(err);
      
    });
  },
  getImage: (imageName) => {

    const url = RestConstants.baseUrl+"/api/getGonderiImage/"+imageName;
    return RestConstants.JImage(url).then(r => r).catch(err => {

      LoginRemote.handleError(err);
    });
  },



  handleError: (err) => {
    if (err && (err.statusCode === 403 || err.statusCode === 401)) {
     // siparisSessionRemote.logout.defer();
      swal("Kullanıcı Adı veya Parola hatalı!");

    } else {
     
      swal(err.response ? err.response.data : err.message);
      throw err;
    }
  }
};

export default LoginRemote;
