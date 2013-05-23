<%--
  Created by IntelliJ IDEA.
  User: Anfield
  Date: 22.05.13
  Time: 12:45
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<LINK REL=STYLESHEET TYPE="text/css" HREF="my.css">

<html>
<head>
    <title></title>
</head>
<body>
<table class="features-table">
    <thead>
    <tr>
        <td class="grey">First name</td>
        <td class="grey">Last name</td>
        <td class="grey">Email</td>
        <td class="grey">Password</td>
    </tr>
    </thead>

    <tfoot>
    <tr>
        <td class="green"><c:out value="${accountInfo.fname}" /></td>
        <td class="green"><c:out value="${accountInfo.lname}" /></td>
        <td class="green"><c:out value="${accountInfo.email}" /></td>
        <td class="green"><c:out value="${accountInfo.pass}" /></td>
    </tr>
    </tfoot>
    </tbody>
</table>
</body>
</html>
