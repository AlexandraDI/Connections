<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>


<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html lang="en">

    <jsp:include page="/WEB-INF/private/head.jsp"/> 

    <body id="page-top">

        <!--====================================================
                                 HEADER
        ======================================================--> 

        <header>

            <jsp:include page="/WEB-INF/private/topmenubar.jsp"/>


            <!-- Navbar -->

            <jsp:include page="/WEB-INF/private/navbar.jsp"/>

        </header>                 


        <!--====================================================
                              HOME-P
       ======================================================-->       

        <div id="home-p" class="home-p  text-center"> 
            <div class="container">
                <h1 class="wow fadeInUp" data-wow-delay="0.1s">Ads</h1>
            </div>
        </div>          



        <!--====================================================
                            POST A JOB
        ======================================================--> 
        <section id="single-news-p1" class="single-news-p1">
            <div class="container" style="width:35%">

                <div class="bg-gray" > 
                    <div class="ad-box-sn"> 
                        <div class="bg-light-gray" >
                            <center>
                                <div class="card" style="width: 100%">
                                    <div class="bg-light-gray" >   
                                        <div class="desc-comp-offer-cont">
                                            <div class="bg-white" >                       
                                                <a href="${pageContext.request.contextPath}/userdetails">                     
                                                    <i class="fa fa-chain" ></i></a>
                                            </div>     -->            
                                            <left><img src="img/news/job6.jpg" class="img-fluid" alt="..."style="width:17%;"></left>
                                        </div>

                                        <a href="${pageContext.request.contextPath}/createad">
                                            <button class="btn btn-general btn-green" style="width: 50%;" role="button">Post An Ad</button> </a>                                      

                                    </div>
                                </div>
                        </div>              
                        </center>              

                    </div>
                </div>
            </div>
        </div>
    </section> 

    <!--====================================================
                       EXAMINE MY JOBS
   ======================================================--> 
    <section id="single-news-p1" class="single-news-p1">
        <div class="container" style="width:35%">

            <div class="bg-gray" > 
                <div class="ad-box-sn"> 
                    <div class="bg-light-gray" >

                        <center>
                            <div class="card" style="width: 100%">
                                <div class="bg-light-gray" >   
                                    <div class="desc-comp-offer-cont">
                                        <div class="bg-white" >                       
         
                                            <left><img src="img/news/job7.jpg" class="img-fluid" alt="..."style="width:17%;"></left>
                                        </div>
                                        <a href="${pageContext.request.contextPath}/examineads">
                                            <button class="btn btn-general btn-green" style="width: 50%;" role="button">Examine my Ads</button> </a>
                                    </div>
                                </div>
                            </div>              
                        </center>              

                    </div>
                </div>
            </div>
        </div>
    </section>  

    &nbsp; &nbsp;  &nbsp; 

    <!--====================================================
                  APPLY FOR A JOB CONNECTED USERS
    ======================================================--> 

    <section id="single-news-p1" class="single-news-p1">
        <div class="container" style="width:35%">
            <div class="bg-gray" >                    
                <div class="ad-box-sn"> 
                    <div class="bg-light-gray" >
                        &nbsp;<center><h6>Jobs you may be interested in from Connected Users</h6></center>&nbsp;


                        <c:forEach items="${conadlist}" var="conad">
                            <center>
                                <div class="card" style="width: 100%">
                                    <div class="bg-light-gray" >   
                                        <div class="desc-comp-offer-cont">
                                            Title : ${conad.title} | Author: ${conad.userId.firstname} ${conad.userId.surname}</br>
                                            <div class="bg-white" > 

                                                <left><img src="img/news/index2.jpg" class="img-fluid" alt="..."style="width:17%;"></left>
                                            </div>
                                            <form method="post" id="login-form" action="">
                                                <input type="hidden" name="do" value="add"> 
                                                <input type="hidden" name="adId"  value="${conad.adId}">
                                                <input type="submit" value="Apply" class="btn btn-general btn-green" style="width: 50%;" required="true">
                                            </form> 
                                            <form method="post" id="login-form" action="${pageContext.request.contextPath}/addetails">
                                                <input type="hidden" name="do" value="details"> 
                                                <input type="hidden" name="adId"  value="${conad.adId}">
                                                <input type="submit" value="Details" class="btn btn-general btn-green" style="width: 50%;" required="true">
                                            </form>                                               
                                        </div>
                                    </div>
                                </div>              
                            </center> 
                        </c:forEach>  



                    </div>
                </div>
            </div>
        </div>
    </section>                                                 

    &nbsp; &nbsp;  &nbsp; 

    <!--====================================================
                  APPLY FOR A JOB NOT CONNECTED USERS
    ======================================================--> 

    <section id="single-news-p1" class="single-news-p1">
        <div class="container" style="width:35%">
            <div class="bg-gray" >                    
                <div class="ad-box-sn"> 
                    <div class="bg-light-gray" >
                        &nbsp;<center><h6>Jobs you may be interested in from Other Users</h6></center>&nbsp;


                        <c:forEach items="${adlist}" var="ad">
                            <center>
                                <div class="card" style="width: 100%">
                                    <div class="bg-light-gray" >   
                                        <div class="desc-comp-offer-cont">
                                            Title : ${ad.title} | Author: ${ad.userId.firstname} ${ad.userId.surname}</br>
                                            <div class="bg-white" > 

                                                <left><img src="img/news/index2.jpg" class="img-fluid" alt="..."style="width:17%;"></left>
                                            </div>
                                            <form method="post" id="login-form" action="">
                                                <input type="hidden" name="do" value="notconnectedadd"> 
                                                <input type="hidden" name="adId"  value="${ad.adId}">
                                                <input type="submit" value="Apply" class="btn btn-general btn-green" style="width: 50%;" required="true">
                                            </form> 
                                            <form method="post" id="login-form" action="${pageContext.request.contextPath}/addetails">
                                                <input type="hidden" name="do" value="notconnecteddetails"> 
                                                <input type="hidden" name="adId"  value="${ad.adId}">
                                                <input type="submit" value="Details" class="btn btn-general btn-green" style="width: 50%;" required="true">
                                            </form>                                                     
                                        </div>
                                    </div>
                                </div>              
                            </center> 
                        </c:forEach>  



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
