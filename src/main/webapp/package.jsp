<%-- 
    Document   : package
    Created on : Oct 24, 2023, 9:23:22 AM
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
                            <a class="text-primary px-3" href="https://www.facebook.com/koffdarealest/">
                                <i class="fab fa-facebook-f"></i>
                            </a>
                            <a class="text-primary px-3" href="">
                                <i class="fab fa-twitter"></i>
                            </a>
                            <a class="text-primary px-3" href="">
                                <i class="fab fa-linkedin-in"></i>
                            </a>
                            <a class="text-primary px-3" href="">
                                <i class="fab fa-instagram"></i>
                            </a>
                            <a class="text-primary pl-3" href="">
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
                            <a href="package" class="nav-item nav-link active">Tour Packages</a>
                            <a href="destination" class="nav-item nav-link">Destination</a>
                            <a href="booking" class="nav-item nav-link">BOOK NOW</a>
                            <c:choose>
                                <c:when test="${isLogged}"> 
                                    <a href="order" class="nav-item nav-link">Placed Order</a>
                                    <a href="logout" class="nav-item nav-link">Logout</a>
                                </c:when>
                                <c:otherwise>
                                    <a href="login" class="nav-item nav-link">Login</a>
                                </c:otherwise>
                            </c:choose>   
                            <!--<a href="login" class="nav-item nav-link">Log in & Sign up</a>-->
                        </div>
                    </div>
                </nav>
            </div>
        </div>
        <!-- Navbar End -->


        <!-- Header Start -->
        <div class="container-fluid page-header">
            <div class="container">
                <div class="d-flex flex-column align-items-center justify-content-center" style="min-height: 400px">
                    <h2 class="display-4 text-white text-uppercase">Packages</h2>
                </div>
            </div>
        </div>
        <!-- Header End -->


        <!-- Filter Start -->
        <div class="container-fluid booking mt-5 pb-5" style="margin-bottom: -125px;">
            <div class="container pb-5">
                <div class="bg-light shadow" style="padding: 30px;">
                    <form method="post" action="filter">
                        <div class="row align-items-center" style="min-height: 60px;">
                            <div class="col-md-10">
                                <div class="row">
                                    <div class="col-md-3">
                                        <div class="mb-3 mb-md-0">
                                            <select name="country" class="custom-select px-4" style="height: 47px;">
                                                <option value="nothing" selected>Country</option>
                                                <c:forEach items="${listdest}" var="o">
                                                    <option value="${o.destination}">${o.destination}</option>
                                                </c:forEach>
                                            </select>
                                        </div>
                                    </div>
                                    <div class="col-md-3">
                                        <div class="mb-3 mb-md-0">
                                            <select name="numofperson" class="custom-select px-4" style="height: 47px;">
                                                <option value="nothing" selected>Num Of Person</option>
                                                <option value="1person">1-2 Persons</option>
                                                <option value="3person">3-4 Persons</option>
                                                <option value="5person">5-7 Persons</option>
                                            </select>
                                        </div>
                                    </div>
                                    <div class="col-md-3">
                                        <div class="mb-3 mb-md-0">
                                            <select name="price" class="custom-select px-4" style="height: 47px;">
                                                <option value="nothing" selected>Price</option>
                                                <option value="1price">Under 1000$</option>
                                                <option value="2price">1000$-2000$</option>
                                                <option value="3price">More than 2000$</option>
                                            </select>
                                        </div>
                                    </div>
                                    <div class="col-md-3">
                                        <div class="mb-3 mb-md-0">
                                            <select name="duration" class="custom-select px-4" style="height: 47px;">
                                                <option value="nothing" selected>Duration</option>
                                                <option value="3dur">3-5 days</option>
                                                <option value="6dur">6-10 days</option>
                                                <option value="10dur">More than 10 days</option>
                                            </select>
                                        </div>
                                    </div>
                                </div>
                            </div>
                            <div class="col-md-2">
                                <button class="btn btn-primary btn-block" type="submit" style="height: 47px; margin-top: -1px;">Find</button>
                            </div>
                        </div>
                    </form>
                </div>
            </div>
        </div>
        <!-- Filter End -->




        <!-- Packages Start -->
        <div class="container-fluid py-5">
            <div class="container pt-5 pb-3">
                <div class="text-center mb-3 pb-3">
                    <h6 class="text-primary text-uppercase" style="letter-spacing: 5px;">Packages</h6>
                    <h1>Perfect Tour Packages</h1>
                </div>
                <!-- Sorting Start -->
                <form action="sort" method="post">  
                    <div class="row">
                        <div class="col-md-3">
                            <div class="mb-2 mb-md-0">
                                <select name="sort" class="custom-select px-4" style="height: 40px;">
                                    <option value="nothing" selected>Sort By</option>
                                    <option value="ratedesc">Rating ( &#8595 )</option>
                                    <option value="rateasc">Rating ( &#8593 )</option>
                                    <option value="pricedesc">Price ( &#8595 )</option>
                                    <option value="priceasc">Price ( &#8593 )</option>
                                    <option value="durdesc">Duration ( &#8595 )</option>
                                    <option value="durasc">Duration ( &#8593 )</option>
                                    <option value="nopdesc">Number Of People ( &#8595 )</option>
                                    <option value="nopasc">Number Of People ( &#8593 )</option>
                                </select>
                            </div>
                        </div>
                        <div class="col-md-1">
                            <button class="btn btn-primary btn-block" type="submit" style="height: 40px;">Sort</button>
                        </div>
                    </div>
                </form>
                <!-- Sorting End -->
                <br>
                <div class="row">
                    <c:forEach items = "${listtour}" var ="o">
                        <div class="col-lg-4 col-md-6 mb-4">
                            <form action="booking" method="post">
                                <div class="package-item bg-white mb-2">
                                    <img class="img-fluid" src="${o.image}" alt="">
                                    <div class="p-4">
                                        <div class="d-flex justify-content-between mb-3">
                                            <small class="m-0"><i class="fa fa-map-marker-alt text-primary mr-2"></i>${o.destination}</small>
                                            <small class="m-0"><i class="fa fa-calendar-alt text-primary mr-2"></i>${o.numOfDay} Day</small>
                                            <small class="m-0"><i class="fa fa-user text-primary mr-2"></i>${o.numOfPerson} Person</small>
                                        </div>
                                        <a class="h5 text-decoration-none" href="">${o.name}</a>
                                        <p>${o.describe}</p>
                                        <div class="border-top mt-4 pt-4">
                                            <div class="d-flex justify-content-between" style="margin-bottom: -10px;">
                                                <h5 class="m-0"><i class="fa fa-star text-primary mr-2"></i>${o.rating}</h5>
                                                <button class="col-md-4 btn btn-primary" type="submit" style="height: 30px; font-size: smaller ">Book</button>
                                                <input type="hidden" name="chosentour" value="${o.ID}"/>
                                                <h5 class="m-0">$${o.price}</h5>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </form>
                        </div>
                    </c:forEach>
                </div>                   
            </div>
        </div>
        <!-- Packages End -->


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