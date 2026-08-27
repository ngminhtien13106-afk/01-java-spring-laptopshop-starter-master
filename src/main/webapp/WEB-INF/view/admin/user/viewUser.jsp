<%@page contentType="text/html" pageEncoding="UTF-8" %>
  <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
      <!DOCTYPE html>
      <html lang="en">

      <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>View User ${userid}</title>
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
              <h3>View a user: ID ${userid}</h3>
              <hr>
              <form>

                <div class="mb-3">
                  <label for="exampleInputEmail1" class="form-label">Email address</label>
                  <p class="border p-1">${detailUser.email}</p>
                  <!-- path="email"Spring hiểu rằng: path="email" tương ứng với thuộc tính: newUser.email -->
                </div>
                <div class="mb-3">
                  <label for="exampleInputPassword1" class="form-label">Password</label>
                  <p class="border p-1">${detailUser.password}</p>
                </div>
                <div class="mb-3">
                  <label for="exampleInputPassword1" class="form-label">Phone Number</label>
                  <p class="border p-1">${detailUser.phone}</p>
                </div>
                <div class="mb-3">
                  <label for="exampleInputPassword1" class="form-label">Full Name</label>
                  <p class="border p-1">${detailUser.fullname}</p>
                </div>
                <div class="mb-3">
                  <label for="exampleInputPassword1" class="form-label">Address</label>
                  <p class="border p-1">${detailUser.address}</p>
                </div>

                <div>
                  <a href="/admin/user" class="btn btn-success">Back</a>
                </div>

              </form>

            </div>
          </div>
          <div>

      </body>

      </html>