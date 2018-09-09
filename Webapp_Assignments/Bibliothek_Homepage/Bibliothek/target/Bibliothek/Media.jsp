<%--
  Created by IntelliJ IDEA.
  User: HP EliteBook 8440p
  Date: 04.09.2018
  Time: 13:46
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Medien</title>

    <link rel="stylesheet" href="bibliothekLayout.css">

    <script>
        function setCookie(cname,cvalue,exdays) {
            var d = new Date();
            d.setTime(d.getTime() + (exdays*24*60*60*1000));
            var expires = "expires=" + d.toGMTString();
            document.cookie = cname + "=" + cvalue + ";" + expires + ";domain=;path=/";
        }

        function cookieSetter() {
            setCookie("lastpage", "Media.jsp", 30);
        }
    </script>
</head>
<body onload="cookieSetter()">
<center>
<h1>Wählen Sie ein Medium aus.</h1>
<a href="Books.jsp">Bücher</a><br>
<a href="Films.jsp">Filme</a><br>
<a href="Games.jsp">Spiele</a>

    <a href="mailto:hans.mayer@gmx.de"><img src="emailicon.png" width="20" height="20"/></a>
</center>
</body>
</html>
