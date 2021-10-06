<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<h2>Czy chcesz usunąć ${product.name} ?</h2>

<form method="post">
    <input type="hidden" name="id" value="${product.id}">
    <button type="submit" value="yes" name="confirmed">TAK</button>
    <button type="submit" value="no" name="confirmed">NIE</button>
</form>