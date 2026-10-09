<%@page contentType="text/html" pageEncoding="UTF-8" %>
  <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
      <%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
        <!DOCTYPE html>
        <html lang="en">

        <head>
          <meta charset="utf-8" />
          <meta http-equiv="X-UA-Compatible" content="IE=edge" />
          <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no" />
          <meta name="description" content=" Dự án laptopshop" />
          <meta name="author" content="TMind" />
          <title>Dashboard - Product</title>

          <link href="/css/styles.css" rel="stylesheet" />
          <script src="https://use.fontawesome.com/releases/v6.3.0/js/all.js" crossorigin="anonymous"></script>

        </head>

        <body class="sb-nav-fixed">
          <jsp:include page="../layout/header.jsp" />
          <div id="layoutSidenav">
            <jsp:include page="../layout/sidebar.jsp" />
            <div id="layoutSidenav_content">
              <main>
                <div class="container-fluid px-4">
                  <h1 class="mt-4">Dashboard</h1>
                  <ol class="breadcrumb mb-4">
                    <li class="breadcrumb-item active"><a href="/admin">Dashboard</a> / Product </li>
                  </ol>

                  <div class="container mt-5">
                    <div class="row">
                      <div class="col-12 mx-auto">
                        <div class="d-flex justify-content-around mb-3">
                          <h3>Table Product</h3>
                          <a href="/admin/product/createPage" class="btn btn-primary">Create</a>
                        </div>
                        <hr>
                        <table class="table table-bordered table-hover">
                          <thead>
                            <tr>
                              <th scope="col">Product</th>
                              <th scope="col">Name</th>
                              <th scope="col">Price</th>
                              <th scope="col">Quantity</th>

                            </tr>
                          </thead>
                          <tbody>
                            <c:forEach var="order_details" items="${order_details}">
                              <tr>
                                <td>
                                  <div class="col-12 ">
                                    <img style="width: 100px ; height: 70px;"
                                      src="/images/product/${order_details.product.image}" alt="avatar preview"
                                      id="avatarPreview">
                                  </div>
                                </td>
                                <td>
                                  ${order_details.product.name}
                                </td>
                                <td>
                                  <fmt:formatNumber type="Number" value="${order_details.price}" />đ
                                </td>
                                <td>
                                  ${order_details.quantity}
                                </td>
                              </tr>
                            </c:forEach>
                          </tbody>
                        </table>
                      </div>
                    </div>
                    <a href="/admin/order" class="btn btn-success mb-3">Back</a>
                  </div>
                </div>
              </main>
              <jsp:include page="../layout/footer.jsp" />
            </div>
          </div>
          <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js"
            crossorigin="anonymous"></script>
          <script src="/js/scripts.js"></script>

        </body>

        </html>