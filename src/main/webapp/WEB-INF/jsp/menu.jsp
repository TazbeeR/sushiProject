<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="header.jsp"%>
    <section class="container6">
    <img class="fon" src="../../img/bg3.png">
    <div class="center">
        <div class="content">
            <div class="caption">
                <h2>Odkryj</h2>
                <h3>nasze nowe menu</h3>
            </div>
            <c:forEach items="${products}" var="product">
                <div class="item">
                    <img src="../../img/Object1.png" alt="photo">
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