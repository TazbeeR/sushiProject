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
<center>
    <div style="width: 50%" align="center">
        <h2 style="color: #4F7849; font-size: 25px">
            Zamówienie nr ${order.id} <br/><br />
            Zamawiający ${order.user.firstName} ${order.user.lastName}<br/><br />
            Adres: <br/>
            ${order.user.city}<br/>
            ul ${order.user.street} ${order.user.number}<br/>

            <br/><br/><br/>
            Szczegóły zamówienia<br/>

            <table class="orderList">
                <thead>
                <tr>
                    <th>Nazwa</th>
                    <th>Ilość</th>
                    <th>Cena</th>
                </tr>
                </thead>
                <tbody>
                <c:forEach items="${orderItems}" var="item">
                    <tr>
                        <td>${item.product.name}</td>
                        <td>${item.quantity}</td>
                        <td>${item.product.price}</td>
                    </tr>
                </c:forEach>
                <tr>
                    <td></td>
                    <td>${order.delivery.type}</td>
                    <td>${order.delivery.price}</td>
                </tr>
                <tr>
                    <td></td>
                    <td>Płatność ${order.payment}</td>
                    <td>${order.finalPrice} zł</td>
                </tr>
                </tbody>
            </table>


        </h2>
    </div>
</center>


<%@include file="footer.jsp" %>