<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<h2>Dodanie nowej dostawy</h2>

<form:form method="post" modelAttribute="address">
    <form:hidden path="id"/>
    Miasto:
    <form:input  path="city"/>
    <form:errors path="city"/>
    Kod pocztowy:
    <form:input  path="postCode"/>
    <form:errors path="postCode"/>
    Ulica:
    <form:input path="street"/>
    <form:errors path="street"/>
    Numer:
    <form:input path="number"/>
    <form:errors path="number"/>

    <input type="submit"/>

</form:form>