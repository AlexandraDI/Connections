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
                <h1 class="wow fadeInUp" data-wow-delay="0.1s">Network</h1>
            </div>
        </div>         

        
        <!--====================================================
                                news-p1
        ======================================================--> 


        <section id="news-p1" class="news-p1">
            <div class="container" style="width:30%;">
                <div class="bg-light-gray" >             
                    <div class="row">
                        <%--<center><h4>Connections</h4></center>--%>
                        <div class="card-columns">

                            <c:set var="number" value="${fn:length(networkList)}" /> 

                            <c:if test="${number > 0}">
                                <c:forEach var = "i" begin = "0" end = "${number-1}" step= "1">

                                    <div class="card" style="width:100%;">
                                        <div class="desc-comp-offer-cont">
                                            <div class="thumbnail-blogs">                  
                                                <div class="caption" >
                                                    <a href="${pageContext.request.contextPath}/userdetails?id=${networkList[i].user1.userId}">                     
                                                        <i class="fa fa-chain" ></i></a>
                                                </div>                 
                                                <center><img src="img/news/man2.jpg" class="img-fluid" alt="..."style="width:50%;"></center>
                                            </div>
                                            <center><h3>${networkList[i].user1.firstname} ${networkList[i].user1.surname}</h3></center> 
                                            <center><p class="desc">Professional Position &nbsp; Employment Institution</p></center> 
                                            <center><a href="${pageContext.request.contextPath}/userdetails?id=${networkList[i].user1.userId}"><i class="fa fa-arrow-circle-o-right"></i> Learn More</a></center>
                                        </div>
                                    </div> 
                                </c:forEach>
                            </c:if>
                          
                            
                            <c:set var="number" value="${fn:length(networkList1)}" /> 

                            <c:if test="${number > 0}">
                                <c:forEach var = "i" begin = "0" end = "${number-1}" step= "1">

                                    <div class="card" style="width:100%;">
                                        <div class="desc-comp-offer-cont">
                                            <div class="thumbnail-blogs">                  
                                                <div class="caption" >
                                                    <a href="${pageContext.request.contextPath}/userdetails?id=${networkList1[i].user.userId}">                     
                                                        <i class="fa fa-chain" ></i></a>
                                                </div>                 
                                                <center><img src="img/news/man2.jpg" class="img-fluid" alt="..."style="width:50%;"></center>
                                            </div>
                                            <center><h3>${networkList1[i].user.firstname} ${networkList1[i].user.surname}</h3></center> 
                                            <center><p class="desc">Professional Position &nbsp; Employment Institution</p></center>              
                                            <center><a href="${pageContext.request.contextPath}/userdetails?id=${networkList1[i].user.userId}"><i class="fa fa-arrow-circle-o-right"></i> Learn More</a></center>
                                        </div>
                                    </div> 

                                </c:forEach>                        
                            </c:if>

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

