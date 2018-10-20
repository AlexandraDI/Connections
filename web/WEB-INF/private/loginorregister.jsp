

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<section id="login">
    <div class="modal fade" id="login-modal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true" style="display: none;">
        <div class="modal-dialog">
            <div class="modal-content">
                <div class="modal-header" align="center">
                    <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                        <span class="fa fa-times" aria-hidden="true"></span>
                    </button>
                </div>
                <div id="div-forms">
                    <form id="login-form" action="" method="POST" >
                        <h3 class="text-center">Login</h3>
                        <div class="modal-body">
                            <label for="email">Email</label> 
                            <input id="email" name="email" class="form-control" type="text" placeholder="Enter email " required>
                            <label for="password">Password</label> 
                            <input id="password" name="password" class="form-control" type="password" placeholder="Enter password" required>
                            <!--<div class="checkbox">
                                <label>
                                    <input type="checkbox"> Remember me
                                </label>
                            </div> -->
                        </div>
                        <div class="modal-footer text-center">
                            <div>
                                <button type="submit" class="btn btn-general btn-white">Login</button>
                            </div>
                            <div>
                                <button id="login_register_btn" type="button" class="btn btn-link">Register</button>
                            </div>
                        </div>
                    </form>
                    <form id="register-form" action="" method="POST" style="display:none;">
                        <h3 class="text-center">Register</h3>
                        <div class="modal-body"> 
                            <label for="password">Password</label> 
                            <input id="password" name="password" class="form-control" type="password" placeholder="Enter password" required>
                            <label for="confirm_password">Confirm Password</label> 
                            <input id="confirm_password" name="confirm_password" class="form-control" type="password" placeholder="Enter password" required>
                            <label for="first_name">First Name</label> 
                            <input id="first_name" name="first_name" class="form-control" type="text" placeholder="Enter first name" required>
                            <label for="last_name">Last Name</label> 
                            <input id="surname" name="surname" class="form-control" type="text" placeholder="Enter last name" required>
                            <label for="email">Email</label> 
                            <input id="email" name="email" class="form-control" type="text" placeholder="Enter email" required>
                            <label for="phonenumber">Telephone</label> 
                            <input id="phonenumber" name="phonenumber" class="form-control" type="text" placeholder="Enter Telephone" required>
                            <label for="pictureurl">Photo</label> 
                            <input id="pictureurl" name="pictureurl" class="form-control" type="text" placeholder="Enter photo" value="https://cdn.vox-cdn.com/images/verge/default-avatar.v989902574302a6378709709f7baab789b242ebbb.gif" required>                            
                        </div>
                        <div class="modal-footer">
                            <div>
                                <button type="submit" class="btn btn-general btn-white">Register</button>
                            </div>
                            <div>
                                <button id="register_login_btn" type="button" class="btn btn-link">Log In</button>
                            </div>
                        </div>
                    </form>
                </div>
            </div>
        </div>
    </div>
               
    

</section>      
