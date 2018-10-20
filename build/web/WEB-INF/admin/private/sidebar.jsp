<%-- 
    Document   : sidebar
    Created on : Aug 28, 2018, 3:50:10 PM
    Author     : alex
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!--***** SIDE NAVBAR *****-->
<nav class="side-navbar">
    <div class="sidebar-header d-flex align-items-center">
        <div class="avatar"><img src="${pageContext.request.contextPath}/admin/img/avatar-1.jpg" alt="..." class="img-fluid rounded-circle"></div>
        <div class="title">
            <h1 class="h4">Administrator</h1>
        </div>
    </div>
    <hr>
    <!-- Sidebar Navidation Menus-->
    <ul class="list-unstyled">
        <li> <a href="${pageContext.request.contextPath}/admin"><i class="icon-home"></i>Home</a></li>
        <li><a href="#apps" aria-expanded="false" data-toggle="collapse"> <i class="icon-interface-windows"></i>Apps </a>
            <ul id="apps" class="collapse list-unstyled">
                <li><a href="${pageContext.request.contextPath}/admin/export">Export data</a></li> 
            </ul>
        </li>
        <li> <a href="${pageContext.request.contextPath}/admin/users"> <i class="icon-grid"></i>Users </a></li> 
    </ul>
</nav>