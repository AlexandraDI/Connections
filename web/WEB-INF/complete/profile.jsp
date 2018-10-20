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
            <img src="${pageContext.request.contextPath}/img/news/man2.png" alt="user" style="width:7%;"> 
            <div class="container">
                <h1 class="wow fadeInUp" data-wow-delay="0.1s">Personal Information</h1>
            </div>
        </div> 

       
        <!--====================================================
                                FORM
        ======================================================-->
        <section class="shop-form bg-gray" id="shop-form">
            <div class="container">
                <div class="row"> 
                    <div class="col-md-10 main-login main-center">
                        <form class="form-horizontal" method="post" action="#">
                            <div class="form-group">
                                <label for="name" class="cols-sm-2 control-label">Name</label>
                                <div class="cols-sm-10">
                                    <div class="input-group">
                                        <span class="input-group-addon"><i class="fa fa-user fa-lg" aria-hidden="true"></i></span>
                                        <input type="text" class="form-control" name="firstname" id="firstname" value="${me.firstname}"  placeholder="Enter your firstname"/>
                                    </div>
                                </div>
                            </div>
                            
                            <div class="form-group">
                                <label for="name" class="cols-sm-2 control-label">Surname</label>
                                <div class="cols-sm-10">
                                    <div class="input-group">
                                        <span class="input-group-addon"><i class="fa fa-user fa-lg" aria-hidden="true"></i></span>
                                        <input type="text" class="form-control" name="surname" id="surname" value="${me.surname}"  placeholder="Enter your surname"/>
                                    </div>
                                </div>
                            </div>
                            

                            <div class="form-group">
                                <label for="email" class="cols-sm-2 control-label">Email</label>
                                <div class="cols-sm-10">
                                    <div class="input-group">
                                        <span class="input-group-addon"><i class="fa fa-envelope fa-lg" aria-hidden="true"></i></span>
                                        <input type="text" class="form-control" name="email" id="email" value="${me.email}"  placeholder="Enter your Email"/>
                                    </div>
                                </div>
                            </div>

                            <div class="form-group">
                                <label for="phone" class="cols-sm-2 control-label">Phone Number</label>
                                <div class="cols-sm-10">
                                    <div class="input-group">
                                        <span class="input-group-addon"><i class="fa fa-phone fa-lg" aria-hidden="true"></i></span>
                                        <input type="text" class="form-control" name="phonenumber" id="phonenumber" value="${me.phoneNumber}"  placeholder="Enter your Phone Number"/>
                                    </div>
                                </div>
                            </div>

                            <div class="form-group">
                                <label for="birthday" class="cols-sm-2 control-label">Birthday</label>
                                <div class="cols-sm-10">
                                    <div class="input-group">
                                        <span class="input-group-addon"><i class="fa fa-calendar fa-lg" aria-hidden="true"></i></span>
                                        <input type="text" class="form-control" name="birthday" id="birthday" value="${me.birthday}"  placeholder="Enter your Birthday"/>
                                    </div>
                                </div>
                            </div>

                            <div class="form-group">
                                <label for="birthplace" class="cols-sm-2 control-label">Birthplace</label>
                                <div class="cols-sm-10">
                                    <div class="input-group">
                                        <span class="input-group-addon"><i class="fa fa-birthday-cake fa-lg" aria-hidden="true"></i></span>
                                        <input type="text" class="form-control" name="birthplace" id="birthplace" value="${me.birthplace.street}"  placeholder="Enter your Birthplace"/>
                                    </div>
                                </div>
                            </div>
                                    
                            <div class="form-group">
                                <label for="facebook" class="cols-sm-2 control-label">Facebook Url</label>
                                <div class="cols-sm-10">
                                    <div class="input-group">
                                        <span class="input-group-addon"><i class="fa fa-facebook-official fa-lg" aria-hidden="true"></i></span>
                                        <input type="text" class="form-control" name="facebookUrl" id="facebookUrl" value="${me.facebookUrl}"  placeholder="Enter your FacebookUrl"/>
                                    </div>
                                </div>
                            </div>
                                    
                            <div class="form-group">
                                <label for="location" class="cols-sm-2 control-label">Current Location</label>
                                <div class="cols-sm-10">
                                    <div class="input-group">
                                        <span class="input-group-addon"><i class="fa fa-location-arrow fa-lg" aria-hidden="true"></i></span>
                                        <input type="text" class="form-control" name="curentLocation" id="curentLocation" value="${me.curentLocation.street} ${me.curentLocation.number}, ${me.curentLocation.cityId.name}"  placeholder="Enter your Current Location"/>
                                    </div>
                                </div>
                            </div>

                            <div class="form-group">
                                <label for="interest" class="cols-sm-2 control-label">Interests</label>
                                <div class="cols-sm-10">
                                    <div class="input-group">
                                        <span class="input-group-addon"><i class="fa fa-child fa-lg" aria-hidden="true"></i></span>
                                        <input type="text" class="form-control" name="otherInterests" id="otherInterests" value="${me.otherInterests}"  placeholder="Enter your Interests"/>
                                    </div>
                                </div>
                            </div>                                    


                            <div class="form-group ">
                                <a href="#" class="btn btn-general btn-white text-center">Update</a>
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
