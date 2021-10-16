<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="header.jsp"%>
<%--<section class="container5">--%>
<%--    <h3>We like to keep things simple</h3>--%>
<%--    <p>--%>
<%--        Lorem ipsum dolor sit amet, consectetur--%>
<%--        adipisicing elit, sed do eiusmod tempor--%>
<%--        incididunt ut labore et dolore magna aliqua.--%>
<%--        Ut enim ad minim veniam quis--%>
<%--    </p>--%>
<%--    <img class="wow bounce" data-wow-duration="2s" src="../../img/item2.png" alt="photo">--%>
<%--    <img class="wow bounce" data-wow-duration="2s" src="../../img/item2.png" alt="photo">--%>
<%--    <img class="wow bounce" data-wow-duration="2s" src="../../img/item2.png" alt="photo">--%>
<%--</section>--%>
    <section class="container6">
<%--    <img class="fon" src="../../img/bg3.png">--%>
    <div class="center">
        <div class="content">
            <div class="caption">
                <h2>Odkryj</h2>
                <h3>nasze nowe menu</h3>
            </div>
            <c:forEach items="${products}" var="product">
                <div class="item">
                    <a href="/orderItem/add/${product.id}" ><img src="../../img/Object1.png" alt="photo"></a>
                    <div class="text">
                        <h4>${product.name}</h4>
                        <p>${product.description}
                             <span>${product.price}</span>
                        </p>
                    </div>
                </div>
<%--                <a href="update/${product.id}">Edytuj </a>--%>
<%--                <a href="delete/${product.id}">Usuń </a>--%>
            </c:forEach>
        </div>
    </div>
    <img class="fon" src="../../img/bg4.png">
</section>
<%@include file="footer.jsp"%>