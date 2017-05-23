<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page contentType="text/html; charset=UTF-8"%>
<%@ include file="/WEB-INF/pages/layout/head.jsp"%>

<div class="jumbotron">
  <h1>Products List!</h1>
  
  ${page}
  ${size}
  ${orderBy}
  
  <table class="table">
    <tr>
        <th><a href="list?page=1&size=20&orderBy=ID">ID</a></th>
        <th><a href="list?page=1&size=20&orderBy=NAME">Name</a></th>
        <th><a href="list?page=1&size=20&orderBy=DESCRIPTION">Description</th>
        <th><a href="list?page=1&size=20&orderBy=QUANTITY">Quantity</th>
        <th><a href="list?page=1&size=20&orderBy=PRICE">Price</th>
        <th>Action</th>
    </tr>
    <c:forEach items="${productList}" var="product">
        <tr>
            <td>${product.id}</td>
            <td>${product.name}</td>
            <td>${product.description}</td>
			<td>${product.quantity}</td>
			<td>${product.price}</td>
			<td><a href="${product.id}/delete"> <i class=" glyphicon glyphicon-remove-circle"></i></td>
        </tr>
    </c:forEach>
</table>
</div>

<%@ include file="/WEB-INF/pages/layout/footer.jsp"%>

