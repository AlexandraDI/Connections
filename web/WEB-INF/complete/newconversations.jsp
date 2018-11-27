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

    <title>onnections</title>
    <link rel="shortcut icon" href="${pageContext.request.contextPath}/img/fav1.png">

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

            <jsp:include page="/WEB-INF/private/navbar.jsp"/>
        </header> 

        <!--====================================================
                            LOGIN OR REGISTER
        ======================================================-->
        <jsp:include page="/WEB-INF/private/loginorregister.jsp"/> 



        <!--====================================================
                              HOME-P
       ======================================================-->       

        <div id="home-p" class="home-p  text-center"> 
            <div class="container">
                <h1 class="wow fadeInUp" data-wow-delay="0.1s">Conversation</h1>
            </div>
        </div>         



        <!--====================================================
                              NEWS DETAILS
        ======================================================--> 
        <section id="single-news-p1" class="single-news-p1">
            <div class="container">
                <div class="row">
                    <!-- Left news details -->
                    <div class="col-md-4">
                        <div class="ad-box-sn"> 
                            <c:if test="${coversationId ne 0}">

                            <c:set var="number" value="${fn:length(conversationlist)}" /> 

                            <c:if test="${number > 0}">
                                <c:forEach var = "i" begin = "0" end = "${number-1}" step= "1">
                                    <div class="card">

                                        <div class="desc-comp-offer-cont">
                                            <c:if test="${conversationlist[i].conversationId ne conversationId}">
                                                <form method="post" action="">
                                                    <input type="hidden" name="id" value="${conversationlist[i].conversationId}">
                                                    <input type="hidden" name="do" value="details">
                                                    <button class="btn btn-general btn-green" style="width: 100%;" role="button">${conversationlist[i].user2Id.firstname} ${conversationlist[i].user2Id.surname}</button></a>
                                                </form>                                            
                                            </c:if>
                                            <c:if test="${conversationlist[i].conversationId eq conversationId}">
                                                <form method="post" action="">
                                                    <input type="hidden" name="id" value="${conversationlist[i].conversationId}">
                                                    <input type="hidden" name="do" value="details">
                                                    <button class="btn btn-general btn-white text-center" style="width: 100%;" role="button">${conversationlist[i].user2Id.firstname} ${conversationlist[i].user2Id.surname}</button></a>
                                                </form>                                            
                                            </c:if>                                            
                                        </div>

                                    </div>
                                </c:forEach> 
                            </c:if>  
                            <c:set var="number" value="${fn:length(conversationlist1)}" /> 
                            <c:if test="${number > 0}">

                                <c:forEach var = "i" begin = "0" end = "${number-1}" step= "1">
                                    <div class="card">  
                                        <div class="desc-comp-offer-cont">

                                            <c:if test="${conversationlist1[i].conversationId ne conversationId}">
                                                <form method="post" action="">
                                                    <input type="hidden" name="id" value="${conversationlist1[i].conversationId}">
                                                    <input type="hidden" name="do" value="details">
                                                    <button class="btn btn-general btn-green" style="width: 100%;" role="button">${conversationlist1[i].user1Id.firstname} ${conversationlist1[i].user1Id.surname}</button></a>
                                                </form> 
                                            </c:if>
                                            <c:if test="${conversationlist1[i].conversationId eq conversationId}">
                                                <form method="post" action="">
                                                    <input type="hidden" name="id" value="${conversationlist1[i].conversationId}">
                                                    <input type="hidden" name="do" value="details">
                                                    <button class="btn btn-general btn-white text-center" style="width: 100%;" role="button">${conversationlist1[i].user1Id.firstname} ${conversationlist1[i].user1Id.surname}</button></a>
                                                </form>                                            
                                            </c:if>                                            
                                        </div>                                         
                                    </div>
                                </c:forEach>
                            </c:if>                            

                            </c:if>

                        </div>
                    </div>             


                    <!-- Right news details -->
                    <div class="col-md-8">

                        <div class="single-news-p1-cont"> 
                            <hr>
                            <div class="single-news-desc">

                                <div class="comments-container"> 
                                    <c:if test="${coversationId ne 0}">
                                    <ul id="comments-list" class="comments-list">
                                        <c:set var="number" value="${fn:length(conversation.messageList)}" /> 
                                        <c:if test="${number > 0}">


                                            <c:forEach var = "i" begin = "0" end = "${number-1}" step= "1">                                      

                                                <li>
                                                    <div class="comment-main-level">
                                                        <!-- Avatar -->
                                                        <div class="comment-avatar"><img src="img/news/man2.jpg" alt=""></div>
                                                 
                                                        <div class="comment-box">
                                                            <div class="comment-head">
                                                                <h6 class="comment-name"><a href="#">${conversation.messageList[i].senderId.firstname}  ${conversation.messageList[i].senderId.surname}</a></h6>
                                                                <span>${conversation.messageList[i].datetimeCreated}</span>
                                                                <i class="fa fa-reply"></i>
                                                                <i class="fa fa-heart"></i>
                                                            </div>
                                                            <div class="comment-content">
                                                                ${conversation.messageList[i].content} 
                                                            </div>
                                                        </div>
                                                    </div>
                                                </li>
                                            </c:forEach>
                                        </c:if>


                                        <div class="comment-box-sn">
                                            <form method="post" action="">
                                                <input type="hidden" name="conversationid" value="${conversationId}">
                                                <input type="hidden" name="do" value="message">
                                                <textarea type="text" name="contentOfMessage" required="true" placeholder="Leave your message" class="form-control"></textarea>
                                                <button class="btn btn-general btn-green" style="width: 100%;" role="button">Send</button>
                                            </form>
                                        </div>

                                    </ul>
                                    </c:if>
                                </div>
                            </div>
                        </div>  
                        <hr>
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
