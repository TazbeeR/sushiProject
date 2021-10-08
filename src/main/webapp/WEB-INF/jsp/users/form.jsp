<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<h2>Dodanie nowego użytkownika</h2>

<form:form method="post" modelAttribute="user">
    <form:hidden path="id"/>
    Imię:
    <form:input  path="firstName"/>
    <form:errors path="firstName"/>
    Nazwisko:
    <form:input  path="lastName"/>
    <form:errors path="lastName"/>
    Numer telefonu:
    <form:input path="phoneNumber"/>
    <form:errors path="phoneNumber"/>
    Email:
    <form:input path="email"/>
    <form:errors path="email"/>
    Adres:
    <form:select path="address.id" items="${addresses}" itemLabel="street" itemValue="id"/>

    <input type="submit"/>

</form:form>