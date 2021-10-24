<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="header.jsp" %>
<style>
    table.orderList {
        font-family: "Lucida Sans Unicode", "Lucida Grande", sans-serif;
        border: 2px solid #4F7849;
        background-color: #EEEEEE;
        width: 100%;
        text-align: center;
        border-collapse: collapse;
    }

    table.orderList td, table.orderList th {
        border: 1px solid #4F7849;
        padding: 3px 2px;
    }

    table.orderList tbody td {
        font-size: 25px;
        font-weight: bold;
        color: #4F7849;
    }

    table.orderList tr:nth-child(even) {
        background: #CEE0CC;
    }

    table.orderList thead {
        background: #4F7849;
        background: -moz-linear-gradient(top, #7b9a76 0%, #60855b 66%, #4F7849 100%);
        background: -webkit-linear-gradient(top, #7b9a76 0%, #60855b 66%, #4F7849 100%);
        background: linear-gradient(to bottom, #7b9a76 0%, #60855b 66%, #4F7849 100%);
        border-bottom: 1px solid #444444;
    }

    table.orderList thead th {
        font-size: 29px;
        font-weight: bold;
        color: #FFFFFF;
        text-align: center;
        border-left: 2px solid #D0E4F5;
    }

    table.orderList thead th:first-child {
        border-left: none;
    }

    table.orderList tfoot td {
        font-size: 21px;
    }
</style>
<table class="orderList">
    <thead>
    <tr>
        <th>ID</th>
        <th>User</th>
        <th>Adres</th>
        <th>Dostawa</th>
        <th>Cena</th>
        <th>Akcja</th>
    </tr>
    </thead>
    <tbody>
    <br/><br/><br/>
    <center>
        <form method="get" action="/order/details" >
            <div style="color: #4F7849; font-size: 20px">znajdź zamówienie nr: <input type="number" name="id" value="${order.id}"/>
            <input type="submit"></div>
        </form>
    </center>
    <br/><br/>

    <c:forEach items="${orders}" var="order">
        <tr>
            <td>${order.id}</td>
            <td>${order.user.firstName} ${order.user.lastName}</td>
            <td>${order.user.city} ${order.user.street} ${order.user.number}</td>
            <td>${order.delivery.type}</td>
            <td>${order.finalPrice} zł</td>
            <td><a href="/order/details?id=${order.id}">Szczegóły</a></td>
        </tr>
    </c:forEach>
    </tbody>
</table>
<%@include file="footer.jsp" %>