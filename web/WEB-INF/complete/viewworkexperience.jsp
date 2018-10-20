<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>

<%@page contentType="text/html" pageEncoding="UTF-8"%>

<html lang="en">

    <jsp:include page="/WEB-INF/private/head.jsp"/>  
    
    

    <body id="page-top">

        <!--====================================================
                                 HEADER
        ======================================================--> 
        <jsp:include page="/WEB-INF/private/composite/header.jsp"/>

        <!--====================================================
                            LOGIN OR REGISTER
        ======================================================-->
        <jsp:include page="/WEB-INF/private/loginorregister.jsp"/>

        <!--====================================================
                               HOME-P
        ======================================================-->
        
        
      
        <div id="home-p" class="home-p  text-center"> 
            <img src="${pageContext.request.contextPath}/img/news/man2.png" alt="user" style="width:7%;"> 
            <div class="container">
                <h1 class="wow fadeInUp" data-wow-delay="0.1s">My work experience</h1>
            </div>
        </div> 

       
        <!--====================================================
                                FORM
        ======================================================-->
        <section class="shop-form bg-gray" id="shop-form">
            <div class="container">
                <div class="row"> 
                    <div class="col-md-10 main-login main-center">
                        <center><h4><font color="dimgray">My Languages</font></h4></center>
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
                        <center><h4><font color="dimgray">My Work Experience</font></h4></center>
                        <c:forEach items="${user.professionalExperienceList}" var="exp"> 
                            <form class="form-horizontal" method="post" action="">
                                <div class="form-group">
                                    <div class="cols-sm-10">
                                        <div class="input-group">
                                           <input type="text" class="form-control" readonly="true" value="${exp.jobId.name}"/>
                                           <fmt:formatDate var="fmtDate" value="${exp.dateStarted}" pattern="dd/MM/yyyy"/>
                                           <%--<fmt:formatDate var="fmtDateEnd" value="${exp.dateEnded}" pattern="dd/MM/yyyy"/>--%>
                                           <input type="text" name="bean.dateProperty" class="form-control" readonly="true" value="${fmtDate}"/>
                                           <%--<input type="text" name="bean.dateProperty" class="form-control" readonly="true" value="${fmtDateEnd}"/>--%>
                                        </div>
                                    </div>
                                </div>
                            </form>
                        </c:forEach>
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
