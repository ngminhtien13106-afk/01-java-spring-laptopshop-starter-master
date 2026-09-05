<%@page contentType="text/html" pageEncoding="UTF-8" %>
  <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
      <!DOCTYPE html>
      <html lang="en">

      <head>
        <meta charset="utf-8" />
        <meta http-equiv="X-UA-Compatible" content="IE=edge" />
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no" />
        <meta name="description" content="Hỏi Dân IT - Dự án laptopshop" />
        <meta name="author" content="Hỏi Dân IT" />
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
                  <li class="breadcrumb-item active"><a href="/admin">Dashboard</a> / User / Create </li>
                </ol>
                <div class="container mt-5">
                  <div class="row">
                    <div class="col-md-6 col-12 mx-auto">
                      <h3>Create a user</h3>
                      <hr>
                      <!-- Khi người dùng submit form, hãy gửi dữ liệu đến URL /admin/user/create1. -->
                      <!--modelAttribute="newUser" nói với Spring:Form này sẽ làm việc với object có tên newUser trong Model. -->
                      <form:form action="/admin/user/createSuccess" enctype="multipart/form-data" method="post"
                        modelAttribute="newUser">
                        <div class="row">
                          <div class="mb-3 col">
                            <label for="exampleInputEmail1" class="form-label">Email address</label>
                            <form:input type="email" class="form-control" aria-describedby="emailHelp" path="email" />
                            <!-- path="email"Spring hiểu rằng: path="email" tương ứng với thuộc tính: newUser.email -->
                            <div class="form-text">We'll never share your email with anyone else.</div>
                          </div>
                          <div class="mb-3 col">
                            <label for="exampleInputPassword1" class="form-label">Password</label>
                            <form:input type="password" class="form-control" path="password" />
                          </div>
                        </div>
                        <div class="row">
                          <div class="mb-3 col">
                            <label for="exampleInputPassword1" class="form-label">Phone Number</label>
                            <form:input type="number" class="form-control" path="phone" />
                          </div>
                          <div class="mb-3 col">
                            <label for="exampleInputPassword1" class="form-label">Full Name</label>
                            <form:input type="text" class="form-control" path="fullname" />
                          </div>
                        </div>
                        <div class="mb-3">
                          <label for="exampleInputPassword1" class="form-label">Address</label>
                          <form:input type="text" class="form-control" path="address" />
                        </div>
                        <div class="row">
                          <div class="mb-3 col">
                            <label for="avatarFile" class="form-label">Avatar</label>
                            <input class="form-control" type="file" id="avatarFile" accept=".jpg , .png , .jpeg"
                              name="file" />

                          </div>
                          <div class="mb-3 col">
                            <label class="form-label">Role</label>
                            <form:select class="form-select" path="role.name">
                              <form:option value="ADMIN">ADMIN</form:option>
                              <form:option value="USER">USER</form:option>
                            </form:select>
                          </div>
                        </div>
                        <!-- display avatar -->
                        <div class="col-12 mb-3">
                          <img style="max-height: 250px; display:none ;" src="" alt="avatar preview" id="avatarPreview">
                        </div>

                        <a href="/admin/user" class="btn btn-success">Back</a>
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