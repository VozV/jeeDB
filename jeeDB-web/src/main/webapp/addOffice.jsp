<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>Добавление заказа</title>
</head>

<body>
<font face="Arial" size="3,5">
    <h2>Добавление заказа <%= request.getAttribute("123") %> </h2>
    <form action="db/addoffice" method="post">
        <table border="0">
            <tr>
                <td>
                    Улица
                    <select name="StreetCmb" style="width: 150px">
                        <c:forEach items="${StreetList}" var="Street">
                            <option value="${Street.key}">${Street.value}</option>
                        </c:forEach>
                    </select>
                </td>
            </tr>
            <tr>
                <td>
                    Дом
                    <input type="text" name="houseNumer" value="" size="10"/>
                </td>
            </tr>
            <tr>
                <td>
                    Офис
                    <input type="text" name="houseOffice" value="" size="10"/>
                </td>
            </tr>
            <tr>
                <td>
                    <input type="submit" name="commit" value="Ok"/>
                </td>
            </tr>
        </table>
    </form>
    <form action="/db/add" method="get">
        <button>Назад</button>
    </form>
</font>
</body>
</html>