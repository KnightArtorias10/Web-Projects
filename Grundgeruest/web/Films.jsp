<%--
  Created by IntelliJ IDEA.
  User: HP EliteBook 8440p
  Date: 04.09.2018
  Time: 14:32
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Filme</title>

    <link rel="stylesheet" href="bibliothekLayout.css">
    <script>
        function setCookie(cname,cvalue,exdays) {
            var d = new Date();
            d.setTime(d.getTime() + (exdays*24*60*60*1000));
            var expires = "expires=" + d.toGMTString();
            document.cookie = cname + "=" + cvalue + ";" + expires + ";domain=;path=/";
        }

        function cookieSetter() {
            setCookie("lastpage", "Films.jsp", 30);
        }
    </script>
</head>
<body onload="cookieSetter()">
<center>
    <h1>Filme</h1>
    <table border="2">
        <tr>
            <th>Medientyp</th>
            <th>Regal</th>
            <th>Ausleihfrist</th>
            <th>Name</th>
        </tr>
        <tr>
            <td>Dokumentation</td>
            <td>DKM-01</td>
            <td>8.8.2018</td>
            <td>Die Entstehung unserer Planeten</td>
        </tr>
        <tr>
            <td>Komödie</td>
            <td>CMD-01</td>
            <td>2.2.2019</td>
            <td>Die Freeman-Show</td>
        </tr>
        <tr>
            <td>Dokumentation</td>
            <td>DKM-01</td>
            <td>7.7.2018</td>
            <td>Spiel mit dem Tod</td>
        </tr>
        <tr>
            <td>Dokumentation</td>
            <td>DKM-01</td>
            <td>6.8.2018</td>
            <td>Es war einmal der Mensch: Das Mittelalter</td>
        </tr>
    </table>
</center>
</body>
</html>
