<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

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
            <div class="container">
                <h1 class="wow fadeInUp" data-wow-delay="0.1s">Privacy Options</h1>
            </div>
        </div>  


        <!--====================================================
                                FORM
        ======================================================-->
        <section class="shop-form bg-gray" id="shop-form">
            <div class="container">
                <div class="row"> 
                    <div class="col-md-10 main-login main-center">
                        <form method="post" id="login-form" action="">
                            <div class="form-group">
                                <label for="password" class="cols-sm-2 control-label">Access to Basic Information</label>
                                <div class="cols-sm-10">
                                    <div class="input-group">
                                        <select class="form-control"  name="basicsettingId">  
                                            <option  value="${usersetting.userHasSettingList[0].value}">${usersetting.userHasSettingList[0].value}</option>
                                            <c:if test="${usersetting.userHasSettingList[0].value eq "PUBLIC"}">
                                                <option  value="FRIENDS">FRIENDS</option>                        
                                            </c:if> 
                                            <c:if test="${usersetting.userHasSettingList[0].value eq "FRIENDS"}">
                                                <option  value="PUBLIC">PUBLIC</option>                        
                                            </c:if>                                                     
                                        </select>
                                    </div>
                                </div>
                            </div>

                            <div class="form-group">
                                <label for="password" class="cols-sm-2 control-label">Access to Rest Information</label>
                                <div class="cols-sm-10">
                                    <div class="input-group">
                                        <select class="form-control"  name="restsettingId">
                                            <option  value="${usersetting.userHasSettingList[1].value}">${usersetting.userHasSettingList[1].value}</option>
                                            <c:if test="${usersetting.userHasSettingList[1].value eq "PUBLIC"}">
                                                <option  value="FRIENDS">FRIENDS</option>                        
                                            </c:if> 
                                            <c:if test="${usersetting.userHasSettingList[1].value eq "FRIENDS"}">
                                                <option  value="PUBLIC">PUBLIC</option>                        
                                            </c:if>                                             
                                        </select>
                                    </div>
                                </div>
                            </div>


                            <div class="form-group">
                                <label for="password" class="cols-sm-2 control-label">Access to Languages</label>
                                <div class="cols-sm-10">
                                    <div class="input-group">
                                        <select class="form-control"  name="languagesettingId">
                                            <option  value="${usersetting.userHasSettingList[2].value}">${usersetting.userHasSettingList[2].value}</option>
                                            <c:if test="${usersetting.userHasSettingList[2].value eq "PUBLIC"}">
                                                <option  value="FRIENDS">FRIENDS</option>                        
                                            </c:if> 
                                            <c:if test="${usersetting.userHasSettingList[2].value eq "FRIENDS"}">
                                                <option  value="PUBLIC">PUBLIC</option>                        
                                            </c:if>                                              
                                        </select>
                                    </div>
                                </div>
                            </div>

                            <div class="form-group">
                                <label for="password" class="cols-sm-2 control-label">Access to Professional Experience</label>
                                <div class="cols-sm-10">
                                    <div class="input-group">
                                        <select class="form-control"  name="experiencesettingId">
                                            <option  value="${usersetting.userHasSettingList[3].value}">${usersetting.userHasSettingList[3].value}</option>
                                            <c:if test="${usersetting.userHasSettingList[3].value eq "PUBLIC"}">
                                                <option  value="FRIENDS">FRIENDS</option>                        
                                            </c:if> 
                                            <c:if test="${usersetting.userHasSettingList[3].value eq "FRIENDS"}">
                                                <option  value="PUBLIC">PUBLIC</option>                        
                                            </c:if>                                
                                        </select>
                                    </div>
                                </div>
                            </div>  

                            <div class="form-group">
                                <label for="password" class="cols-sm-2 control-label">Access to Skills</label>
                                <div class="cols-sm-10">
                                    <div class="input-group">
                                        <select class="form-control"  name="skillsettingId">
                                            <option  value="${usersetting.userHasSettingList[4].value}">${usersetting.userHasSettingList[4].value}</option>
                                            <c:if test="${usersetting.userHasSettingList[4].value eq "PUBLIC"}">
                                                <option  value="FRIENDS">FRIENDS</option>                        
                                            </c:if> 
                                            <c:if test="${usersetting.userHasSettingList[4].value eq "FRIENDS"}">
                                                <option  value="PUBLIC">PUBLIC</option>                        
                                            </c:if>                                
                                        </select>
                                    </div>
                                </div>
                            </div> 

                            <div class="form-group">
                                <label for="password" class="cols-sm-2 control-label">Access to Education</label>
                                <div class="cols-sm-10">
                                    <div class="input-group">
                                        <select class="form-control"  name="educationsettingId">
                                            <option  value="${usersetting.userHasSettingList[5].value}">${usersetting.userHasSettingList[5].value}</option>
                                            <c:if test="${usersetting.userHasSettingList[5].value eq "PUBLIC"}">
                                                <option  value="FRIENDS">FRIENDS</option>                        
                                            </c:if> 
                                            <c:if test="${usersetting.userHasSettingList[5].value eq "FRIENDS"}">
                                                <option  value="PUBLIC">PUBLIC</option>                        
                                            </c:if>                                
                                        </select>
                                    </div>
                                </div>
                            </div>                            


                            <input type="submit" value="POST" class="btn btn-general btn-green" style="width: 100%;" required="true">
                        </form>

                        ${result}
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
