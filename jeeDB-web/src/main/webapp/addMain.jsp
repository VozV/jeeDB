<%@page contentType="text/html" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>Добавление</title>
</head>

<body>
    <h3>Что добавить?</h3>
    <form action="add/distinct" method="get">
        <button>Район</button>
    </form>
    <form action="add/street" method="get">
        <button>Улица</button>
    </form>
    <form action="add/office" method="get">
        <button>Дом/Офис</button>
    </form>
    <form action="add/order" method="get">
        <button>Заказ</button>
    </form>
</body>
</html>