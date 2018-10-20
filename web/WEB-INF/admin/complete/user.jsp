<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>

<%@page contentType="text/html" pageEncoding="UTF-8"%>


<!DOCTYPE html>
<html>

    <jsp:include page="/WEB-INF/admin/head.jsp"/>

    <body> 

        <!--====================================================
                                 MAIN NAVBAR
        ======================================================-->        
        <jsp:include page="/WEB-INF/admin/private/navbar.jsp"/> 

        <!--====================================================
                                PAGE CONTENT
        ======================================================-->
        <div class="page-content d-flex align-items-stretch">

            <jsp:include page="/WEB-INF/admin/private/sidebar.jsp"/> 

            <div class="content-inner chart-cont">
                <h3>Viewing profile of user with ID: ${user.userId}</h3>
                
                <h4>${user.firstname} ${user.surname}</h4>
                
                <p>Email:  ${user.email}</p>
                
                ${user.birthday}
                ${user.phoneNumber}
            </div> 

        </div>
    </div> 

    <jsp:include page="/WEB-INF/admin/private/code/js.jsp"/> 

</body>

</html>