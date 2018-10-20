<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!-- Navbar -->
<nav class="navbar navbar-expand-lg navbar-light" id="mainNav" data-toggle="affix">
    <div class="container">
        <a class="navbar-brand smooth-scroll" href="${pageContext.request.contextPath}/xronologio">
            <img src="${pageContext.request.contextPath}/img/connect1.png" alt="logo">
        </a> 
        <button class="navbar-toggler navbar-toggler-right" type="button" data-toggle="collapse" data-target="#navbarResponsive" aria-controls="navbarResponsive" aria-expanded="false" aria-label="Toggle navigation"> 
            <span class="navbar-toggler-icon"></span>
        </button>  
        <div class="collapse navbar-collapse" id="navbarResponsive">
            <ul class="navbar-nav ml-auto">

                <c:if test="${not empty me and empty administrator}">
                    <!--<li class="nav-item" ><a class="nav-link smooth-scroll"href="${pageContext.request.contextPath}">Welcome</a></li>--> 
                    <!--<li class="nav-item" ><a class="nav-link smooth-scroll" href="${pageContext.request.contextPath}/xronologio">Home</a></li>-->
                    <%--<li class="nav-item" ><a class="nav-link smooth-scroll" href="${pageContext.request.contextPath}/profile">Profile</a></li>--%>
                    <li class="nav-item dropdown" >                                            
                        <a class="nav-link dropdown-toggle smooth-scroll" href="#" id="navbarDropdownMenuLink" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">Home</a> 
                        <div class="dropdown-menu dropdown-cust" aria-labelledby="navbarDropdownMenuLink">
                            <a class="dropdown-item" href="${pageContext.request.contextPath}/xronologio">Articles</a>
                            <a class="dropdown-item" href="${pageContext.request.contextPath}/myfollowedarticles">Followed Articles</a>

                        </div>
                    </li>                    
                    <li class="nav-item dropdown" >                                            
                        <a class="nav-link dropdown-toggle smooth-scroll" href="#" id="navbarDropdownMenuLink" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">Profile</a> 
                        <div class="dropdown-menu dropdown-cust" aria-labelledby="navbarDropdownMenuLink">
                            <a class="dropdown-item" href="${pageContext.request.contextPath}/profile">Personal Information</a>
                            <a class="dropdown-item" href="${pageContext.request.contextPath}/manageeducation">Manage Education</a>
                            <a class="dropdown-item" href="${pageContext.request.contextPath}/languages">Manage languages</a>
                            <!--<a class="dropdown-item" href="${pageContext.request.contextPath}/viewworkexperience">View Work Experience</a>-->
                            <a class="dropdown-item" href="${pageContext.request.contextPath}/addworkexperience">Manage Work Experience</a>
                            <a class="dropdown-item" href="${pageContext.request.contextPath}/manageskills">Manage Skills</a>
                            <a class="dropdown-item" href="${pageContext.request.contextPath}/userdetails?id=${me.userId}">View All</a>
                        </div>
                    </li>
                    <li class="nav-item" ><a class="nav-link smooth-scroll" href="${pageContext.request.contextPath}/network">Network</a></li> 
                    <li class="nav-item" ><a class="nav-link smooth-scroll" href="${pageContext.request.contextPath}/newconversations">Conversation</a></li>

                    <li class="nav-item dropdown" >                                            
                        <a class="nav-link dropdown-toggle smooth-scroll" href="#" id="navbarDropdownMenuLink" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">Ad</a> 
                        <div class="dropdown-menu dropdown-cust" aria-labelledby="navbarDropdownMenuLink">
                            <a class="dropdown-item" href="${pageContext.request.contextPath}/applications">Ads</a>
                            <a class="dropdown-item" href="${pageContext.request.contextPath}/myapplications">My Applications</a>

                        </div>
                    </li>                     
                    <li class="nav-item" ><a class="nav-link smooth-scroll" href="${pageContext.request.contextPath}/notifications">Notifications</a></li>                    
                    <li class="nav-item dropdown" >
                    <li class="nav-item dropdown" >
                        <a class="nav-link dropdown-toggle smooth-scroll" href="#" id="navbarDropdownMenuLink" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">Settings</a> 
                        <div class="dropdown-menu dropdown-cust" aria-labelledby="navbarDropdownMenuLink">
                            <a class="dropdown-item" href="${pageContext.request.contextPath}/changepassword">Change password</a>
                            <a class="dropdown-item" href="${pageContext.request.contextPath}/changeemail">Change e-mail</a>
                            <a class="dropdown-item" href="${pageContext.request.contextPath}/privacyoptions">Privacy options</a>
                        </div>
                    </li>

                    <!---------------Search---------------------------------->
                   <li>
                        <i class="search fa fa-search search-btn"></i>
                        <div class="search-open">
                            <form id="search-form" action="search" method="POST" >
                                <div class="input-group animated fadeInUp">
                                    <input type="text" id="what" name="what" class="form-control" placeholder="Search" aria-describedby="basic-addon2">
                                    <input type="submit" id="batman1234" class="btn btn-general btn-green" name="submit" value="Go">
                                </div>
                            </form>
                        </div>
                    </li> 
                    <!----------------------------------------------------->    
                    

                    <li>
                        <div class="top-menubar-nav">
                            <div class="topmenu ">
                                <div class="container">
                                    <div class="row">
                                        <div class="col-md-9">
                                            <ul class="list-inline top-contacts">
                                                <li>
                                                    <i class="fa fa-envelope"></i> Email: <a href="mailto:info@htmlstream.com">info@htmlstream.com</a>
                                                </li>
                                                <li>
                                                    <i class="fa fa-phone"></i> Hotline: (1) 396 4587 99
                                                </li>
                                            </ul>
                                        </div> 
                                        <div class="col-md-3">
                                            <ul class="list-inline top-data">
                                                <li><a href="#" target="_empty"><i class="fa top-social fa-facebook"></i></a></li>
                                                <li><a href="#" target="_empty"><i class="fa top-social fa-twitter"></i></a></li>
                                                <li><a href="#" target="_empty"><i class="fa top-social fa-google-plus"></i></a></li> 
                                                <li><a href="#" class="log-top" data-toggle="modal" data-target="#login-modal">Login</a></li>  
                                            </ul>
                                        </div>
                                    </div>
                                </div>
                            </div> 
                        </div>
                    </li>
                </c:if>



                <c:if test="${not empty administrator}">                   
                    <li class="nav-item dropdown" >
                        <a class="nav-link dropdown-toggle smooth-scroll" href="#" id="navbarDropdownMenuLink" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">Admin Panel</a> 
                        <div class="dropdown-menu dropdown-cust" aria-labelledby="navbarDropdownMenuLink"> 
                            <a class="dropdown-item"  href="${pageContext.request.contextPath}/admin/users">Users</a> 
                            <a class="dropdown-item"  href="${pageContext.request.contextPath}/admin/export">Export</a> 
                        </div>
                    </li>

                </c:if>
            </ul>  
        </div>
    </div>
</nav>