<%-- 
    Document   : login
    Created on : Nov 8, 2023, 8:01:51 AM
    Author     : Tung
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">

    <head>
        <meta charset="utf-8">
        <meta content="width=device-width, initial-scale=1.0" name="viewport">
        <title>TRAVELER</title>

        <!-- Google Web Fonts -->
        <link rel="preconnect" href="https://fonts.gstatic.com">
        <link href="https://fonts.googleapis.com/css2?family=Poppins:wght@400;500;600;700&display=swap" rel="stylesheet"> 

        <!-- Font Awesome -->
        <link href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.10.0/css/all.min.css" rel="stylesheet">

        <!-- Libraries Stylesheet -->
        <link href="lib/owlcarousel/assets/owl.carousel.min.css" rel="stylesheet">
        <link href="lib/tempusdominus/css/tempusdominus-bootstrap-4.min.css" rel="stylesheet" />

        <!-- Customized Bootstrap Stylesheet -->
        <link href="css/style.css" rel="stylesheet">
    </head>
    <body>
        <!-- Topbar Start -->
        <div class="container-fluid bg-light pt-3 d-none d-lg-block">
            <div class="container">
                <div class="row">
                    <div class="col-lg-6 text-center text-lg-left mb-2 mb-lg-0">
                        <div class="d-inline-flex align-items-center">
                            <p><i class="fa fa-envelope mr-2"></i>dinhsontung153@gmail.com</p>
                            <p class="text-body px-3">|</p>
                            <p><i class="fa fa-phone-alt mr-2"></i>+840 000 0000</p>
                        </div>
                    </div>
                    <div class="col-lg-6 text-center text-lg-right">
                        <div class="d-inline-flex align-items-center">
                            <a class="text-primary px-3" href="https://www.facebook.com/koffdarealest/" target="_blank">
                                <i class="fab fa-facebook-f"></i>
                            </a>
                            <a class="text-primary px-3" href="https://twitter.com/" target="_blank">
                                <i class="fab fa-twitter"></i>
                            </a>
                            <a class="text-primary px-3" href="https://www.linkedin.com/" target="_blank">
                                <i class="fab fa-linkedin-in"></i>
                            </a>
                            <a class="text-primary px-3" href="https://www.instagram.com/eb_gnut/" target="_blank">
                                <i class="fab fa-instagram"></i>
                            </a>
                            <a class="text-primary pl-3" href="https://www.youtube.com/" target="_blank">
                                <i class="fab fa-youtube"></i>
                            </a>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <!-- Topbar End -->


        <!-- Navbar Start -->
        <div class="container-fluid position-relative nav-bar p-0">
            <div class="container-lg position-relative p-0 px-lg-3" style="z-index: 9;">
                <nav class="navbar navbar-expand-lg bg-light navbar-light shadow-lg py-3 py-lg-0 pl-3 pl-lg-5">
                    <a href="" class="navbar-brand">
                        <h1 class="m-0 text-primary"><span class="text-dark">TRAVEL</span>ER</h1>
                    </a>
                    <button type="button" class="navbar-toggler" data-toggle="collapse" data-target="#navbarCollapse">
                        <span class="navbar-toggler-icon"></span>
                    </button>
                    <div class="collapse navbar-collapse justify-content-between px-3" id="navbarCollapse">
                        <div class="navbar-nav ml-auto py-0">
                            <a href="index" class="nav-item nav-link">Home</a>
                            <a href="package" class="nav-item nav-link">Tour Packages</a>
                            <a href="destination" class="nav-item nav-link">Destination</a>
                            <a href="booking" class="nav-item nav-link">BOOK NOW</a>
                            <c:choose>
                                <c:when test="${isLogged}">
                                    <a href="order" class="nav-item nav-link">Placed Order</a>
                                    <a href="logout" class="nav-item nav-link">Logout</a>
                                </c:when>
                                <c:otherwise>
                                    <a href="login" class="nav-item nav-link active">Login</a>
                                </c:otherwise>
                            </c:choose>    
                            <!--<a href="login" class="nav-item nav-link active">Log in & Sign up</a>-->               
                        </div>
                    </div>
                </nav>
            </div>
        </div>
        <!-- Navbar End -->

        <!--Header Start -->
        <div class="container-fluid page-header">
            <div class="container"> 
                <div class="d-flex flex-column align-items-center justify-content-center" style="min-height: 400px">
                    <div class="d-inline-flex text-white">
                        <h2 class="display-4 text-white text-uppercase">Sign in</h2>
                    </div>
                </div>
            </div>
        </div>
        <!-- Header End -->


        <!-- Login Form Start-->
        <div class="col-lg-5 mx-auto" style="margin-top: 50px;">
            <div class="card border-0">
                <div class="card-header bg-primary text-center p-4">
                    <h1 class="text-white m-0">Sign in</h1> 
                </div>         
                <div class="card-body rounded-bottom bg-white p-5">  
                    <form action="login" method="post">
                        <div class="form-group">
                            <input type="text" class="form-control p-4" placeholder="Username" name="username" required="required"/>
                        </div>
                        <div class="form-group">
                            <input type="password" class="form-control p-4" placeholder="Password" name="password" required="required" />
                        </div>                     
                        <div>
                            <button class="btn btn-primary btn-block py-3" type="submit">SIGN IN</button>
                        </div>
                        <div>
                        <label style="color: green; margin-top: 10px; margin-bottom: -40px">${createsuccess}</label>
                        </div>
                        <div style="margin-top: -10px; margin-bottom: -10px">
                            <label style="color: red; ">${error}</label>
                        </div>
                        <div class="form-group text-center" style="margin-top: -20px">
                            <br>
                            <label>No account yet ?</label>
                            <a href="signup">SIGN UP HERE</a>
                        </div>
                    </form>
                </div>
            </div>
        </div>
        <!-- Login Form End-->    


        <!-- Footer Start -->
        <div class="container-fluid bg-dark text-white-50 py-5 px-sm-3 px-lg-5" style="margin-top: 90px;">
            <div class="row pt-5">
                <div class="col-lg-3 col-md-6 mb-5">
                    <a href="" class="navbar-brand">
                        <h1 class="text-primary" style="margin-top: -10px;"><span class="text-white">TRAVEL</span>ER</h1>
                    </a>
                    <p>Always bringing you the best options, most worthy of the money you spend. Besides, providing you with all the services so you can REALLY enjoy the trip</p>
                    <h6 class="text-white text-uppercase mt-4 mb-3" style="letter-spacing: 5px;">Follow Me</h6>
                    <div class="d-flex justify-content-start">
                        <a class="btn btn-outline-primary btn-square mr-2" href="https://twitter.com/" target="_blank"><i class="fab fa-twitter"></i></a>
                        <a class="btn btn-outline-primary btn-square mr-2" href="https://www.facebook.com/koffdarealest/" target="_blank"><i class="fab fa-facebook-f"></i></a>
                        <a class="btn btn-outline-primary btn-square mr-2" href="https://www.linkedin.com/" target="_blank"><i class="fab fa-linkedin-in"></i></a>
                        <a class="btn btn-outline-primary btn-square" href="https://www.instagram.com/eb_gnut/" target="_blank"><i class="fab fa-instagram"></i></a>
                    </div>
                </div>
                <div class="col-lg-3 col-md-6 mb-5">
                    <h5 class="text-white text-uppercase mb-4" style="letter-spacing: 3px;">Our Services</h5>
                    <div class="d-flex flex-column justify-content-start">
                        <a class="text-white-50 mb-2" href="#"><i class="fa fa-angle-right mr-2"></i>About</a>
                        <a class="text-white-50 mb-2" href="#"><i class="fa fa-angle-right mr-2"></i>Destination</a>
                        <a class="text-white-50 mb-2" href="#"><i class="fa fa-angle-right mr-2"></i>Services</a>
                        <a class="text-white-50 mb-2" href="#"><i class="fa fa-angle-right mr-2"></i>Packages</a>
                    </div>
                </div>
                <div class="col-lg-3 col-md-6 mb-5">
                    <h5 class="text-white text-uppercase mb-4" style="letter-spacing: 3px;">Useful Links</h5>
                    <div class="d-flex flex-column justify-content-start">
                        <a class="text-white-50 mb-2" href="#"><i class="fa fa-angle-right mr-2"></i>About</a>
                        <a class="text-white-50 mb-2" href="#"><i class="fa fa-angle-right mr-2"></i>Destination</a>
                        <a class="text-white-50 mb-2" href="#"><i class="fa fa-angle-right mr-2"></i>Services</a>
                        <a class="text-white-50 mb-2" href="#"><i class="fa fa-angle-right mr-2"></i>Packages</a>   
                    </div>
                </div>
                <div class="col-lg-3 col-md-6 mb-5">
                    <h5 class="text-white text-uppercase mb-4" style="letter-spacing: 3px;">Contact Us</h5>
                    <p><i class="fa fa-map-marker-alt mr-2"></i>FPT University, Hanoi, Vietnam</p>
                    <p><i class="fa fa-phone-alt mr-2"></i>+84000000000</p>
                    <p><i class="fa fa-envelope mr-2"></i>dinhsontung153@gmail.com</p>
                </div>
            </div>
        </div>
        <!-- Footer End -->


        <!-- Back to Top -->
        <a href="#" class="btn btn-lg btn-primary btn-lg-square back-to-top"><i class="fa fa-angle-double-up"></i></a>


        <!-- JavaScript Libraries -->
        <script src="https://code.jquery.com/jquery-3.4.1.min.js"></script>
        <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.bundle.min.js"></script>
        <script src="https://cdn.jsdelivr.net/npm/flatpickr"></script>
        <script src="lib/easing/easing.min.js"></script>
        <script src="lib/owlcarousel/owl.carousel.min.js"></script>
        <script src="lib/tempusdominus/js/moment.min.js"></script>
        <script src="lib/tempusdominus/js/moment-timezone.min.js"></script>
        <script src="lib/tempusdominus/js/tempusdominus-bootstrap-4.min.js"></script>

        <!-- Contact Javascript File -->
        <script src="mail/jqBootstrapValidation.min.js"></script>
        <script src="mail/contact.js"></script>

        <!-- Template Javascript -->
        <script src="js/main.js"></script>
    </body>

</html>