<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<h2>Dodanie nowego produktu</h2>

<form:form method="post" modelAttribute="product">
    <form:hidden path="id"/>
    Name:
    <form:input  path="name"/>
    <form:errors path="name"/>
    Description:
    <form:input  path="description"/>
    <form:errors path="description"/>
    Ilość:
    <form:input path="quantity"/>
    <form:errors path="quantity"/>
    Price:
    <form:input  path="price"/>
    <form:errors path="price"/>

    <input type="submit"/>

</form:form>