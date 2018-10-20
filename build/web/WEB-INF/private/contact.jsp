<%-- 
    Document   : service
    Created on : Aug 28, 2018, 3:01:28 PM
    Author     : alex
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>

<div class="overlay-contact-h"></div>
<section id="contact-h" class="bg-parallax contact-h-bg">
    <div class="container">
        <div class="row">
            <div class="col-md-6">
                <div class="contact-h-cont">
                    <h3 class="cl-white">Continue The Conversation</h3><br>
                    <form>
                        <div class="form-group cl-white">
                            <label for="name">Your Name</label>
                            <input type="text" class="form-control" id="name" aria-describedby="nameHelp" placeholder="Enter name"> 
                        </div>  
                        <div class="form-group cl-white">
                            <label for="exampleInputEmail1">Email address</label>
                            <input type="email" class="form-control" id="exampleInputEmail1" aria-describedby="emailHelp" placeholder="Enter email"> 
                        </div>  
                        <div class="form-group cl-white">
                            <label for="subject">Subject</label>
                            <input type="text" class="form-control" id="subject" aria-describedby="subjectHelp" placeholder="Enter subject"> 
                        </div>  
                        <div class="form-group cl-white">
                            <label for="message">Message</label>
                            <textarea class="form-control" id="message" rows="3"></textarea>
                        </div>  
                        <button class="btn btn-general btn-white" role="button"><i fa fa-right-arrow></i>GET CONVERSATION</button>
                    </form>
                </div>
            </div>
        </div>
    </div>         
</section> 