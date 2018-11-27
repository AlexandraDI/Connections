<%-- 
    Document   : index
    Created on : Aug 28, 2018, 2:47:18 PM
    Author     : alex
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>


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
        <jsp:include page="/WEB-INF/private/register.jsp"/>
       
        <!--====================================================
                                 HOME
        ======================================================-->
       <jsp:include page="/WEB-INF/private/carousel.jsp"/>

        <!--====================================================
                                ABOUT
        ======================================================-->
        
        
        
        <jsp:include page="/WEB-INF/private/code/js.jsp"/>
        
      
    </body>

</html>
