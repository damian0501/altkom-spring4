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
  
  <table>
    <tr>
        <th>ID</th>
        <th>Name</th>
        <th>Description</th>
        <th>Quantity</th>
        <th>Price</th>
    </tr>
    <c:forEach items="${productList}" var="product">
        <tr>
            <td>${product.id}</td>
            <td>${product.name}</td>
            <td>${product.description}</td>
			<td>${product.quantity}</td>
			<td>${product.price}</td>
        </tr>
    </c:forEach>
</table>
</div>

<%@ include file="/WEB-INF/pages/layout/footer.jsp"%>

