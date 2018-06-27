<%@ taglib prefix="h" uri="http://java.sun.com/jsf/html" %>
<%--
  Created by IntelliJ IDEA.
  User: csc4810
  Date: 25.06.2018
  Time: 15:06
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Gästebuch</title>
</head>
<body>
<form>
    <table>
        <tr>
            <td><b>Name:</b>
        </tr>
        <tr>
            <input type="text" id="tf_name"/>
        </tr>
        <tr>
            <b>Kommentar:</b>
        </tr>
        <tr>
            <h:inputTextarea id="ta_comment"/>
        </tr>
        <tr>
            <commandButton onclick="">Absenden</commandButton>
        </tr>
    </table>
</form>
</body>
</html>
