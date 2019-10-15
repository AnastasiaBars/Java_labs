<%@ page contentType="text/html;" isELIgnored="false" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html>
    <body onload="val()">
    <style>
        table {
        font-family: "Lucida Sans Unicode", "Lucida Grande", Sans-Serif;
        font-size: 14px;
        border-collapse: collapse;
        text-align: center;
    }
    th, td:first-child {
        background: #AFCDE7;
        color: white;
        padding: 10px 20px;
    }
    th, td {
        border-style: solid;
        border-width: 0 1px 1px 0;
        border-color: white;
    }
    td {
        background: #D8E6F3;
    }
    </style>

    <div style="display: flex; justify-content: center;">
    <div>
        <table>
            <caption><h2>List of Shop</h2></caption>
            <tr>
                <th>id</th>
                <th>Name</th>
                <th>Address</th>
                <th>Phone number</th>
                <th>Action</th>
            </tr>
            <c:forEach items="${shops}" var="Shop">
              <tr>
                  <td><c:out value="${Shop.idShop}"/></td>
                  <td><c:out value="${Shop.name}"/></td>
                  <td><c:out value="${Shop.address}"/></td>
                  <td><c:out value="${Shop.phone}"/></td>
                  <td><a href="./up/${Shop.idShop}">Update data</a></td>
              </tr>
            </c:forEach>
        </table>
        <p style="font-size: larger; color: red">${text}</p>
    </div>

    <script>
        function val() {
            var tmp = "${history.size()}";
            if (tmp < 1) {
                document.getElementById("historyTableDiv").style.display = "none";
            }
        }
    </script>

    <div  id="historyTableDiv">
        <table>
            <caption><h2>History</h2></caption>
            <tr>
                <th>id</th>
                <th>Name</th>
                <th>Address</th>
                <th>Phone number</th>
            </tr>
            <c:forEach items="${history}" var="shop">
                <tr>
                    <td><c:out value="${shop.idShop}"/></td>
                    <td><c:out value="${shop.name}"/></td>
                    <td><c:out value="${shop.address}"/></td>
                    <td><c:out value="${shop.phone}"/></td>
                </tr>
            </c:forEach>
        </table>
    </div>
    </div>
    <a href="${pageContext.request.contextPath}/add">Add new Shop</a>
    <p>Singleton message: ${message}</p>
    </body>
</html>
