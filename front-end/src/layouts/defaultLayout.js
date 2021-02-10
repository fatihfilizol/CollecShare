import React, { Children } from "react";
import { Link } from "react-router-dom";
import logo from "../assets/img/logo.png";
import profil from "../assets/img/profil.png";
import bildirim from "../assets/img/bildirim.png";
import paylasim from "../assets/img/paylasim.png";
import kesfet from "../assets/img/kesfet.png";
import anasayfa from "../assets/img/anasayfa.png";
import cikis from "../assets/img/cikis1.png";
import { removeUserSession } from "../utils/Common";



const DefaultLayout = ({ children }) => (

   
    
<div  className="author-template" >
    <div className="site-wrapper">
    
        <nav className="main-nav overlay clearfix">
            <Link to="/anasayfa"><img src={logo} alt="Fashion Critiques" /></Link>

        </nav>
        <div className="site-wrapper">
            <ul type="none"><span className="socialheader">
                <li><Link to="/profil" ><span ><img src={profil} width="64px"/></span></Link></li>
                <li><Link to="/paylasim"><span><img src= {paylasim} width="64px"/></span></Link></li>
                <li><Link to="/kesfet"><span><img src= {kesfet} width="64px"/></span></Link></li>
                <li><Link to="/anasayfa"><span><img src= {anasayfa} width="64px"/></span></Link></li>
                <li><a href="#" onClick={removeUserSession.bind(this)}><span><img src= {cikis} width="64px"/></span></a></li>

                </span>
            </ul>
        </div>
        <div className="container pr-0 pl-0" style={{"min-height":"1100px"}}>
           {children}
        </div>
         
    </div>
</div>
    
        );

export default DefaultLayout;
  
