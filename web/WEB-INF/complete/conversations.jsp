<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html lang="en">

    <head>

        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
        <meta name="description" content="">
        <meta name="author" content="">


        <title>conversation title</title>
        <link rel="shortcut icon" href="img/favicon.ico">

        <!-- Global Stylesheets -->
        <link href="https://fonts.googleapis.com/css?family=Roboto+Condensed:300,300i,400,400i,700,700i" rel="stylesheet">
        <link href="css/bootstrap/bootstrap.min.css" rel="stylesheet">
        <link rel="stylesheet" href="font-awesome-4.7.0/css/font-awesome.min.css">
        <link rel="stylesheet" href="css/animate/animate.min.css">
        <link rel="stylesheet" href="css/owl-carousel/owl.carousel.min.css">
        <link rel="stylesheet" href="css/owl-carousel/owl.theme.default.min.css">
        <link rel="stylesheet" href="css/style.css">

        <!-- Core Stylesheets -->
        <link rel="stylesheet" href="css/news.css"> 
    </head>

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
                              NEWS DETAILS
        ======================================================--> 
        <section id="single-news-p1" class="single-news-p1">
            <div class="container">
                <div class="bg-light-gray" >  
                    <div class="ad-box-sn">           
                        <div class="row">


                            <!-- left news details -->
                            <div class="col-md-4"> 
                                <div class="bg-gray">  
                                    <div class="ad-box-sn"> 

                                        <c:set var="number" value="${fn:length(conversationlist)}" /> 

                                        <c:if test="${number > 0}">
                                            <c:forEach var = "i" begin = "0" end = "${number-1}" step= "1">
                                                <div class="card">
                                                    <div class="bg-gray"> 
                                                        <div class="desc-comp-offer-cont">
                                                            <div class="thumbnail-blogs">
                                                                <div class="bg-light-gray" >                     
                                                                    <div class="caption">
                                                                        <i class="fa fa-chain"></i>
                                                                    </div>

                                                                    <img src="img/news/man.jpg" class="img-fluid" alt="..." style="width:12%;">
                                                                    <a href="#"> ${conversationlist[i].user2Id.firstname} ${conversationlist[i].user2Id.surname}</a>
                                                                </div>
                                                            </div>
                                                        </div>
                                                    </div>
                                                </div>
                                            </c:forEach> 
                                        </c:if>

                                        <div class="card" > 
                                            <div class="bg-gray">    
                                                <div class="desc-comp-offer-cont" style="width:125%;">

                                                    <div class="thumbnail-blogs">

                                                        <div class="bg-light-gray" >
                                                            <img src="img/news/man2.jpg" class="img-fluid" alt="..." style="width:12%;">
                                                            <a > ${me.firstname} ${me.surname}</a>
                                                        </div>
                                                    </div>
                                                </div>
                                            </div>
                                        </div> 


                                        <c:set var="number" value="${fn:length(conversationlist1)}" /> 

                                        <c:if test="${number > 0}">
                                            <c:forEach var = "i" begin = "0" end = "${number-1}" step= "1">
                                                <div class="card">  
                                                    <div class="bg-gray">   
                                                        <div class="desc-comp-offer-cont">                   
                                                            <div class="thumbnail-blogs">
                                                                <div class="bg-light-gray" >
                                                                    <div class="caption">
                                                                        <i class="fa fa-chain"></i>
                                                                    </div>
                                                                    <img src="img/news/man3.jpg" class="img-fluid" alt="..." style="width:12%;">
                                                                    <a href="#">${conversationlist1[i].user1Id.firstname} ${conversationlist1[i].user1Id.surname} </a>
                                                                </div>
                                                            </div>
                                                        </div>
                                                    </div>
                                                </div>
                                            </c:forEach>
                                        </c:if>


                                    </div>

                                </div> 
                            </div>


                            <!-- right news details -->    
                            <div class="col-md-8">
                                <div class="single-news-p1-cont">
                                    <div class="single-news-desc">
                                        <div class="bg-gray">
                                            <div class="comments-container"> 
                                                <ul id="comments-list" class="comments-list">
                                                    <li>
                                                        <div class="comment-main-level">
                                                            <!-- Avatar -->
                                                            <div class="comment-avatar"><img src="img/news/man2.jpg" alt=""></div>
                                                            <!-- comments -->
                                                            <div class="comment-box">
                                                                <div class="comment-head">
                                                                    <h6 class="comment-name"><a href="#">${me.firstname}</a></h6>
                                                                    <span>before 20 minutes</span>
                                                                </div>
                                                                <div class="comment-content">
                                                                         bla bla
                                                                </div>
                                                            </div>
                                                        </div>
                                                    </li>
                                                    <li>
                                                        <ul class="comments-list reply-list">
                                                            <!-- Avatar -->
                                                            <div class="comment-avatar"><img src="img/news/man3.jpg" alt=""></div>
                                                            <div class="comment-box sub-comment-box">
                                                                <div class="comment-head">
                                                                    <h6 class="comment-name"><a href="#">${me.firstname}</a></h6>
                                                                    <span>before 10 minutes</span>
                                                                </div>
                                                                <div class="comment-content">
                                                                    bla bla
                                                                </div>
                                                            </div>

                                                        </ul>
                                                    </li>

                                                    <li>
                                                        <div class="comment-main-level">

                                                            <div class="comment-avatar"><img src="img/news/man2.jpg" alt=""></div>

                                                            <div class="comment-box">
                                                                <div class="comment-head">
                                                                    <h6 class="comment-name"><a href="#">${me.firstname}</a></h6>
                                                                    <span>before 10 minutes</span>
                                                                </div>
                                                                <div class="comment-content">
                                                                    bla bla
                                                                </div>
                                                            </div>
                                                        </div>
                                                    </li>

                                                </ul>
                                            </div>

                                        </div>    

                                        <div class="comment-box-sn">
                                            <h5>Leave a Comment</h5>
                                            <textarea name="" id="" placeholder="Comment" ></textarea>
                                            <button class="btn btn-general btn-green" style="width: 100%;" role="button">Send</button>
                                        </div>

                                    </div>
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