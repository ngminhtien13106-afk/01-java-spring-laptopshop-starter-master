<%@page contentType="text/html" pageEncoding="UTF-8" %>
  <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
      <%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
        <!DOCTYPE html>
        <html lang="en">

        <head>
          <meta charset="UTF-8">
          <meta name="viewport" content="width=device-width, initial-scale=1.0">
          <title>Document</title>
          <!-- Google Web Fonts -->
          <link rel="preconnect" href="https://fonts.googleapis.com">
          <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
          <link href="https://fonts.googleapis.com/css2?family=Roboto:wght@400;500;600;700&display=swap"
            rel="stylesheet">

          <!-- Icon Font Stylesheet -->
          <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.15.4/css/all.css" />
          <link href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.4.1/font/bootstrap-icons.css" rel="stylesheet">

          <!-- Libraries Stylesheet -->
          <link href="client/lib/lightbox/css/lightbox.min.css" rel="stylesheet">
          <link href="client/lib/owlcarousel/assets/owl.carousel.min.css" rel="stylesheet">


          <!-- Customized Bootstrap Stylesheet -->
          <link href="client/css/bootstrap.min.css" rel="stylesheet">

          <!-- Template Stylesheet -->
          <link href="client/css/style.css" rel="stylesheet">

          <link rel="icon" type="image/x-icon" href="/favicon.ico">
        </head>

        <body>

          <!-- Spinner Start -->
          <div id="spinner"
            class="show w-100 vh-100 bg-white position-fixed translate-middle top-50 start-50  d-flex align-items-center justify-content-center">
            <div class="spinner-grow text-primary" role="status"></div>
          </div>
          <!-- Spinner End -->

          <!-- header -->
          <jsp:include page="../layout/header.jsp" />



          <!-- Banner -->
          <jsp:include page="../layout/banner.jsp" />





          <!-- Fruits Shop Start-->
          <div class="container-fluid fruite py-5">
            <div class="container py-5">
              <div class="tab-class text-center">
                <div class="row g-4">
                  <div class="col-lg-4 text-start">
                    <h1>Featured Products</h1>
                  </div>
                  <div class="col-lg-8 text-end">
                    <ul class="nav nav-pills d-inline-flex text-center mb-5">
                      <li class="nav-item">
                        <a class="d-flex m-2 py-2 bg-light rounded-pill active" data-bs-toggle="pill" href="#tab-1">
                          <span class="text-dark" style="width: 130px;">All Products</span>
                        </a>
                      </li>

                    </ul>
                  </div>
                </div>
                <div class="tab-content">
                  <div id="tab-1" class="tab-pane fade show p-0 active">
                    <div class="row g-4">
                      <div class="col-lg-12">
                        <div class="row g-4">
                          <c:forEach var="product" items="${ListProduct}">
                            <div class="col-md-6 col-lg-4 col-xl-3 ">
                              <div class="rounded position-relative fruite-item ">

                                <div class="fruite-img">
                                  <img src="/images/product/${product.image}" class="img-fluid w-100 rounded-top">
                                </div>
                                <div class="text-white bg-secondary px-3 py-1 rounded position-absolute"
                                  style="top: 10px; left: 10px;">New
                                </div>
                                <div class="p-4 border border-secondary border-top-0 rounded-bottom">
                                  <h4 style="font-size: 15px;"> <a href="/product/${product.id}">${product.name}</a>
                                  </h4>
                                  <p style="font-size: 13px;">${product.shortDesc}</p>
                                  <div class="d-flex  flex-lg-wrap">
                                    <p style="font-size: 15px; text-align: center; width: 100%;"
                                      class="text-dark fw-bold mb-3">
                                      <fmt:formatNumber type="Number" value="${product.price}" />đ
                                    </p>
                                    <a href="/product/${product.id}"
                                      class=" mx-auto border border-secondary rounded-pill px-3 text-primary "><i
                                        class="fa fa-shopping-bag me-2 text-primary "></i>
                                      Add to cart</a>
                                  </div>
                                </div>

                              </div>

                            </div>
                          </c:forEach>
                        </div>
                      </div>
                    </div>
                  </div>

                </div>
              </div>
            </div>
          </div>
          <!-- Fruits Shop End-->



          <jsp:include page="../layout/feature.jsp" />

          <!-- Bestsaler Product Start -->
          <div class="container-fluid py-5">
            <div class="container py-5">
              <div class="text-center mx-auto mb-5" style="max-width: 700px;">
                <h1 class="display-4">Bestseller Products</h1>
                <p>Latin words, combined with a handful of model sentence structures, to generate Lorem Ipsum which
                  looks
                  reasonable.</p>
              </div>
              <div class="row g-4">
                <c:forEach var="randomproduct" items="${randomProducts}">
                  <div class="col-lg-6 col-xl-4">
                    <div class="p-4 rounded bg-light">
                      <div class="row align-items-center" style="height: 160px;">
                        <div class="col-6">
                          <img src="images/product/${randomproduct.image}" class="img-fluid  w-100" alt="">
                        </div>
                        <div class="col-6">
                          <a href="/product/${randomproduct.id}" class="h5">${randomproduct.name}</a>
                          <div class="d-flex my-3">
                            <i class="fas fa-star text-primary"></i>
                            <i class="fas fa-star text-primary"></i>
                            <i class="fas fa-star text-primary"></i>
                            <i class="fas fa-star text-primary"></i>
                            <i class="fas fa-star "></i>
                          </div>
                          <h4 class="mb-3">
                            <fmt:formatNumber type="Number" value="${randomproduct.price}" />đ
                          </h4>
                          <a href="/product/${randomproduct.id}"
                            class="btn border border-secondary rounded-pill px-3 text-primary"><i
                              class="fa fa-shopping-bag me-2 text-primary"></i> Add to cart</a>
                        </div>
                      </div>
                    </div>
                  </div>
                </c:forEach>

              </div>
            </div>
          </div>
          <!-- Bestsaler Product End -->

          <!-- footer -->
          <jsp:include page="../layout/footer.jsp" />



          <!-- JavaScript Libraries -->
          <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.4/jquery.min.js"></script>
          <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0/dist/js/bootstrap.bundle.min.js"></script>
          <script src="client/lib/easing/easing.min.js"></script>
          <script src="client/lib/waypoints/waypoints.min.js"></script>
          <script src="client/lib/lightbox/js/lightbox.min.js"></script>
          <script src="client/lib/owlcarousel/owl.carousel.min.js"></script>

          <!-- Template Javascript -->
          <script src="client/js/main.js"></script>

        </body>

        </html>