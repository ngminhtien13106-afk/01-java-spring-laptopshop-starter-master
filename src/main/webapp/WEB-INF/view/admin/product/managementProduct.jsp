<%@page contentType="text/html" pageEncoding="UTF-8" %>
  <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
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
        <c:if test="${param.error == 'true'}">
          <script>
            alert("Create failed! Vui lòng nhập đầy đủ thông tin.");
          </script>
        </c:if>
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
                            <th scope="col">ID</th>
                            <th scope="col">NAME</th>
                            <th scope="col">PRICE</th>
                            <th scope="col">FACTORY</th>
                            <th scope="col">Action</th>

                          </tr>
                        </thead>
                        <tbody>
                          <c:forEach var="product" items="${products}">
                            <tr>
                              <td>${product.id}</td>
                              <td>${product.name}</td>
                              <td>${product.price}</td>
                              <td>${product.target}</td>
                              <td>
                                <a href="/admin/user/view/${user.id}" class="btn btn-success">View</a>
                                <a href="/admin/user/updata/${user.id}" class="btn btn-warning">Updata</a>
                                <a href="/admin/user/delete/${user.id}" class="btn btn-danger">Delete</a>
                              </td>
                            </tr>
                          </c:forEach>
                        </tbody>
                      </table>
                    </div>
                  </div>
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