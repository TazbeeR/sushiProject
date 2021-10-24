<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<h2>Dodanie nowego użytkownika</h2>

<form:form method="post" modelAttribute="user">
    <form:hidden path="id"/>
    Imię:
    <form:input  path="firstName"/>
    <form:errors path="firstName"/><br /><br />
    Nazwisko:
    <form:input  path="lastName"/>
    <form:errors path="lastName"/><br /><br />
    Numer telefonu:
    <form:input path="phoneNumber"/>
    <form:errors path="phoneNumber"/><br /><br />
    Email:
    <form:input path="email"/>
    <form:errors path="email"/><br /><br />
    Miasto:
    <form:input  path="city"/>
    <form:errors path="city"/><br /><br />
    Kod pocztowy:
    <form:input  path="postCode"/>
    <form:errors path="postCode"/><br /><br />
    Ulica:
    <form:input path="street"/>
    <form:errors path="street"/><br /><br />
    Numer:
    <form:input path="number"/>
    <form:errors path="number"/><br /><br />
    <input type="submit"/>

</form:form>