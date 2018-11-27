<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>

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
        <jsp:include page="/WEB-INF/private/loginorregister.jsp"/>
       
        <!--====================================================
                                 HOME
        ======================================================-->
        <center><p>${result}</p></center>
        
       <jsp:include page="/WEB-INF/private/carousel.jsp"/>

        
<%--
        <!--====================================================
                              FOOTER
        ======================================================--> 
        <jsp:include page="/WEB-INF/private/footer.jsp"/>
--%>
        
        
        <jsp:include page="/WEB-INF/private/code/js.jsp"/>
        
      
    </body>

</html>
