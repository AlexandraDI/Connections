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
                            EXAMINE MY JOBS
        ======================================================--> 

        <section id="single-news-p1" class="single-news-p1">
            <div class="container" style="width:35%">
                <div class="bg-gray" >                    
                    <div class="ad-box-sn"> 
                        <div class="bg-light-gray" >
                            &nbsp;<center><h6>My List for NotConnected Users</h6></center>&nbsp;


                            <c:forEach items="${notconnectedusers}" var="ad">
                                
                                    <div class="card" style="width: 100%">
                                        <div class="bg-light-gray" >   
                                            <div class="desc-comp-offer-cont">
                                               
                                                <div class="bg-white" > 
                                                    
                                                    <left><img src="img/news/man2.jpg" class="img-fluid" alt="..."style="width:12%;"></left>
                                                     ${ad.firstname} ${ad.surname}
                                                </div>
                                                <center>
                                                <a href="${pageContext.request.contextPath}/examinedetails?id=${ad.userId}">
                                                    <button class="btn btn-general btn-green" style="width: 50%;" role="button">Send Friend Request</button> </a>
                                                </center>
                                            </div>
                                        </div>
                                    </div>              
                            
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
