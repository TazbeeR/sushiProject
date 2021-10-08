<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<a href="/address/add">ADD</a><br />

<c:forEach items="${addresses}" var="address">
    <br/>
    --------------------------------
    <br/>
    ${address.city}<br/>
    ${address.postCode}<br/>
    ${address.street}<br/>
    ${address.number}<br/>
    <br/>
    <a href="update/${address.id}">Edytuj </a>
    <a href="delete/${address.id}">Usuń </a>
    <br/>
    --------------------------------
    <br/>
</c:forEach>