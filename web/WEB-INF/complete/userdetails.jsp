<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">

    <head>

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
            <img src="${pageContext.request.contextPath}/img/news/man2.png" alt="user" style="width:7%;"> 
            <div class="container">
                <h1 class="wow fadeInUp" data-wow-delay="0.1s">${user.firstname} ${user.surname}</h1>
            </div>
        </div> 
        <!--====================================================
                              NEWS DETAILS
        ======================================================-->
 <c:if test="${user.userId ne me.userId}">
        <section id="single-news-p1" class="single-news-p1">
            <div class="container" style="width:35%"> 
                <div class="single-news-p1-cont">
                   

                    <c:if test="${not conversation}">            
                    <div class="comment-box-sn">
                        <form method="post" action="${pageContext.request.contextPath}/newconversations">
                            <input type="hidden" name="userid" value="${user.userId}">
                            <input type="hidden" name="do" value="startconversation">
                            <button class="btn btn-general btn-green" style="width: 100%;" role="button">Start Conversation</button></a>
                        </form>
                    </div>  
                    </c:if>

                    <c:if test="${not friend}">
                        <c:if test="${not requestpending}">
                            <div class="single-news-p1-cont">                              
                                         
                                <div class="comment-box-sn">
                                    <form method="post" action="">
                                        <input type="hidden" name="id" value="${user.userId}">
                                        <input type="hidden" name="do" value="sendfriendrequest">
                                        <button class="btn btn-general btn-green" style="width: 100%;" role="button">Send friend request</button></a>
                                    </form>
                                </div>    
                                       
                            </div>
                        </c:if>

                        <c:if test="${requestpending}">
                            <div class="single-news-p1-cont">                              
                                <hr>                
                                <div class="comment-box-sn">
                                    <center><p>Your request is pending!</p></center>
                                </div>    
                                <hr>                
                            </div>
                        </c:if>
                    </c:if>
                    <c:if test="${friend}">  
                            <div class="single-news-p1-cont">                              
                                       
                                <div class="comment-box-sn">
                                    <form method="post" action="${pageContext.request.contextPath}/hisnetwork">
                                        <input type="hidden" name="connectionid" value="${user.userId}">
                                        <input type="hidden" name="do" value="connections">
                                        <button class="btn btn-general btn-green" style="width: 100%;" role="button">View Connections</button></a>
                                    </form>
                                </div>                  
                            </div>                        
                        
                    </c:if>
                             
                </div>
            </div> 
        </section> 
 </c:if>

 <c:if test="${user.userId ne me.userId}">

        <section class="shop-form bg-gray" id="shop-form">
            <div class="container">
                <div class="row"> 
                    <div class="col-md-10 main-login main-center">
                        <center><h4><font color="dimgray">Languages</font></h4></center>

                        <c:if test="${not languages_private}">
                            <c:forEach items="${user.languageList}" var="lang"> 
                                <form class="form-horizontal" method="post" action="">
                                    <div class="form-group">
                                        <div class="cols-sm-10">
                                            <div class="input-group">
                                                <input type="text" class="form-control" readonly="true" value="${lang.language}"/>
                                            </div>
                                        </div>
                                    </div>
                                </form>
                            </c:forEach>
                        </c:if>
                        <c:if test="${languages_private}">
                            <center><p>Languages are private</p></center>
                            </c:if>
                    </div>


                    <div class="col-md-10 main-login main-center">
                        <center><h4><font color="dimgray">Professional Experience</font></h4></center>
                                <c:if test="${not experience_private}">
                                    <c:forEach items="${user.professionalExperienceList}" var="exp"> 
                                <form class="form-horizontal" method="post" action="">
                                    <div class="form-group">
                                        <div class="cols-sm-10">
                                            <div class="input-group">
                                                <input type="text" class="form-control" readonly="true" value="${exp.jobId.name}"/>
                                                <fmt:formatDate var="fmtDate" value="${exp.dateStarted}" pattern="dd/MM/yyyy"/>
                                                <input type="text" name="bean.dateProperty" class="form-control" readonly="true" value="${fmtDate}"/>
                                            </div>
                                        </div>
                                    </div>
                                </form>
                            </c:forEach>
                        </c:if>
                        <c:if test="${experience_private}">
                            <center><p>Work Experience is private</p></center>
                            </c:if>                       
                    </div>

                </div>
            </div>
        </section> 

        <section class="shop-form bg-gray" id="shop-form">
            <div class="container">
                <div class="row"> 
                    <div class="col-md-10 main-login main-center">
                        <center><h4><font color="dimgray">Skills</font></h4></center>
                                <c:if test="${not skills_private}">
                                    <c:forEach items="${user.userHasSkillList}" var="sk"> 
                                <form class="form-horizontal" method="post" action="">
                                    <div class="form-group">
                                        <div class="cols-sm-10">
                                            <div class="input-group">
                                                <input type="text" class="form-control" readonly="true" value="${sk.skill.toolsAndTechnologyId.description}"/>
                                            </div>
                                        </div>
                                    </div>
                                </form>
                            </c:forEach>
                        </c:if>
                        <c:if test="${skills_private}">
                            <center><p>Skills are private</p></center>
                            </c:if>                       
                    </div>


                    <div class="col-md-10 main-login main-center">
                        <center><h4><font color="dimgray">Education</font></h4></center>
                                <c:if test="${not education_private}">
                                    <c:forEach items="${user.educationList}" var="exp"> 
                                <form class="form-horizontal" method="post" action="">
                                    <div class="form-group">
                                        <div class="cols-sm-10">
                                            <div class="input-group">
                                                <input type="text" class="form-control" readonly="true" value="${exp.departmentId.name}"/>
                                            </div>
                                        </div>
                                    </div>
                                </form>
                            </c:forEach>
                        </c:if>
                        <c:if test="${education_private}">
                            <center><p>Education is private</p></center>
                            </c:if>                        
                    </div>
                </div>
            </div>
        </section>  
 </c:if>

 <c:if test="${user.userId eq me.userId}">
         <section class="shop-form bg-gray" id="shop-form">
            <div class="container">
                <div class="row"> 
                    <div class="col-md-10 main-login main-center">
                        <center><h4><font color="dimgray">Languages</font></h4></center>

                            <c:forEach items="${user.languageList}" var="lang"> 
                                <form class="form-horizontal" method="post" action="">
                                    <div class="form-group">
                                        <div class="cols-sm-10">
                                            <div class="input-group">
                                                <input type="text" class="form-control" readonly="true" value="${lang.language}"/>
                                            </div>
                                        </div>
                                    </div>
                                </form>
                            </c:forEach>

                    </div>


                    <div class="col-md-10 main-login main-center">
                        <center><h4><font color="dimgray">Professional Experience</font></h4></center>
                                    <c:forEach items="${user.professionalExperienceList}" var="exp"> 
                                <form class="form-horizontal" method="post" action="">
                                    <div class="form-group">
                                        <div class="cols-sm-10">
                                            <div class="input-group">
                                                <input type="text" class="form-control" readonly="true" value="${exp.jobId.name}"/>
                                                <fmt:formatDate var="fmtDate" value="${exp.dateStarted}" pattern="dd/MM/yyyy"/>
                                                <input type="text" name="bean.dateProperty" class="form-control" readonly="true" value="${fmtDate}"/>
                                            </div>
                                        </div>
                                    </div>
                                </form>
                            </c:forEach>
                     
                    </div>

                </div>
            </div>
        </section> 

        <section class="shop-form bg-gray" id="shop-form">
            <div class="container">
                <div class="row"> 
                    <div class="col-md-10 main-login main-center">
                        <center><h4><font color="dimgray">Skills</font></h4></center>
                                    <c:forEach items="${user.userHasSkillList}" var="sk"> 
                                <form class="form-horizontal" method="post" action="">
                                    <div class="form-group">
                                        <div class="cols-sm-10">
                                            <div class="input-group">
                                                <input type="text" class="form-control" readonly="true" value="${sk.skill.toolsAndTechnologyId.description}"/>
                                            </div>
                                        </div>
                                    </div>
                                </form>
                            </c:forEach>                      
                    </div>


                    <div class="col-md-10 main-login main-center">
                        <center><h4><font color="dimgray">Education</font></h4></center>
                                    <c:forEach items="${user.educationList}" var="exp"> 
                                <form class="form-horizontal" method="post" action="">
                                    <div class="form-group">
                                        <div class="cols-sm-10">
                                            <div class="input-group">
                                                <input type="text" class="form-control" readonly="true" value="${exp.departmentId.name}"/>
                                            </div>
                                        </div>
                                    </div>
                                </form>
                            </c:forEach>                       
                    </div>
                </div>
            </div>
        </section>      
 </c:if>
        

        <!--====================================================
                              FOOTER
        ======================================================--> 
        <jsp:include page="/WEB-INF/private/footer.jsp"/>

        <!--Global JavaScript -->
        <jsp:include page="/WEB-INF/private/code/js.jsp"/>
    </body>

</html>
