<%--
  Created by IntelliJ IDEA.
  User: HP EliteBook 8440p
  Date: 02.09.2018
  Time: 18:46
  To change this template use File | Settings | File Templates.
--%>
<%@ page  import="java.util.List" %>
<%@ page import="java.util.ListIterator" %>
<%@ page import="Guestbook.GuestbookEntryPOJO" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<%
    List<GuestbookEntryPOJO> guestbookEntries = (List<GuestbookEntryPOJO>) request.getAttribute("guestbookEntries");
    ListIterator<GuestbookEntryPOJO> it = guestbookEntries.listIterator(guestbookEntries.size());
    while(it.hasPrevious()) {
        GuestbookEntryPOJO entry = it.previous();
        out.println("<b>Email:</b> <a href=\"mailto:" + entry.getEmail() + "\">" + entry.getEmail() + "</a><br>");
        System.out.println("<b>Email:</b> <a href=\"mailto:" + entry.getEmail() + "\"><br>");
        out.println("<b>Kommentar:</b> " + entry.getComment() + "<br><br>");
        out.println("<hr noshade>");
    }
    out.println("</body>");
    out.flush();
%>
</body>
</html>
