<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false"%>

     <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<!DOCTYPE html>
<html>
<head>
  <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.2.1/css/bootstrap.min.css" integrity="sha384-GJzZqFGwb1QTTN6wy59ffF1BuGJpLSa9DkKMp0DgiMDm4iYMj70gZWKYbI706tWS" crossorigin="anonymous">
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
    <title>SpringMVC-Product CRUD</title>

</head>
<body>


    <div class="container">


            <div class="jumbotron text-center mt-5">
                <h2>Product  APP</h2>
            </div>
            <h4 style="color:green">${msg}</h4>
            <form method="post" action="/addProduct">
          			 <div class="form-group">
                        <label for="exampleInputPassword1">ID</label>
                        <input type="number" class="form-control" placeholder="ID" name="productId">
                    </div>
                    <div class="form-group">
                        <label for="exampleInputPassword1">Name</label>
                        <input type="text" class="form-control" placeholder="Name" name="productName">
                    </div>
                    <div class="form-group">
                      <label for="exampleInputPassword1">Price</label>
                      <input type="number" class="form-control"  placeholder="Price" name="productPrice">
                    </div>

                    <button type="submit" class="btn btn-primary">Submit</button>
                  </form>
<div>
<h2>List of Product Details</h2>
<table class="table table-dark">
  <thead>
    <tr>
    <th scope="col">Product Id</th>
      <th scope="col">Product Name</th>
      <th scope="col">Product Price</th>
    </tr>
  </thead>
  <tbody>
	<c:forEach items="${products}" var="product">
		<tr>
			<td>${product.productId}</td>
			<td>${product.productName}</td>
			<td>${product.productPrice}</td>
			<td><a href="/deleteProduct?id=${product.productId}">Delete</a></td>
		</tr>
	</c:forEach>
  </tbody>
</table>


</div>
</html>
