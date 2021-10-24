<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="header.jsp" %>
<center>
    <div style="width: 50%" align="center">
        <h2 style="color: #4F7849">
        Witaj ${thisUser.firstName} wybrałeś ${delivery.type}<br />
            W przypadku dostawy zamówienie zostanie dostarczone na adres<br />
            ${thisUser.city} ${thisUser.street} ${thisUser.number}<br />
            Wartość zamówienia to ${finalPrice}zł.<br />
            Sposób zapłaty to ${thisOrder.payment} proszę o przygotowanie
            odliczonej gotówki jeśli wybrano taki sposób płatności.<br />

        </h2>
    </div>
</center>

<%@include file="footer.jsp" %>