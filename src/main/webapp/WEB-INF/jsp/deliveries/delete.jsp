<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<h2>Czy chcesz usunąć ${delivery.type} ?</h2>

<form method="post">
    <input type="hidden" name="id" value="${delivery.id}">
    <button type="submit" value="yes" name="confirmed">TAK</button>
    <button type="submit" value="no" name="confirmed">NIE</button>
</form>