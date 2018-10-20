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
                <h1 class="wow fadeInUp" data-wow-delay="0.1s">Search Results</h1>
            </div>
        </div> 
       
        <!--====================================================
                                single-news-p1
        ======================================================--> 
        <section id="single-news-p1" class="single-news-p1">
            <div class="container" style="width:35%">
                <!-- <div class="row">
          
                <!--  <div class="col-md-4">-->
                <div class="bg-light-gray" > 
                    <div class="ad-box-sn"> 
                        <div class="bg--gray" >
                            <!--<center><h6 style="color:#777;" class="pb-2">Results:</h6></center>-->

                            <c:set var="number" value="${fn:length(searchList)}" /> 

                            <c:if test="${number > 0}">
                                <c:forEach var = "i" begin = "0" end = "${number-1}" step= "1">


                                    <center>
                                        <div class="card" style="width: 30%">
                                            <div class="bg-light-gray" >   
                                                <div class="desc-comp-offer-cont">
                                                    <div class="bg-white" >  
                                                        <div class="thumbnail-blogs">                  
                                                            <div class="caption" >
                                                                <a href="${pageContext.request.contextPath}/userdetails?id=${searchList[i].userId}">                     
                                                                    <i class="fa fa-chain" ></i></a>
                                                            </div>               
                                                            <img src="img/news/man2.jpg" class="img-fluid" alt="..."style="width:50%;">
                                                        </div>
                                                        <center><h3>${searchList[i].firstname} ${searchList[i].surname}</h3></center> <!--//.userId-->
                                                        <center><p class="desc">Professional Position &nbsp; Employment Institution</p></center> 
                                                        <center><a href="${pageContext.request.contextPath}/userdetails?id=${searchList[i].userId}"><i class="fa fa-arrow-circle-o-right"></i> Learn More</a></center>

                                                    </div>
                                                </div>
                                            </div>              
                                    </center>
                                </c:forEach>
                            </c:if>

                        </div>
                        <!--      </div> 
                        <!--  </div>-->
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