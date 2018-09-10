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
    <title>Spiele</title>

    <link rel="stylesheet" href="bibliothekLayout.css">
    <script>
        function setCookie(cname,cvalue,exdays) {
            var d = new Date();
            d.setTime(d.getTime() + (exdays*24*60*60*1000));
            var expires = "expires=" + d.toGMTString();
            document.cookie = cname + "=" + cvalue + ";" + expires + ";domain=;path=/";
        }

        function cookieSetter() {
            setCookie("lastpage", "Games.jsp", 30);
        }
    </script>
</head>
<body onload="cookieSetter()">
<table border="2">
    <tr>
        <th>Medientyp</th>
        <th>Regal</th>
        <th>Ausleihfrist</th>
        <th>Name</th>
    </tr>
    <tr>
        <td>Action/Phantasy</td>
        <td>GMS-01</td>
        <td>25.8.2018</td>
        <td>Dark Souls</td>
    </tr>
    <tr>
        <td>Rennspiel</td>
        <td>GMS-01</td>
        <td>20.9.2018</td>
        <td>Neef for Speed - Most Wanted</td>
    </tr>
    <tr>
        <td>Jump'n'Run</td>
        <td>GMS-01</td>
        <td>10.10.2018</td>
        <td>Super Mario Galaxy</td>
    </tr>
    <tr>
        <td>Puzzle</td>
        <td>GMS-01</td>
        <td>12.11.2018</td>
        <td>Portal</td>
    </tr>
</table>
</center>
</body>
</html>
