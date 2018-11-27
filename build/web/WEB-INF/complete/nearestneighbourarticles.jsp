<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">

    <jsp:include page="/WEB-INF/private/head.jsp"/>  

    <body id="page-top">


        <header>

            <jsp:include page="/WEB-INF/private/topmenubar.jsp"/>


            <!-- Navbar -->

            <jsp:include page="/WEB-INF/private/navbar.jsp"/>
            
            
            

        </header> 

        <!--====================================================
                               HOME-P
        ======================================================-->
        <div class="free space">
        </div> 

        <!--====================================================
                                single-news-p1
        ======================================================--> 
        <section id="single-news-p1" class="single-news-p1">

            <div class="container">   
                <div class="row">




                    <div class="col-md-3">                                     
                        <div class="ad-box-sn">              

                            <div class="card">
                                <div class="desc-comp-offer-cont">
                                    <div class="thumbnail-blogs">
                                        <div class="caption">
                                            <a href="${pageContext.request.contextPath}/profile">   
                                                <i class="fa fa-chain"></i></a>
                                        </div>
                                        <center><img src="img/news/man2.jpg" alt="..." style="width:50%;"></center>
                                    </div>
                                </div>    
                                <h6><center>Welcome, ${me.firstname}! </center></h6><%--<center>${me.userId}</center>--%>
                                <p> <a href="${pageContext.request.contextPath}/network"> <center>My connections</center></a> </p>
                                <a href="${pageContext.request.contextPath}/profile"><center> <i class="fa fa-arrow-circle-o-right"></i> Read More</center></a>
                            </div>                           
                            </div> 
                            </br>

                        <div class="ad-box-sn">              
                           
                            <div class="card">                                
                                <div class="desc-comp-offer-cont">
                                 
                                </br><center><h5><font color="dimgray">Create an Article</font></h5></center></br>
                                <hr>
                                <form method="post" id="login-form" action="xronologio">
                                    <center><input type="text" name="title" placeholder="Title" required="true" class="form-control" style="width: 80%;"></center><br>
                                    <center><textarea name="content" placeholder="Text" required="true" class="form-control" style="width: 80%;"></textarea></center>

                                    <center><p>${result}</p></center>                                    
                                    <input type="submit" value="POST" class="btn btn-general btn-green" style="width: 100%;" required="true">
                                </form>
                               </div>


                            </div> 

                        </div> 


                    </div> 


                    <jsp:include page="/WEB-INF/private/articles.jsp"/>


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

