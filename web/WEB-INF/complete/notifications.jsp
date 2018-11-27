<%@page contentType="text/html" pageEncoding="UTF-8"%>


<!DOCTYPE html>
<html lang="en">

    <jsp:include page="/WEB-INF/private/head.jsp"/> 

    <body id="page-top">

        <!--====================================================
                                 HEADER
        ======================================================--> 

        <header>

            <jsp:include page="/WEB-INF/private/topmenubar.jsp"/>


            <!-- Navbar -->

            <jsp:include page="/WEB-INF/private/navbar.jsp"/>

        </header> 
            
        <!--====================================================
                              HOME-P
       ======================================================-->       

        <div id="home-p" class="home-p  text-center"> 
            <div class="container">
                <h1 class="wow fadeInUp" data-wow-delay="0.1s">Notifications</h1>
            </div>
        </div>         
            



        <!--====================================================
                                single-news-p1
        ======================================================--> 
        <section id="single-news-p1" class="single-news-p1">
            <div class="container" style="width:35%">
                <div class="bg-gray" > 
                    <div class="ad-box-sn"> 
                        <div class="bg-light-gray" >
                            <center>
                                <div class="card" style="width: 100%">
                                    <div class="bg-light-gray" > 
                                        <div class="desc-comp-offer-cont">
                                            &nbsp;<center><h5 style="color:#777;" class="pb-2">Connection Requests</h5></center>
                                            <div class="bg-white" >                                  
                                                <left><img src="img/news/friend2.jpg" class="img-fluid" alt="..."style="width:17%;"></left>
                                            </div>
                                            <a href="${pageContext.request.contextPath}/managerequests">
                                                <button class="btn btn-general btn-green" style="width: 50%;" role="button">See all</button> </a>
                                        </div>
                                    </div>
                                </div>              
                            </center>              

                        </div>
                    </div>
                </div>
            </div>
        </section>  

        &nbsp; &nbsp;  &nbsp; 

        <section id="single-news-p1" class="single-news-p1">
            <div class="container" style="width:35%">
                <div class="bg-gray" > 
                    <div class="ad-box-sn"> 
                        <div class="bg-light-gray" >
                            <center>
                                <div class="card" style="width: 100%">
                                    <div class="bg-light-gray" >   
                                        <div class="desc-comp-offer-cont">
                                            &nbsp;<center><h5 style="color:#777;" class="pb-2">Notes of Interest</h5></center>
                                            <div class="bg-white" >                                 
                                                <left><img src="img/news/note.jpg" class="img-fluid" alt="..."style="width:15%;"></left>
                                            </div>
                                            <a href="${pageContext.request.contextPath}/notesreactions">
                                                <button class="btn btn-general btn-green" style="width: 50%;" role="button">More</button> </a>
                                        </div>
                                    </div>
                                </div>              
                            </center>              

                        </div>
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

