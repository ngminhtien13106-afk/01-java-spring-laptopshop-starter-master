<%@page contentType="text/html" pageEncoding="UTF-8" %>
  <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
      <!DOCTYPE html>
      <html lang="en">

      <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Document</title>
        <!-- Tích hợp Bootstrap và JQuery -->
        <!-- Latest compiled and minified CSS -->
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet">
        <!-- Latest compiled JavaScript -->
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js"></script>
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>
        <link rel="stylesheet" href="/css/demo.css">
      </head>

      <body>
        <div class="container mt-5">
          <div class="row">
            <div class="col-md-6 col-12 mx-auto">
              <h3>Create a user</h3>
              <hr>
              <!-- Khi người dùng submit form, hãy gửi dữ liệu đến URL /admin/user/create1. -->
              <!--modelAttribute="newUser" nói với Spring:Form này sẽ làm việc với object có tên newUser trong Model. -->
              <form:form action="/admin/user/create1" method="post" modelAttribute="newUser">
                <div class="mb-3">
                  <label for="exampleInputEmail1" class="form-label">Email address</label>
                  <form:input type="email" class="form-control" aria-describedby="emailHelp" path="email" />
                  <!-- path="email"Spring hiểu rằng: path="email" tương ứng với thuộc tính: newUser.email -->
                  <div class="form-text">We'll never share your email with anyone else.</div>
                </div>
                <div class="mb-3">
                  <label for="exampleInputPassword1" class="form-label">Password</label>
                  <form:input type="password" class="form-control" path="password" />
                </div>
                <div class="mb-3">
                  <label for="exampleInputPassword1" class="form-label">Phone Number</label>
                  <form:input type="number" class="form-control" path="phone" />
                </div>
                <div class="mb-3">
                  <label for="exampleInputPassword1" class="form-label">Full Name</label>
                  <form:input type="text" class="form-control" path="fullname" />
                </div>
                <div class="mb-3">
                  <label for="exampleInputPassword1" class="form-label">Address</label>
                  <form:input type="text" class="form-control" path="address" />
                </div>

                <button type="submit" class="btn btn-primary">Create</button>

              </form:form>
            </div>
          </div>
          <div>

      </body>

      </html>