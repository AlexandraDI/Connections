<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">

<jsp:include page="/WEB-INF/private/head1.jsp"/>  

  <body id="page-top">

<!--====================================================
                         HEADER
======================================================--> 

<%-- <jsp:include page="/WEB-INF/private/composite/header.jsp"/> --%>
 


    <header>
        
        <jsp:include page="/WEB-INF/private/topmenubar.jsp"/>


      <!-- Navbar -->
      
      <jsp:include page="/WEB-INF/private/navbar.jsp"/>

    </header> 


<!--====================================================
                    LOGIN OR REGISTER
======================================================-->
 
<!--====================================================
                       HOME-P
======================================================-->



<!--====================================================
                        single-news-p1
======================================================--> 
    <section id="single-news-p1" class="single-news-p1">

      <div class="container">   
        <div class="row">

                
                
                
          <div class="col-md-3">                                     
              <div class="ad-box-sn">              
                <h3 style="color:#777;" class="pb-2"><center>PROFILE</center></h3>
                
                <div class="card">
                <!-- <div class="ad-box-sn">    -->
                <div class="desc-comp-offer-cont">
                <div class="thumbnail-blogs">
                    <div class="caption">
                      <a href="${pageContext.request.contextPath}/profile">   
                          <i class="fa fa-chain"></i></a>
                    </div>
                    <img src="img/news/man2.jpg" alt="..." style="width:70%;">
                </div>
                </div>    
                   <%-- <h5><center>Personal Info</center></h5>
                    ${me.firstname} --%>
                    <h6><center><c:out value="${me.firstname}" /></center></h6>
                    <p> <a href="${pageContext.request.contextPath}/network"> <center>My connections</center></a> </p>
                <a href="${pageContext.request.contextPath}/profile"><center> <i class="fa fa-arrow-circle-o-right"></i> Read More</center></a>
                </div>
             <!-- </div>          -->                            
            </div> 
                <div class="comment-box-sn">
                  <h5>Leave an Article</h5>
                  <!--<textarea name="" id="" placeholder="Comment" ></textarea> -->
                  <input type="text" name="article" placeholder="Article" class="form-control"><br>
                  <!--<input type="text" name="text" placeholder="Upload Multimedia" class="form-control"><br>-->
                  <button class="btn btn-general btn-green" style="width: 100%;" role="button">Upload Multimedia</button>
                  <!--<button class="btn btn-general btn-green" style="width: 100%;" role="button">Send</button> -->
                </div>                                                    
          </div> 
                
                
           <div class="col-md-7"> 
            <div class="single-news-p1-cont" style="margin-bottom: 30px; box-shadow: 1px 1px 1px rgba(0,0,0,0.1);">
              <div class="single-news-img">
                <img src="img/news/news-box-1.jpg" alt="" class="img-fluid">
              </div>
              <div class="single-news-desc m-0 pt-1 pb-0 px-0">
                <h3>Reduction of AC energy wastage through clamp meter</h3>
                <ul class="list-inline">
                  <li>Posted: <span class="text-theme-colored2"> 9/9/2018</span></li>
                  <li>By: <span class="text-theme-colored2">Admin</span></li>
                  <li><i class="fa fa-comments-o"></i> 1 comments</li>
                </ul>
                <hr>
                <div class="bg-light-gray">
                  <p>Clamp meter connected to an AC monitors the current flow and indicates usage (range) through green, orange and red colour codes. The four friends had learnt about capacitor and its use in many electronic appliances in their physics class. Ageing of these, leads to lesser efficiency of the appliance. It has survived not only five centuries, but also the leap into electronic typesetting, remaining essentially unchanged.</p> 
                  <a href="${pageContext.request.contextPath}/details" class="mb-2">Read More <i class="fa fa-long-arrow-right"></i></a>
                </div> 
              </div>
            </div>
            <div class="single-news-p1-cont" style="margin-bottom: 30px; box-shadow: 1px 1px 1px rgba(0,0,0,0.1);">
              <div class="single-news-img">
                <img src="img/news/news-box-2.jpg" alt="" class="img-fluid">
              </div>
              <div class="single-news-desc m-0 pt-1 pb-0 px-0">
                <h3>Reduction of AC energy wastage through clamp meter</h3>
                <ul class="list-inline">
                  <li>Posted: <span class="text-theme-colored2"> 9/9/2018</span></li>
                  <li>By: <span class="text-theme-colored2">Admin</span></li>
                  <li><i class="fa fa-comments-o"></i> 1 comments</li>
                </ul>
                <hr>
                <div class="bg-light-gray">
                  <p>Clamp meter connected to an AC monitors the current flow and indicates usage (range) through green, orange and red colour codes. The four friends had learnt about capacitor and its use in many electronic appliances in their physics class. Ageing of these, leads to lesser efficiency of the appliance. It has survived not only five centuries, but also the leap into electronic typesetting, remaining essentially unchanged. It was popularised in the 1960s with the release of Letraset sheets containing Lorem Ipsum passages, and more recently with desktop publishing software like Aldus PageMaker including versions of Lorem Ipsum.</p> 
                  <a href="${pageContext.request.contextPath}/details" class="mb-2">Read More <i class="fa fa-long-arrow-right"></i></a>
                </div> 
              </div>
            </div>
            <div class="single-news-p1-cont" style="margin-bottom: 30px; box-shadow: 1px 1px 1px rgba(0,0,0,0.1);">
              <div class="single-news-img">
                <img src="img/news/news-box-3.jpg" alt="" class="img-fluid">
              </div>
              <div class="single-news-desc m-0 pt-1 pb-0 px-0">
                <h3>Reduction of AC energy wastage through clamp meter</h3>
                <ul class="list-inline">
                  <li>Posted: <span class="text-theme-colored2"> 9/9/2018</span></li>
                  <li>By: <span class="text-theme-colored2">Admin</span></li>
                  <li><i class="fa fa-comments-o"></i> 1 comments</li>
                </ul>
                <hr>
                <div class="bg-light-gray">
                  <p>Clamp meter connected to an AC monitors the current flow and indicates usage (range) through green, orange and red colour codes. The four friends had learnt about capacitor and its use in many electronic appliances in their physics class. Ageing of these, leads to lesser efficiency of the appliance. It has survived not only five centuries, but also the leap into electronic typesetting, remaining essentially unchanged. It was popularised in the 1960s with the release of Letraset sheets containing Lorem Ipsum passages, and more recently with desktop publishing software like Aldus PageMaker including versions of Lorem Ipsum.</p> 
                  <a href="${pageContext.request.contextPath}/details" class="mb-2">Read More <i class="fa fa-long-arrow-right"></i></a>
                </div> 
              </div>
            </div>  
          </div>               
                                

        </div>
               
      </div> 
               
    </section>
 

<!--====================================================
                      FOOTER
======================================================--> 
        <jsp:include page="/WEB-INF/private/footer.jsp"/>

        <!--Global JavaScript -->
        <jsp:include page="/WEB-INF/private/code/js.jsp"/>
  </body>

</html>

