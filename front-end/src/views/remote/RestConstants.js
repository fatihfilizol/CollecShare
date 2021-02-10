import axios from 'axios';
import {getToken} from "../../utils/Common";

let RestConstants = (function () {
    let baseUrl = "http://localhost:8090";

    // if (process.env.NODE_ENV === 'development') {
    //     /* global DEV_URL */
    //     baseUrl = DEV_URL + "/aioc-rest-web/rest";
    // }

    // const logoutUrl = baseUrl + "/logout";
    // const loginUrl = baseUrl + "/login";


    const HttpMethods = {
        GET: 'GET',
        POST: 'POST',
        PUT: 'PUT',
        DELETE: 'DELETE'
    };

    const ajax = (url, body, method) => {
        return axios({
            method: method || "GET",
            url: url,
            headers: {
                'Access-Control-Allow-Origin': '*',
                'Authorization': 'Bearer ' + getToken()
            },

            proxy: {
                host: 'http://localhost',
                port: 3000
            },

            data: body,

        }).catch(err => {
            const message = err.message;
            const statusCode = err.response ? err.response.status : 500;
            const response = err.response;
            return Promise.reject({message, statusCode, response});
        })
    };
    const ajaxImage = (url, body, method) => {
        return axios({
            method: method || "GET",
            url: url,
            headers: {
                'Access-Control-Allow-Origin': '*',
                'Authorization': 'Bearer ' + getToken()
            },
            responseType: 'arraybuffer',
            proxy: {
                host: 'http://localhost',
                port: 3000
            },
            data:body


        }).catch(err => {
            const message = err.message;
            const statusCode = err.response ? err.response.status : 500;
            const response = err.response;
            return Promise.reject({message, statusCode, response});
        })
    };


    const jFetch = (url) => {
        return ajax(url);
    };

    const jDelete = (url, body) => {
        return ajax(url, body, HttpMethods.DELETE);
    };

    const jPut = (url, body) => {
        return ajax(url, body, HttpMethods.PUT);
    };

    const jPost = (url, body) => {
        return ajax(url, body, HttpMethods.POST);
    };
    const JImage = (url, body, post) => {
        if(post==="post") return ajaxImage(url, body, HttpMethods.POST);
        else return ajaxImage(url, body)

    };

    return {
        baseUrl: baseUrl,
        jDelete: jDelete,
        jPost: jPost,
        jPut: jPut,
        jFetch: jFetch,
        JImage: JImage,
        // logoutUrl: logoutUrl,
        // loginUrl : loginUrl
    }
})();

export default RestConstants;
