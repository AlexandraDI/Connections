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
                                            &nbsp;<center><h5 style="color:#777;" class="pb-2">Reactions</h5></center>
                                            <div class="bg-white" >                                   
                                                <left><img src="img/news/friend2.jpg" class="img-fluid" alt="..."style="width:25%;"></left>
                                            </div>
                                            <a href="${pageContext.request.contextPath}/notesreactions">
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
                                            &nbsp;<center><h5 style="color:#777;" class="pb-2">Comments</h5></center>
                                            <div class="bg-white" >                                   
                                                <left><img src="img/news/notes2.jpg" class="img-fluid" alt="..."style="width:20%;"></left>
                                            </div>
                                            <a href="${pageContext.request.contextPath}/notescomments">
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




        <!--====================================================
                              FOOTER
        ======================================================--> 
        <jsp:include page="/WEB-INF/private/footer.jsp"/>

        <!--Global JavaScript -->
        <jsp:include page="/WEB-INF/private/code/js.jsp"/>
    </body>

</html>

