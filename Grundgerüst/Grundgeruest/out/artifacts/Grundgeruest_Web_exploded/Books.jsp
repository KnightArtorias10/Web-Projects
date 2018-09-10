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
    <title>Bücher</title>

    <link rel="stylesheet" href="bibliothekLayout.css">
</head>
<script>
    function setCookie(cname,cvalue,exdays) {
        var d = new Date();
        d.setTime(d.getTime() + (exdays*24*60*60*1000));
        var expires = "expires=" + d.toGMTString();
        document.cookie = cname + "=" + cvalue + ";" + expires + ";domain=;path=/";
    }

    function cookieSetter() {
        setCookie("lastpage", "Books.jsp", 30);
    }
</script>
</head>
<body onload="cookieSetter()">
<center>
    <h1>Bücher</h1>
    <table border="2">
        <tr>
            <th>Medientyp</th>
            <th>Regal</th>
            <th>Ausleihfrist</th>
            <th>Name</th>
        </tr>
        <tr>
            <td>Fachbuch</td>
            <td>EDV-01</td>
            <td>5.8.2018</td>
            <td>Java ist auch eine Insel</td>
        </tr>
        <tr>
            <td>Fachbuch</td>
            <td>EDV-02</td>
            <td>9.9.2019</td>
            <td>Design-Patterns</td>
        </tr>
        <tr>
            <td>Fantasy-Roman</td>
            <td>FNTS-01</td>
            <td>28.8.2018</td>
            <td>Der Herr der Ringe - Teil 1</td>
        </tr>
        <tr>
            <td>Fantasy-Roman</td>
            <td>FNTS-01</td>
            <td>25.7.2018</td>
            <td>Harry Potter und die Kammer des Schreckens</td>
        </tr>
    </table>
</center>
</body>
</html>
