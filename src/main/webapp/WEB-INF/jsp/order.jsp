<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="header.jsp" %>

<style>
    .button {
        text-decoration: none;
        text-align: center;
        color: #4F7849;
        border: 2px solid #4F7849;
        border-radius: 4px;
        position: relative;
        width: 150px;
        line-height: 40px;
        display: inline-block;
        font-family: Arial;
        font-weight: 600;
        overflow: hidden;
    }

    .button:before {
        content: "";
        background-color: rgba(255, 255, 255, 0.5);
        height: 100%;
        width: 40px;
        display: block;
        position: absolute;
        top: 0;
        left: -70px;
        transform: skewX(-45deg) translateX(0px);
        transition: none;
    }

    .button:hover {
        background-color: #4F7849;
        color: #ffffff;
        border-bottom: 2px solid #4F7849;
    }

    .button:hover:before {
        transform: skewX(-45deg) translateX(250px);
        transition: all 0.4s ease-in;
    }

    table.comicGreen {
        font-family: "Comic Sans MS", cursive, sans-serif;
        border: 2px solid #4F7849;
        background-color: #EEEEEE;
        width: 100%;
        height: 50px;
        text-align: center;
        border-collapse: collapse;
    }

    table.comicGreen td, table.comicGreen th {
        border: 1px solid #4F7849;
        padding: 3px 2px;
    }

    table.comicGreen tbody td {
        font-size: 50px;
        font-weight: bold;
        color: #4F7849;
    }

    table.comicGreen tr:nth-child(even) {
        background: #CEE0CC;
    }

    table.comicGreen thead {
        background: #4F7849;
        background: -moz-linear-gradient(top, #7b9a76 0%, #60855b 66%, #4F7849 100%);
        background: -webkit-linear-gradient(top, #7b9a76 0%, #60855b 66%, #4F7849 100%);
        background: linear-gradient(to bottom, #7b9a76 0%, #60855b 66%, #4F7849 100%);
        border-bottom: 1px solid #444444;
    }

    table.comicGreen thead th {
        font-size: 50px;
        font-weight: bold;
        color: #FFFFFF;
        text-align: center;
        border-left: 2px solid #D0E4F5;
    }

    table.comicGreen thead th:first-child {
        border-left: none;
    }

    table.comicGreen tfoot {
        font-size: 50px;
        font-weight: bold;
        color: #FFFFFF;
        background: #4F7849;
        background: -moz-linear-gradient(top, #7b9a76 0%, #60855b 66%, #4F7849 100%);
        background: -webkit-linear-gradient(top, #7b9a76 0%, #60855b 66%, #4F7849 100%);
        background: linear-gradient(to bottom, #7b9a76 0%, #60855b 66%, #4F7849 100%);
        border-top: 1px solid #444444;
    }

    table.comicGreen tfoot td {
        font-size: 50px;
    }
</style>
<table class="comicGreen">
    <thead>
    <th>Produkt</th>
    <th>Ilość</th>
    <th>Cena</th>
    </thead>
    <tfoot>
    <tr>
        <td></td>
        <td></td>
        <td>${total}</td>
    </tr>
    </tfoot>
    <tbody>
    <c:forEach items="${orderItems}" var="item">
        <tr>
            <td>${item.product.name}</td>
            <td>
                    ${item.quantity}
            </td>
            <td>${item.product.price}</td>
        </tr>
    </c:forEach>
    </tbody>
</table>
<br/><br/><br/>
<form:form method="post" modelAttribute="order" cssStyle="color: #D0E4F5">

    Dane do dostawy:
<%--    Imię:--%>
<%--    <form:input  path="user.firstName"/>--%>
<%--    <form:errors path="user.firstName"/><br /><br />--%>
<%--    Nazwisko:--%>
<%--    <form:input  path="user.lastName"/>--%>
<%--    <form:errors path="user.lastName"/><br /><br />--%>
<%--    Numer telefonu:--%>
<%--    <form:input path="user.phoneNumber"/>--%>
<%--    <form:errors path="user.phoneNumber"/><br /><br />--%>
<%--    Email:--%>
<%--    <form:input path="user.email"/>--%>
<%--    <form:errors path="user.email"/><br /><br />--%>
<%--    Miasto:--%>
<%--    <form:input  path="user.city"/>--%>
<%--    <form:errors path="user.city"/><br /><br />--%>
<%--    Kod pocztowy:--%>
<%--    <form:input  path="user.postCode"/>--%>
<%--    <form:errors path="user.postCode"/><br /><br />--%>
<%--    Ulica:--%>
<%--    <form:input path="user.street"/>--%>
<%--    <form:errors path="user.street"/><br /><br />--%>
<%--    Numer:--%>
<%--    <form:input path="user.number"/>--%>
<%--    <form:errors path="user.number"/><br /><br />--%>
<%----%>
    <form:select path="user.id" itemLabel="lastName" itemValue="id" items="${users}"/>
    <a href="/user/add"> dodaj odbiorcę </a>
    <br /><br />
    Dostawa:
    <form:select itemValue="id" itemLabel="type" path="delivery.id" items="${deliveries}"/><br /><br />
    Płatność:
    Gotówka:
    <form:radiobutton path="payment" value="Gotówka"/>
    Karta:
    <form:radiobutton path="payment" value="Karta"/><br /><br />
    <input type="submit" value="Zamawiam" class="button" />
</form:form>

<%--<center>--%>
<%--    <a href="/order/order" class="button">Zamawiam</a>--%>
<%--</center>--%>

<%@include file="footer.jsp" %>