<%@page contentType="text/html" pageEncoding="UTF-8" %>
  <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
      <%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
        <!DOCTYPE html>
        <html lang="en">

        <head>
          <meta charset="utf-8">
          <title>Fruitables - Vegetable Website Template</title>
          <meta content="width=device-width, initial-scale=1.0" name="viewport">
          <meta content="" name="keywords">
          <meta content="" name="description">

          <!-- Google Web Fonts -->
          <link rel="preconnect" href="https://fonts.googleapis.com">
          <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
          <link href="https://fonts.googleapis.com/css2?family=Roboto:wght@400;500;600;700&display=swap"
            rel="stylesheet">

          <!-- Icon Font Stylesheet -->
          <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.15.4/css/all.css" />
          <link href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.4.1/font/bootstrap-icons.css" rel="stylesheet">

          <!-- Libraries Stylesheet -->
          <link href="../client/lib/lightbox/css/lightbox.min.css" rel="stylesheet">
          <link href="../client/lib/owlcarousel/assets/owl.carousel.min.css" rel="stylesheet">


          <!-- Customized Bootstrap Stylesheet -->
          <link href="../client/css/bootstrap.min.css" rel="stylesheet">

          <!-- Template Stylesheet -->
          <link href="../client/css/style.css" rel="stylesheet">
        </head>

        <body>

          <!-- Spinner Start -->
          <div id="spinner"
            class="show w-100 vh-100 bg-white position-fixed translate-middle top-50 start-50  d-flex align-items-center justify-content-center">
            <div class="spinner-grow text-primary" role="status"></div>
          </div>
          <!-- Spinner End -->


          <jsp:include page="../layout/header.jsp" />





          <!-- Single Product Start -->

          <div class="container-fluid py-5 mt-5">
            <div class="container py-3 mt-5">
              <div class="tab-class ">

                <div class="row g-4">

                  <!-- FILTER -->
                  <div class="col-12 col-md-4 col-lg-3">
                    <div class="row g-3">

                      <div class="col-12">
                        <h5 class="mb-4">Bộ lọc sản phẩm</h5>

                        <p class="mb-1 fw-bold">Hãng Sản Xuất</p>
                        <form action="/product" method="post" id="checkoutForm">
                          <div class="d-flex flex-wrap">
                            <div class="form-check " style="margin: 0 10px 2px  0;">

                              <input class="form-check-input" type="checkbox" name="name" value="" id="factoryDell">

                              <label class="form-check-label" for="factoryDell">
                                Chọn tất cả
                              </label>

                            </div>
                            <div class="form-check " style="margin: 0 10px 2px  0;">

                              <input class="form-check-input" type="checkbox" name="factory" value="Dell"
                                id="factoryDell">

                              <label class="form-check-label" for="factoryDell">
                                Dell
                              </label>

                            </div>

                            <div class="form-check mb-2  style=" style="margin: 0 10px 2px 0;">
                              <input class="form-check-input" type="checkbox" name="factory" value="HP" id="factoryHP">
                              <label class="form-check-label" for="factoryHP">
                                HP
                              </label>
                            </div>

                            <div class="form-check mb-2  style=" style="margin: 0 10px 2px 0;">
                              <input class="form-check-input" type="checkbox" name="factory" value="Lenovo"
                                id="factoryLenovo">
                              <label class="form-check-label" for="factoryLenovo">
                                Lenovo
                              </label>
                            </div>

                            <div class="form-check mb-2 style=" style="margin: 0 10px 2px 0;">
                              <input class="form-check-input" type="checkbox" name="factory" value="ASUS"
                                id="factoryASUS">
                              <label class="form-check-label" for="factoryASUS">
                                ASUS
                              </label>
                            </div>

                            <div class="form-check mb-2 style=" style="margin: 0 10px 2px 0;">
                              <input class="form-check-input" type="checkbox" name="factory" value="Acer"
                                id="factoryAcer">
                              <label class="form-check-label" for="factoryAcer">
                                Acer
                              </label>
                            </div>

                            <div class="form-check mb-2 style=" style="margin: 0 10px 2px 0;">
                              <input class="form-check-input" type="checkbox" name="factory" value="MSI"
                                id="factoryMSI">
                              <label class="form-check-label" for="factoryMSI">
                                MSI
                              </label>
                            </div>

                            <div class="form-check mb-2 style=" style="margin: 0 10px 2px 0;">
                              <input class="form-check-input" type="checkbox" name="factory" value="Apple"
                                id="factoryApple">
                              <label class="form-check-label" for="factoryApple">
                                Apple
                              </label>
                            </div>

                            <div class="form-check mb-2 style=" style="margin: 0 10px 2px 0;">
                              <input class="form-check-input" type="checkbox" name="factory" value="Samsung"
                                id="factorySamsung">
                              <label class="form-check-label" for="factorySamsung">
                                Samsung
                              </label>
                            </div>

                            <div class="form-check mb-2 style=" style="margin: 0 10px 2px 0;">
                              <input class="form-check-input" type="checkbox" name="factory" value="LG" id="factoryLG">
                              <label class="form-check-label" for="factoryLG">
                                LG
                              </label>
                            </div>

                            <div class="form-check mb-2 style=" style="margin: 0 10px 2px 0;">
                              <input class="form-check-input" type="checkbox" name="factory" value="Microsoft"
                                id="factoryMicrosoft">
                              <label class="form-check-label" for="factoryMicrosoft">
                                Microsoft
                              </label>
                            </div>
                          </div>



                          <p class="mb-1 fw-bold">Mục Đích Sử Dụng</p>
                          <div>
                            <div class="form-check mb-2">
                              <input class="form-check-input" type="checkbox" value="Gaming" id="targetGaming">
                              <label class="form-check-label" for="targetGaming">
                                Chơi game
                              </label>
                            </div>

                            <div class="form-check mb-2">
                              <input class="form-check-input" type="checkbox" value="Study" id="targetStudy">
                              <label class="form-check-label" for="targetStudy">
                                Học tập
                              </label>
                            </div>

                            <div class="form-check mb-2">
                              <input class="form-check-input" type="checkbox" value="Programming"
                                id="targetProgramming">
                              <label class="form-check-label" for="targetProgramming">
                                Lập trình
                              </label>
                            </div>

                            <div class="form-check mb-2">
                              <input class="form-check-input" type="checkbox" value="Office" id="targetOffice">
                              <label class="form-check-label" for="targetOffice">
                                Văn phòng
                              </label>
                            </div>

                            <div class="form-check mb-2">
                              <input class="form-check-input" type="checkbox" value="Graphic Design"
                                id="targetGraphicDesign">
                              <label class="form-check-label" for="targetGraphicDesign">
                                Đồ họa
                              </label>
                            </div>

                            <div class="form-check mb-2">
                              <input class="form-check-input" type="checkbox" value="Video Editing"
                                id="targetVideoEditing">
                              <label class="form-check-label" for="targetVideoEditing">
                                Dựng video
                              </label>
                            </div>

                            <div class="form-check mb-2">
                              <input class="form-check-input" type="checkbox" value="Business" id="targetBusiness">
                              <label class="form-check-label" for="targetBusiness">
                                Doanh nhân / Công việc
                              </label>
                            </div>
                          </div>

                          <p class="mb-1 fw-bold">Mức Giá</p>
                          <div class="d-flex flex-wrap">
                            <div class="form-check " style="margin: 0 10px 2px  0;">
                              <input class="form-check-input" type="checkbox" name="priceMin" value="10000000"
                                id="factoryDell">
                              <label class="form-check-label" for="factoryDell">
                                Dưới 10 triệu
                              </label>
                            </div>

                            <div class="form-check mb-2  style=" style="margin: 0 10px 2px 0;">
                              <input class="form-check-input" type="checkbox" name="price" value="Tu10-15"
                                id="factoryHP">
                              <label class="form-check-label" for="factoryHP">
                                Từ 10 - 15 triệu
                              </label>
                            </div>

                            <div class="form-check mb-2  style=" style="margin: 0 10px 2px 0;">
                              <input class="form-check-input" type="checkbox" name="price" value="Tu15-20">
                              <label class="form-check-label" for="factoryLenovo">
                                Từ 15 - 20 triệu
                              </label>
                            </div>

                            <div class="form-check mb-2 style=" style="margin: 0 10px 2px 0;">
                              <input class="form-check-input" type="checkbox" name="price" value="Tu20-25"
                                id="factoryASUS">
                              <label class="form-check-label" for="factoryASUS">
                                Từ 20 - 25 triệu
                              </label>
                            </div>
                          </div>
                          <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />

                          <button
                            class="btn border-secondary rounded-pill px-4 py-3 text-primary text-uppercase mb-4 ms-4 btnToCheckout"
                            type="submit">
                            Lọc sản phẩm
                          </button>
                        </form>

                        <p class="mb-1 fw-bold">Sắp xếp</p>
                        <div>
                          <div class="form-check">
                            <input class="form-check-input" type="radio" name="flexRadioDefault" id="flexRadioDefault1">
                            <label class="form-check-label" for="flexRadioDefault1">
                              Tăng dần
                            </label>
                          </div>
                          <div class="form-check">
                            <input class="form-check-input" type="radio" name="flexRadioDefault" id="flexRadioDefault2"
                              checked>
                            <label class="form-check-label" for="flexRadioDefault2">
                              Giảm dần
                            </label>
                          </div>
                          <div class="form-check">
                            <input class="form-check-input" type="radio" name="flexRadioDefault" id="flexRadioDefault2"
                              checked>
                            <label class="form-check-label" for="flexRadioDefault2">
                              Không xắp xếp
                            </label>
                          </div>
                        </div>



                      </div>

                    </div>
                  </div>

                  <!-- PRODUCT LIST -->
                  <div class="col-12 col-md-8 col-lg-9">
                    <div class="row row-cols-1 row-cols-sm-2 row-cols-xl-3 g-4">
                      <c:if test="${ not empty ListProduct}">
                        <c:forEach var="product" items="${ListProduct}">
                          <div class="col">
                            <div class="rounded position-relative fruite-item h-100">

                              <div class="fruite-img">
                                <img src="/images/product/${product.image}" class="img-fluid w-100 rounded-top"
                                  style="height: 200px;" alt="${product.name}">
                              </div>

                              <div class="text-white bg-secondary px-3 py-1 rounded position-absolute"
                                style="top: 10px; left: 10px;">
                                New
                              </div>

                              <div class="p-4 border border-secondary border-top-0 rounded-bottom">

                                <h4 class="mb-2" style="font-size: 15px;">
                                  <a href="/product/${product.id}">
                                    ${product.name}
                                  </a>
                                </h4>

                                <p class="mb-3" style="font-size: 13px;">
                                  ${product.shortDesc}
                                </p>

                                <div class="d-flex flex-column align-items-center">
                                  <p class="text-dark fw-bold mb-3" style="font-size: 15px;">
                                    <fmt:formatNumber type="number" value="${product.price}" />đ
                                  </p>

                                  <form action="/product/addAllProductToCart/${product.id}" method="post"
                                    class="w-100 text-center">

                                    <input type="hidden" name="quantities" value="1">

                                    <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">

                                    <button type="submit" class="btn btn-primary w-100">
                                      Add Cart Product
                                    </button>
                                  </form>
                                </div>

                              </div>
                            </div>
                          </div>
                        </c:forEach>

                    </div>

                    <!-- PAGINATION -->
                    <nav aria-label="Page navigation example  ">
                      <ul class="pagination justify-content-center d-flex mt-5">
                        <li class="page-item">
                          <c:choose>
                            <c:when test="${currentPage == 1}">
                              <a class="page-link disabled" aria-disabled="true" tabindex="-1">&laquo;</a>
                            </c:when>
                            <c:otherwise>
                              <a class="page-link" href="/product?page=${currentPage - 1}">&laquo;</a>
                            </c:otherwise>
                          </c:choose>
                        </li>
                        <c:forEach begin="0" end="${totalPage - 1}" varStatus="loop">

                          <li class="page-item"><a
                              class="${(loop.index + 1) eq  currentPage ? 'page-link active' : 'page-link'}"
                              href="/product?page=${loop.index + 1}">${loop.index + 1}</a>
                          </li>
                        </c:forEach>

                        <li class="page-item">
                          <c:choose>
                            <c:when test="${currentPage == totalPage}">
                              <a class="page-link disabled" aria-disabled="true" tabindex="-1">&raquo;</a>
                            </c:when>
                            <c:otherwise>
                              <a class="page-link" href="/product?page=${currentPage + 1}">&raquo;</a>
                            </c:otherwise>
                          </c:choose>
                        </li>
                      </ul>
                    </nav>
                    </c:if>

                  </div>
                  <c:if test="${ empty ListProduct}">
                    <h1 class="mt-5">Danh sách trống</h1>
                  </c:if>
                </div>
              </div>
            </div>
          </div>



          <!-- Single Product End -->


          <jsp:include page="../layout/footer.jsp" />


          <!-- JavaScript Libraries -->
          <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.4/jquery.min.js"></script>
          <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0/dist/js/bootstrap.bundle.min.js"></script>
          <script src="../client/lib/easing/easing.min.js"></script>
          <script src="../client/lib/waypoints/waypoints.min.js"></script>
          <script src="../client/lib/lightbox/js/lightbox.min.js"></script>
          <script src="../client/lib/owlcarousel/owl.carousel.min.js"></script>

          <!-- Template Javascript -->
          <script src="../client/js/main.js"></script>

        </body>

        </html>