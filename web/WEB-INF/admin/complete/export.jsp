<%-- 
    Document   : newjspexport
    Created on : Aug 28, 2018, 3:31:48 PM
    Author     : alex
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>

<!--
author: Boostraptheme
author URL: https://boostraptheme.com
License: Creative Commons Attribution 4.0 Unported
License URL: https://creativecommons.org/licenses/by/4.0/
-->

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

            <div class="content-inner form-cont">
                <div class="row">
                    <div class="col-md-12">

                        <!--***** BASIC FORM *****-->
                        <div class="card form" id="form1">
                            <div class="card-header">
                                <h3>Export data</h3>
                            </div>
                            <br>
                            <form method="post" action="">

                                <div class="row">
                                    <input type="hidden" name="do" value="exportall">
                                    <button type="download" class="btn btn-general btn-blue mr-2">Download all as XML</button>  
                                </div>
                            </form>

                            <br>
                            <form method="post"  action="">
                                <div class="row">
                                    <input type="hidden" name="do" value="exportsome">
                                    <button type="download" class="btn btn-general btn-blue mr-2">Download selected as XML</button>  
                                </div>
                                <br>

                                <div class="row">
                                    <table class="table table-hover">
                                        <thead>
                                            <tr class="bg-info text-white">
                                                <th>&nbsp;</th>
                                                <th>ID</th>
                                                <th>First Name</th>
                                                <th>Last Name</th>
                                                <th>Email</th>
                                                <th>birthday</th>
                                                <th>phone</th>
                                                <th>photo</th>
                                                <th>actions</th>
                                            </tr>
                                        </thead>
                                        <tbody>
                                            <c:forEach items="${userlist}" var="user"> 
                                                <tr>
                                                    <td><input type="checkbox" id="checkbox${user.userId}" name="selectors" value="${user.userId}"></td>
                                                    <td>${user.userId}</td>
                                                    <td>${user.firstname}</td>
                                                    <td>${user.surname}</td>
                                                    <td>${user.email}</td>
                                                    <td>${user.birthday}</td>
                                                    <td>${user.phoneNumber}</td>

                                                    <td>
                                                        <a rel="nofollow" href="#" class="dropdown-item d-flex">

                                                            <c:if test="${not empty user.pictureUrl}">
                                                                <img src="${user.pictureUrl}" style="height:30px; width:30px;" class="img-fluid rounded-circle">
                                                            </c:if>

                                                            <c:if test="${empty user.pictureUrl}">
                                                                <img src="https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQN-xwSx-IDgDa1O_L3HFukoKmMN1W66GXlFMoItRdyN7zVbLCG" style="height:30px; width:30px;" class="img-fluid rounded-circle">
                                                            </c:if>
                                                        </a>
                                                    </td>

                                                    <td><a href="${pageContext.request.contextPath}/admindetails?id=${user.userId}">view</a></td>
                                                </tr>
                                            </c:forEach>
                                            <!--                            <tr class="table-warning">
                                                                            <th scope="row">2</th>
                                                                            <td>Jacob</td>
                                                                            <td>Thornton</td>
                                                                            <td>@fat</td>
                                                                        </tr>
                                                                        <tr>
                                                                            <th scope="row">3</th>
                                                                            <td>Larry</td>
                                                                            <td>the Bird</td>
                                                                            <td>@twitter</td>
                                                                        </tr>
                                                                        <tr class="table-success">
                                                                            <th scope="row">3</th>
                                                                            <td>Mark</td>
                                                                            <td>Otto</td>
                                                                            <td>@mdo</td>
                                                                        </tr>
                                                                        <tr>
                                                                            <th scope="row">4</th>
                                                                            <td>Jacob</td>
                                                                            <td>Thornton</td>
                                                                            <td>@fat</td>
                                                                        </tr>
                                                                        <tr class="table-danger">
                                                                            <th scope="row">5</th>
                                                                            <td>Larry</td>
                                                                            <td>the Bird</td>
                                                                            <td>@twitter</td>
                                                                        </tr>
                                                                        <tr>
                                                                            <th scope="row">6</th>
                                                                            <td>Mark</td>
                                                                            <td>Otto</td>
                                                                            <td>@mdo</td>
                                                                        </tr>
                                                                        <tr class="table-info">
                                                                            <th scope="row">7</th>
                                                                            <td>Jacob</td>
                                                                            <td>Thornton</td>
                                                                            <td>@fat</td>
                                                                        </tr>
                                                                        <tr>
                                                                            <th scope="row">8</th>
                                                                            <td>Larry</td>
                                                                            <td>the Bird</td>
                                                                            <td>@twitter</td>
                                                                        </tr>
                                                                        <tr class="table-warning">
                                                                            <th scope="row">9</th>
                                                                            <td>Mark</td>
                                                                            <td>Otto</td>
                                                                            <td>@mdo</td>
                                                                        </tr>
                                                                        <tr>
                                                                            <th scope="row">10</th>
                                                                            <td>Jacob</td>
                                                                            <td>Thornton</td>
                                                                            <td>@fat</td>
                                                                        </tr>
                                                                        <tr class="table-success">
                                                                            <th scope="row">11</th>
                                                                            <td>Larry</td>
                                                                            <td>the Bird</td>
                                                                            <td>@twitter</td>
                                                                        </tr>-->
                                        </tbody>
                                    </table>
                                </div> 
                            </form>
                        </div>
                        &nbsp;
                    </div>
                </div>
            </div>
        </div>

        <jsp:include page="/WEB-INF/admin/private/code/js.jsp"/> 
    </body>

</html>