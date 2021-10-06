<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<a href="/product/add">ADD</a><br />

<c:forEach items="${products}" var="product">
    <br/>
    --------------------------------
    <br/>
    ${product.name}<br/>
    ${product.description}<br/>
    ${product.price}<br/>
    <br/>
    <a href="update/${product.id}">Edytuj </a>
    <a href="delete/${product.id}">Usuń </a>
    <br/>
    --------------------------------
    <br/>
</c:forEach>