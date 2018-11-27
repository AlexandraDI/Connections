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
                <h1 class="wow fadeInUp" data-wow-delay="0.1s">My Applications</h1>
            </div>
        </div>              
            

                                                
         <!--====================================================
                            EXAMINE MY JOBS
        ======================================================--> 

        <section id="single-news-p1" class="single-news-p1">
            <div class="container" style="width:35%">
                <div class="bg-gray" >                    
                    <div class="ad-box-sn"> 
                        <div class="bg-light-gray" >
                            &nbsp;<center><h6>My Applications</h6></center>&nbsp;


                            <c:forEach items="${myadlist}" var="ad">
                                <center>
                                    <div class="card" style="width: 100%">
                                        <div class="bg-light-gray" >   
                                            <div class="desc-comp-offer-cont">
                                                Title : ${ad.title} | Author: ${ad.userId.firstname} ${ad.userId.surname}</br>
                                                <div class="bg-white" > 
                                                    
                                                    <left><img src="img/news/index2.jpg" class="img-fluid" alt="..."style="width:17%;"></left>
                                                </div>
                                                <a href="${pageContext.request.contextPath}/addetails?adId=${ad.adId}">
                                                    <button class="btn btn-general btn-green" style="width: 50%;" role="button">Details</button> </a>
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
