<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!-- Top Navbar  -->
<div class="top-menubar">
    <div class="topmenu">
        <div class="container">
            <div class="row">
                <div class="col-md-7">
                    <ul class="list-inline top-contacts">
                        <li>
                            <i class="fa fa-envelope"></i> Email: <a href="mailto:connections@gmail.com">connections@gmail.com</a>
                        </li>
                    </ul>
                </div> 
                <div class="col-md-5">
                    <ul class="list-inline top-data">
                        <li><a href="https://www.facebook.com/" target="_empty"><i class="fa top-social fa-facebook"></i></a></li>
                        <li><a href="https://twitter.com/" target="_empty"><i class="fa top-social fa-twitter"></i></a></li>
                        <li><a href="https://plus.google.com/discover" target="_empty"><i class="fa top-social fa-google-plus"></i></a></li> 


                        <c:if test="${empty me}">
                            <li><a href="#" class="log-top" data-toggle="modal" data-target="#login-modal">Login or Register</a></li>  
                            </c:if>
                            <c:if test="${not empty me}">
                            <li><a href="${pageContext.request.contextPath}/logout" class="log-top">Logout</a></li>  
                            </c:if>

                    </ul>
                </div>
            </div>
        </div>
    </div> 
</div> 