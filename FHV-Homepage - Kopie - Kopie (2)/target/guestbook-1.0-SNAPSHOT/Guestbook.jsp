<%--
  Created by IntelliJ IDEA.
  User: HP EliteBook 8440p
  Date: 02.09.2018
  Time: 18:46
  To change this template use File | Settings | File Templates.
--%>
<%@ page  import="Guestbook.GuestbookEntryPOJO" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.ListIterator" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>

    <link rel="stylesheet" href="bibliothekLayout.css">
    <script>
        function setCookie(cname,cvalue,exdays) {
            var d = new Date();
            d.setTime(d.getTime() + (exdays*24*60*60*1000));
            var expires = "expires=" + d.toGMTString();
            document.cookie = cname + "=" + cvalue + ";" + expires + ";domain=;path=/";
        }

        function cookieSetter() {
            setCookie("lastpage", "Guestbook.jsp", 30);
        }
    </script>
</head>
<body onload="cookieSetter()">
<form action="Guestbook" method="POST">
<center>
    <table>
        <tr>
            <td><b>E-Mail:</b></td><td><input type="text" name="email" id="email"></td>
        </tr>
        <tr><b>Kommentar:</b></tr>
        <tr><input type="text" cols="10" rows="20" name="comment" id="comment"></tr>
        <br>
        <input type="submit" value="Absenden">
    </table>
</center>
</form>
<%
    if (request.getAttribute("guestbookEntries") != null) {
    List<GuestbookEntryPOJO> guestbookEntries = (List<GuestbookEntryPOJO>) request.getAttribute("guestbookEntries");
    for(GuestbookEntryPOJO entry : guestbookEntries) {
        out.println("<b>Email:</b> <a href=\"mailto:" + entry.getEmail() + "\">" + entry.getEmail() + "</a><br>");
        System.out.println("<b>Email:</b> <a href=\"mailto:" + entry.getEmail() + "\"><br>");
        out.println("<b>Kommentar:</b> " + entry.getComment() + "<br><br>");
        out.println("<hr noshade>");
    }
    out.println("</body>");
    out.flush();

    }
%>
</body>
</html>
