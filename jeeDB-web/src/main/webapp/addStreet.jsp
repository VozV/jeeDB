<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>Добавление улицы</title>
</head>

<body>
<font face="Arial" size="3,5">
    <form method="post">
        <table border="0">
            <tr>
                <td>
                    Район
                    <select name="DistinctCmb" style="width: 150px">
                        <c:forEach items="${DistinctList}" var="Distinct">
                            <option value="${Distinct.key}">${Distinct.value}</option>
                        </c:forEach>
                    </select>
                </td>
            </tr>
            <tr>
                <td>
                    Название улицы
                    <input type="text" name="streetName" value="" size="10"/>
                </td>
            </tr>
            <%
                if (request.getParameter("resultAdd") != null)
                    if (request.getParameter("resultAdd").equals("success"))
                        out.println("Улица успешно добавлена");
                    else
                        out.println("Улица не добавлена");
            %>
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