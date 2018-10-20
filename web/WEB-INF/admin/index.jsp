<%-- 
    Document   : index
    Created on : Aug 28, 2018, 2:47:18 PM
    Author     : alex
--%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!--
author: Boostraptheme
author URL: https://boostraptheme.com
License: Creative Commons Attribution 4.0 Unported
License URL: https://creativecommons.org/licenses/by/4.0/
-->

<!DOCTYPE html>
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
        <%--<jsp:include page="/WEB-INF/private/loginorregister.jsp"/>--%>

        <!--====================================================
                                 HOME
        ======================================================-->
       <jsp:include page="/WEB-INF/admin/private/carousel.jsp"/>

        <!--====================================================
                                ABOUT
        ======================================================-->
        
        
        
 <%--       
        <jsp:include page="/WEB-INF/private/about.jsp"/>
       

        <!--====================================================
                                OFFER
        ======================================================-->
        <jsp:include page="/WEB-INF/private/offer.jsp"/>
       

        <!--====================================================
                             WHAT WE DO        
        ======================================================-->
        <jsp:include page="/WEB-INF/private/whatwedo.jsp"/>
        
        <!--====================================================
                              STORY
        ======================================================--> 
        <jsp:include page="/WEB-INF/private/story.jsp"/>
        
        <!--====================================================
                          COMPANY THOUGHT
        ======================================================-->
        <jsp:include page="/WEB-INF/private/company.jsp"/>
        

        <!--====================================================
                           SERVICE-HOME
        ======================================================--> 
        <jsp:include page="/WEB-INF/private/service.jsp"/>
       
        <!--====================================================
                              CLIENT
        ======================================================-->
        <jsp:include page="/WEB-INF/private/client.jsp"/>
      
        <!--====================================================
                            CONTACT HOME
        ======================================================-->
        <jsp:include page="/WEB-INF/private/contact.jsp"/>
       

        <!--====================================================
                               NEWS
        ======================================================-->
        
        <jsp:include page="/WEB-INF/private/news.jsp"/>
 
 
 
        

        <!--====================================================
                              FOOTER
        ======================================================--> 
        <jsp:include page="/WEB-INF/private/footer.jsp"/>
        
        --%>
        
        
        <jsp:include page="/WEB-INF/private/code/js.jsp"/>
        
      
    </body>

</html>
