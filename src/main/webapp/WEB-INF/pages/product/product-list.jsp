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
  <h1><spring:message code="product.list.title"/>!</h1>
  </br>
  <a href="new" class="btn btn-primary "> <i
		class=" glyphicon glyphicon-plus"></i> <spring:message code="product.list.addNew"/></a>
		
<div class="col-xs-4 pull-right">
<form method="get">
		<div class="input-group">
			<input type="text" name="query" class="form-control searcher"
				placeholder="Search..." value="${param.query}"> <span class="input-group-btn">
				<button class="btn btn-default" type="button">
					<i class="glyphicon glyphicon-send" style="height:20px"></i>
				</button>
			</span>
		</div>
		</form>
	</div>
  
<%--   ${page}
  ${size}
  ${orderBy} --%>
  
  <table class="table  table-hover table-stripe">
  <thead>
    <tr>
        <th>ID 
        <a href="list?orderBy=ID"> <i class="glyphicon glyphicon-sort-by-order"></i>
        <a href="list?orderBy=ID&order=DESC"> <i class="glyphicon glyphicon-sort-by-order-alt"></i>
        </th>
        <th><spring:message code="product.name"/> 
        <a href="list?orderBy=NAME"> <i class="glyphicon glyphicon-sort-by-alphabet"></i>
        <a href="list?orderBy=NAME&order=DESC"> <i class="glyphicon glyphicon-sort-by-alphabet-alt"></i>
        </th>
        <th><spring:message code="product.description"/>  
        <a href="list?orderBy=DESCRIPTION"> <i class="glyphicon glyphicon-sort-by-alphabet"></i>
        <a href="list?orderBy=DESCRIPTION&order=DESC"> <i class="glyphicon glyphicon-sort-by-alphabet-alt"></i>
        </th>
        <th><spring:message code="product.quantity"/>  
        <a href="list?orderBy=QUANTITY"> <i class="glyphicon glyphicon-sort-by-order"></i>
        <a href="list?orderBy=QUANTITY&order=DESC"> <i class="glyphicon glyphicon-sort-by-order-alt"></i>
        </th>
        <th><spring:message code="product.price"/>  
        <a href="list?orderBy=PRICE"> <i class="glyphicon glyphicon-sort-by-order"></i>
        <a href="list?orderBy=PRICE&order=DESC"> <i class="glyphicon glyphicon-sort-by-order-alt"></i>
        </th>
        <th><spring:message code="product.list.action"/> </th>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${productList}" var="product">
        <tr>
            <td>${product.id}</td>
            <td>${product.name}</td>
            <td>${product.description}</td>
			<td>${product.quantity}</td>
			<td>${product.price}</td>
			<td><a href="${product.id}/delete"> <i class=" glyphicon glyphicon-remove-circle"></i>
			<a href="${product.id}/edit"> <i class=" glyphicon glyphicon-pencil"></i>
			</td>
        </tr>
    </c:forEach>
     <form:form method="POST" modelAttribute="newProduct" action="${contextPath}/product/save2">
    	<tr>
            <td><spring:message code="product.list.addFast"/></td>
            <td><form:input path="name" class="form-control"/></td>
            <td><form:input path="description" class="form-control"/></td>
			<td><form:input path="quantity" class="form-control"/></td>
			<td><form:input path="price" class="form-control"/></td>
			<td><button type="submit" class="btn btn-primary pull-right">
		<i class=" glyphicon glyphicon-ok"></i> <spring:message code="product.list.save"/>
	</button></td>
        </tr>
    </form:form>
    </tbody>
</table>



<%-- 	<form:form modelAttribute="product">
		Name: <form:input path="product.name"/>
		<input type="submit" value="Send" />
	</form:form> --%>
<%-- 	
	<form:form method="POST" action="/spring-mvc-xml/addEmployee" modelAttribute="product">
             <table>
                <tr>
                    <td><form:label path="name">Name</form:label></td>
                    <td><form:input path="name"/></td>
                </tr>
                <tr>
                    <td><form:label path="id">Id</form:label></td>
                    <td><form:input path="id"/></td>
                </tr>
                <tr>
                    <td><form:label path="contactNumber">Contact Number</form:label></td>
                    <td><form:input path="contactNumber"/></td>
                </tr>
                <tr>
                    <td><input type="submit" value="Submit"/></td>
                </tr>
            </table>
        </form:form> --%>

</div>

<%@ include file="/WEB-INF/pages/layout/footer.jsp"%>

