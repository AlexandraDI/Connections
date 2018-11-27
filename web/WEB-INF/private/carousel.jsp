<%-- 
    Document   : carousel
    Created on : Aug 28, 2018, 2:56:53 PM
    Author     : alex
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<section id="home">
    <head>
<meta name="viewport" content="width=device-width, initial-scale=1">
<style>
img {
    display: block;
    margin-left: auto;
    margin-right: auto;
}
</style>
</head>
    
    <div  class="carousel"> 
        
       
        <!-- Carousel items -->
            <div class="carousel-item active "> 
              
               <img src="${pageContext.request.contextPath}/img/home-banner-bg.png" alt="homepage" style="width:50%;">
                <div class="hero ">
                   <hgroup class="wow fadeInUp">
                        <h1>CONNE <span ><a href="" class="typewrite" data-period="2000" data-type='[ "CTIONS", "CTIONS"]'>
                                    <span class="wrap"></span></a></span> </h1>        
                        <h3>LOGIN OR REGISTER</h3>
                    </hgroup>
                    <div>
                    <a href="#" class="btn btn-general btn-green wow fadeInUp" data-toggle="modal" data-target="#login-modal">LOGIN</a>
                    </div>
                    
                </div>        
           </div>
     
   </div> 
 </section> 