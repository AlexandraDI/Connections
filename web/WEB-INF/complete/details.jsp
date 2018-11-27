<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">

    <head>

        <jsp:include page="/WEB-INF/private/head1.jsp"/>       

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
            <div class="container" style="width:45%"> 
                <div class="single-news-p1-cont">
                    <div class="single-news-img">
                        <img src="img/news/news-box.jpg" alt="" style="width:85%;">
                    </div>
                    <div class="single-news-desc">
                        <h3>${articledetail.title}</h3>
                        <ul class="list-inline">
                            <li>Posted: <span class="text-theme-colored2"> ${articledetail.datetimeCreated}</span></li>
                            <li>By: <span class="text-theme-colored2">${articledetail.authorId.firstname} ${articledetail.authorId.surname}</span></li>                                                        
                            <li><i class="fa fa-comments-o"></i> ${fn:length(comments)} comments</li>
                        </ul>
                        
                        <c:if test="${me.userId == articledetail.authorId.userId}">
                           <li><i class="fa fa-female"></i> Author</li>
                        </c:if>

                        <c:if test="${not (me.userId == articledetail.authorId.userId)}">
                            <c:if test="${liked}"> 
                                
                                <c:if test="${reaction eq 1}">
                                    <div align="center"> <li><i class="fa fa-arrow-down"></i> Dislike</li></div>

                                </c:if>
                                <c:if test="${reaction eq 2}">
                                    <div align="center"><li><i class="fa fa-asterisk"></i> Like</li></div>
                        
                                </c:if>
                                <c:if test="${reaction eq 3}">
                                    <div align="center"><li><i class="fa fa-heart"></i> Adore</li></div>
                        
                                </c:if>
                                    <div align="center"> 
                                <form method="post" action="">
                                    <input type="hidden" name="do" value="deleterate">
                                    <input type="hidden" name="articleid" value="${articledetail.articleId}">
                                    <input type="submit" class="btn btn-general btn-green" value="clear my reaction">
                                </form></div>

                            </c:if>

                            <c:if test="${not liked}">
                                <div align="right">
                                <table>
                                    
                                    <tr>
                                        <td>
                                            <form method="post" action="">
                                                <input type="hidden" name="do" value="rate">
                                                <input type="hidden" name="articleid" value="${articledetail.articleId}">
                                                <input type="hidden" name="reaction" value="3">
                                                <input type="submit" class="btn btn-general btn-green" value="perfect">
                                            </form>
                                        </td>
                                        <td>
                                            <form method="post" action="">
                                                <input type="hidden" name="do" value="rate">
                                                <input type="hidden" name="articleid" value="${articledetail.articleId}">
                                                <input type="hidden" name="reaction" value="2">
                                                <input type="submit" class="btn btn-general btn-green" value="like">
                                            </form>
                                        </td>
                                        <td>
                                            <form method="post" action="">
                                                <input type="hidden" name="do" value="rate">
                                                <input type="hidden" name="articleid" value="${articledetail.articleId}">
                                                <input type="hidden" name="reaction" value="1">
                                                <input type="submit"class="btn btn-general btn-green" value="dislike">
                                            </form>
                                        </td>
                                    </tr>
                                  
                                </table>
                                </div>               
                            </c:if>
                        </c:if>
                       


                        <hr>
                        <div class="bg-light-gray">
                            <p>${articledetail.content}</p>                            
                        </div>



                        <c:set var="number" value="${fn:length(comments)}" /> 

                        <c:if test="${number > 0}">

                            <div class="comments-container"> 
                                <ul id="comments-list" class="comments-list">

                                    <c:forEach items="${comments}" var="com">  
                                        <li>
                                            <div class="comment-main-level">
                                                <!-- Avatar -->
                                                <div class="comment-avatar"><img src="img/news/man2.jpg" alt=""></div>
                                                <!-- Comments -->
                                                <div class="comment-box">
                                                    <div class="comment-head">
                                                        <h6 class="comment-name"><a href="${pageContext.request.contextPath}/profile">${com.userId.firstname} ${com.userId.surname}</a></h6>
                                                        <span>${com.datetimeCreated} ${me.userId} ${com.userId.userId}</span>
                                                        <c:if test="${me.userId eq com.userId.userId}">
                                                            <form method="post" action="">
                                                            <input type="hidden" name="do" value="delete">
                                                            <input type="hidden" name="commentid" value="${com.commentId}">
                                                            <div align="right">
                                                                <input type="submit" class="btn btn-general btn-green" value="x"></div>
                                                            </form>
                                                        </c:if>
                                                    </div>
                                                    <div class="comment-content">
                                                        ${com.content}
                                                    </div>
                                                </div>
                                            </div>
                                        </li>
                                    </c:forEach>
                                </ul>
                            </div>
                        </c:if>


                        <div class="comment-box-sn">
                            <h5>Leave a Comment</h5>

                            <form method="post" id="login-form" action="">
                                <input type="hidden" name="do" value="add">
                                <textarea type="text" name="contentOfComment" placeholder="Comment" required="true" class="form-control" style="width: 100%;"></textarea></br>


                                <center><p>${result}</p></center>                                    
                                <input type="submit" value="POST" class="btn btn-general btn-green" style="width: 100%;" required="true">
                            </form>                                             
                        </div>
                    </div>
                </div>  
                <hr>
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
