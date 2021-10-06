<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<h2>Dodanie nowej dostawy</h2>

<form:form method="post" modelAttribute="delivery">
    <form:hidden path="id"/>
    Name:
    <form:input  path="type"/>
    <form:errors path="type"/>
    Price:
    <form:input  path="price"/>
    <form:errors path="price"/>

    <input type="submit"/>

</form:form>