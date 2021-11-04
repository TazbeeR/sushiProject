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
<br/><br/><br/><section class="container7">
    <form:form method="post" modelAttribute="userOrderDTO">
        <div class="caption">
            <h2>Dane do zamówienia</h2>
        </div>
        <div class="block1">
            <div class="text">
                <p>Imię</p>
                <form:input path="firstName" placeholder="Imię"/>
                <form:errors path="firstName"/>
            </div>
            <div class="text">
                <p>Nazwisko</p>
                <form:input  path="lastName" placeholder="Nazwisko"/>
                <form:errors path="lastName"/>
            </div>
            <div class="text">
                <p>Telefon</p>
                <form:input path="phoneNumber" placeholder="555555555"/>
                <form:errors path="phoneNumber"/>
            </div>
        </div>
        <div class="block2">
            <div class="text">
                <p>Miasto</p>
                <form:input  path="city" placeholder="Miasto"/>
                <form:errors path="city"/>
            </div>
            <div class="text">
                <p>Kod pocztowy</p>
                <form:input  path="postCode" placeholder="11-111"/>
                <form:errors path="postCode"/>
            </div>
            <div class="text">
                <p>Ulica</p>
                <form:input path="street" placeholder="Ulica"/>
                <form:errors path="street"/>
            </div>
            <div class="text">
                <p>Numer</p>
                <form:input path="number" placeholder="Nr domu/mieszkania"/>
                <form:errors path="number"/>
            </div>
        </div>
        <div class="block3">
            <div class="text">
                <p>Email</p>
                <form:input path="email" placeholder="Tutaj wpisz swój email"/>
                <form:errors path="email"/>
            </div>
            <div class="select">
                <p>Dostawa</p>
                <form:select itemValue="id" itemLabel="type" path="delivery.id" items="${deliveries}"/>
            </div>
            <div class="select">
                <p>Płatność</p>
                <form:select path="payment" items="${pay}"/>
            </div>
        </div>
        <div class="submit">
            <input type="submit" id="submit" value="Zamawiam" />
        </div>
    </form:form>
</section>
<%@include file="footer.jsp" %>
