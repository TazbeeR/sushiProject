<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="header.jsp"%>
<style>
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
        font-size: 19px;
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
        font-size: 15px;
        font-weight: bold;
        color: #FFFFFF;
        text-align: center;
        border-left: 2px solid #D0E4F5;
    }
    table.comicGreen thead th:first-child {
        border-left: none;
    }

    table.comicGreen tfoot {
        font-size: 21px;
        font-weight: bold;
        color: #FFFFFF;
        background: #4F7849;
        background: -moz-linear-gradient(top, #7b9a76 0%, #60855b 66%, #4F7849 100%);
        background: -webkit-linear-gradient(top, #7b9a76 0%, #60855b 66%, #4F7849 100%);
        background: linear-gradient(to bottom, #7b9a76 0%, #60855b 66%, #4F7849 100%);
        border-top: 1px solid #444444;
    }
    table.comicGreen tfoot td {
        font-size: 21px;
    }
</style>
<table class="comicGreen">
    <thead>
        <th>Produkt</th><th>Ilość</th><th>Cena</th>
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
                <a href="/orderItem/minus/${item.product.name}">minus</a>
                    ${item.quantity}
                <a href="/orderItem/plus/${item.product.name}">plus</a>
            </td>
            <td>${item.product.price}</td>
        </tr>
    </c:forEach>
    </tbody>
</table>

<%@include file="footer.jsp"%>