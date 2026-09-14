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
        <meta name="author" content=" IT" />
        <title>Dashboard - View </title>

        <link href="/css/styles.css" rel="stylesheet" />
        <script src="https://use.fontawesome.com/releases/v6.3.0/js/all.js" crossorigin="anonymous"></script>
        <!-- new copy -->

        <!-- Tích hợp Bootstrap và JQuery -->
        <!-- Latest compiled and minified CSS -->
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet">
        <!-- Latest compiled JavaScript -->
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js"></script>
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>
        <!-- <link rel="stylesheet" href="/css/demo.css"> -->
        <!-- open avatar -->
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>
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
                  <li class="breadcrumb-item active"><a href="/admin">Dashboard</a> / Product / View </li>
                </ol>
                <div class=" mt-5">
                  <div class="row">
                    <div class="col-md-6 col-12 mx-auto">
                      <h3>View a product ID: ${productid}</h3>
                      <hr>

                        <div class="row">
                          <div class="mb-3 col">
                            <label class="form-label">Name: </label>
                            <p class="border rounded-1 p-1">${newProduct.name}</p>
                          </div>
                          <div class="mb-3 col">
                            <label class="form-label">Price: </label>
                            <p class="border rounded-1 p-1">${newProduct.price}</p>
                          </div>
                        </div>
                        <div class="mb-3">
                          <label class="form-label">Detail description: </label>
                                <p class="border rounded-1 p-1">${newProduct.detailDesc}</p>
                        </div>

                        <div class="row">
                          <div class="mb-3 col">
                            <label class="form-label">Short description: </label>
                                   <p class="border rounded-1 p-1">${newProduct.shortDesc}</p>
                          </div>

                          <div class="mb-3 col">
                            <label class="form-label">Quantity: </label>
                                <p class="border rounded-1 p-1">${newProduct.quantity}</p>
                          </div>
                        </div>

                        <div class="row">
                          <div class="mb-3 col">
                            <label class="form-label">Factory</label>
                                   <p class="border rounded-1 p-1">${newProduct.factory}</p>
                          </div>

                          <div class="mb-3 col">
                            <label for="exampleInputPassword1" class="form-label">Target</label>
                                  <p class="border rounded-1 p-1">${newProduct.target}</p>
                          </div>
                        </div>

                        <div class="mb-3 col">
                          <label for="avatarFile" class="form-label">Image Product: </label>
                
                        <div class="col-12 mb-3">
                          <img style="max-height: 250px;" src="/images/product/${newProduct.image}" alt="avatar preview" id="avatarPreview">
                        </div>
                        </div>

                        <a href="/admin/product" class="btn btn-success mb-3">Back</a>
                       

                  
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
        <script src="/js/main.js"></script>

      </body>

      </html>