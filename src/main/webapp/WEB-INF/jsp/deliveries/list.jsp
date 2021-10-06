<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<a href="/delivery/add">ADD</a><br />

<c:forEach items="${deliveries}" var="delivery">
    <br/>
    --------------------------------
    <br/>
    ${delivery.type}<br/>
    ${delivery.price}<br/>
    <br/>
    <a href="update/${delivery.id}">Edytuj </a>
    <a href="delete/${delivery.id}">Usuń </a>
    <br/>
    --------------------------------
    <br/>
</c:forEach>