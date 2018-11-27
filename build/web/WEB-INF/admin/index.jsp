<%-- 
    Document   : index
    Created on : Aug 28, 2018, 2:47:18 PM
    Author     : alex
--%>
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
        <jsp:include page="/WEB-INF/private/composite/header.jsp"/>

        <!--====================================================
                            LOGIN OR REGISTER
        ======================================================-->
        <%--<jsp:include page="/WEB-INF/private/loginorregister.jsp"/>--%>

        <!--====================================================
                                 HOME
        ======================================================-->
       <jsp:include page="/WEB-INF/admin/private/carousel.jsp"/>
        

<%--       
        <!--====================================================
                              FOOTER
        ======================================================--> 
        <jsp:include page="/WEB-INF/private/footer.jsp"/>
 --%>       
      
        
        
        <jsp:include page="/WEB-INF/private/code/js.jsp"/>
        
      
    </body>

</html>
