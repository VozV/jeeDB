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
    <h2>Добавление заказа</h2>
    <form method="post">
        <table border="0">
            <%
                if (request.getParameter("resultAdd") != null)
                    if (request.getParameter("resultAdd").equals("success"))
                        out.println("Заказ успешно добавлен");
                    else
                        out.println("Заказ не добавлен");
            %>
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
                    <input type="text" name="officeNumer" value="" size="10"/>
                </td>
                <%--<select>
                    <% for (Object obj : (HashMap) request.getAttribute("DistinctList")) { %>
                    <option value="<%=obj%>"><%=obj%></option>
                    <% } %>
                </select>--%>
            </tr>
            <tr>
                <td>
                    Стоимость
                    <input type="text" name="count" value="" size="10"/>
                </td>
            </tr>
            <tr>
                <td>
                    Описание
                    <input type="text" name="text" value="" size="50"/>
                </td>
            </tr>
            <tr>
                <td>
                    <input type="submit" name="sumbit" value="Ok"/>
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