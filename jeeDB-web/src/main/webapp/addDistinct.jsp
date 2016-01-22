<%@page contentType="text/html" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <%--    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">--%>
    <title>Добавление улицы</title>
</head>

<body>
<form method="post">
    <table border="0">
        <td>
            Название района:
            <input type="text" name="distinctName" value="" size="10"/>
        </td>
        <%=request.getAttribute("resultAdd")%>
        <td>
            <input type="submit" name="commit" value="Ok"/>
        </td>
    </table>
</form>
<form action="/db/add" method="get">
    <button>Назад</button>
</form>
</body>
</html>