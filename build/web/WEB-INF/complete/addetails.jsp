<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>

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
                <h1 class="wow fadeInUp" data-wow-delay="0.1s">Ad Details</h1>
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
                                <label for="name" class="cols-sm-2 control-label">Title</label>
                                <div class="cols-sm-10">
                                    <div class="input-group">
                                        <span class="input-group-addon"><i class="fa fa-user fa" aria-hidden="true"></i></span>
                                        <input type="text" class="form-control" name="title" id="title"  value="${ad.title}" required="true"/>
                                    </div>
                                </div>
                            </div>
                            
                            <div class="form-group">
                                <label for="name" class="cols-sm-2 control-label">Description</label>
                                <div class="cols-sm-10">
                                    <div class="input-group">
                                        <span class="input-group-addon"><i class="fa fa-user fa" aria-hidden="true"></i></span>
                                        <input type="text" class="form-control" name="desc" id="desc"  value="${ad.description}" required="true"/>
                                    </div>
                                </div>
                            </div> 
                            
                            <div class="form-group">
                                <label for="name" class="cols-sm-2 control-label">Job</label>
                                <div class="cols-sm-10">
                                    <div class="input-group">
                                        <span class="input-group-addon"><i class="fa fa-user fa" aria-hidden="true"></i></span>
                                        <input type="text" class="form-control" name="jobId" id="jobId"  value="${ad.jobId.name}" required="true"/>
                                    </div>
                                </div>
                            </div>                            
                        </form>
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
