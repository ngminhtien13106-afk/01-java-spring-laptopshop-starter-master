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
        <title>Dashboard - Create </title>

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
        <script>
          $(document).ready(() => {
            const avatarFile = $("#avatarFile");
            avatarFile.change(function (e) {
              const imgURL = URL.createObjectURL(e.target.files[0]);
              $("#avatarPreview").attr("src", imgURL);
              $("#avatarPreview").css({ "display": "block" });
            });
          }); 
        </script>
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
                  <li class="breadcrumb-item active"><a href="/admin">Dashboard</a> / Product / Create </li>
                </ol>
                <div class=" mt-5">
                  <div class="row">
                    <div class="col-md-6 col-12 mx-auto">
                      <h3>Create a product</h3>
                      <hr>

                      <form:form action="/admin/product/createSuccess" enctype="multipart/form-data" method="post"
                        modelAttribute="newProduct">
                        <div class="row">
                          <div class="mb-3 col">
                            <label class="form-label">Name: </label>
                            <form:input type="text" class="form-control" path="name" />
                          </div>
                          <div class="mb-3 col">
                            <label class="form-label">Price: </label>
                            <form:input type="text" class="form-control" path="price" />
                          </div>
                        </div>
                        <div class="mb-3">
                          <label class="form-label">Detail description: </label>
                          <form:textarea class="form-control" placeholder="Enter product details via the keyboard."
                            id="floatingTextarea2" style="height: 100px" path="detailDesc" />
                        </div>

                        <div class="row">
                          <div class="mb-3 col">
                            <label class="form-label">Short description: </label>
                            <form:input type="text" class="form-control" path="shortDesc" />
                          </div>

                          <div class="mb-3 col">
                            <label class="form-label">Quantity: </label>
                            <form:input type="number" class="form-control" path="quantity" />
                          </div>
                        </div>

                        <div class="row">
                          <div class="mb-3 col">
                            <label class="form-label">Factory</label>
                            <form:select class="form-select" path="factory">
                              <form:option value="" label="-- Chọn hãng laptop --" />
                              <form:option value="Dell" label="Dell" />
                              <form:option value="HP" label="HP" />
                              <form:option value="Lenovo" label="Lenovo" />
                              <form:option value="ASUS" label="ASUS" />
                              <form:option value="Acer" label="Acer" />
                              <form:option value="MSI" label="MSI" />
                              <form:option value="Apple" label="Apple" />
                              <form:option value="Samsung" label="Samsung" />
                              <form:option value="LG" label="LG" />
                              <form:option value="Microsoft" label="Microsoft" />
                            </form:select>
                          </div>

                          <div class="mb-3 col">
                            <label for="exampleInputPassword1" class="form-label">Target</label>
                            <form:select path="target" class="form-select">
                              <form:option value="" label="-- Chọn nhu cầu sử dụng --" />
                              <form:option value="Gaming" label="Chơi game" />
                              <form:option value="Study" label="Học tập" />
                              <form:option value="Programming" label="Lập trình" />
                              <form:option value="Office" label="Văn phòng" />
                              <form:option value="Graphic Design" label="Đồ họa" />
                              <form:option value="Video Editing" label="Dựng video" />
                              <form:option value="Business" label="Doanh nhân / Công việc" />
                            </form:select>
                          </div>
                        </div>

                        <div class="mb-3 col">
                          <label for="avatarFile" class="form-label">Image Product: </label>
                          <input class="form-control" type="file" id="avatarFile" name="file" />
                        </div>
                        <div class="col-12 mb-3">
                          <img style="max-height: 250px; display:none ;" src="" alt="avatar preview" id="avatarPreview">
                        </div>

                        <a href="/admin/product" class="btn btn-success">Back</a>
                        <button type="submit" class="btn btn-on-click-c btn-primary">Create</button>

                      </form:form>
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