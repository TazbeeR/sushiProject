<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<h2>Czy chcesz usunąć ${address.street} ${address.number} ?</h2>

<form method="post">
    <input type="hidden" name="id" value="${address.id}">
    <button type="submit" value="yes" name="confirmed">TAK</button>
    <button type="submit" value="no" name="confirmed">NIE</button>
</form>