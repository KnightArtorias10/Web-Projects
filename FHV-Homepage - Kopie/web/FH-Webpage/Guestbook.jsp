<%@ page import="Guestbook.GuestbookEntry" %><%--
  Created by IntelliJ IDEA.
  User: windb
  Date: 26.03.2018
  Time: 14:51
  To change this template use File | Settings | File Templates.
--%>
<%@ page  import="java.util.List" %>
<%@ page import="java.util.ListIterator" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <title>Gaestebuch</title>
  <head>
    <title>Gaestebuch</title>
      <script>
          function setCookie(cname,cvalue,exdays) {
              var d = new Date();
              d.setTime(d.getTime() + (exdays*24*60*60*1000));
              var expires = "expires=" + d.toGMTString();
              document.cookie = cname + "=" + cvalue + ";" + expires + ";domain=;path=/";
          }

          function cookieSetter() {
              setCookie("lastpage", "Show", 30);
          }
      </script>
  </head>
  <body onload="cookieSetter()" bgcolor=0080FF>
  <a href="javascript:history.back()">Zurueck</a>

  <script type="text/javascript" lang="de">
      function validate() {
          var Name = document.getElementById("Name");
          if (Name.value == "" || Name.value == null) {
              alert("Bitte gib einen Namen ein");
              Name.style.border = "2px solid red";
              Name.focus();
              return false;
          } else {
              Name.style.border = "";
          }
          var Email = document.getElementById("Email");
          if (Email.value == "" || Email.value == null) {
              alert("Bitte gib eine E-Mail Adresse ein");
              Email.style.border = "2px solid red";
              Email.focus();
              return false;
          } else {
              Email.style.border = "";
          }
          var Nachricht = document.getElementById("Nachricht");
          if (Nachricht.value == "" || Nachricht.value == null) {
              alert("Bitte gib eine Nachricht ein");
              Nachricht.style.border = "2px solid red";
              Nachricht.focus();
              return false;
          } else {
              Nachricht.style.border = "";
          }
      }
  </script>
  <form action="Entry" method="post" lang="de">
      Name:<br>
      <input type="text" name="Name" id="Name">
      <br>
      Email:<br>
      <input type="email" id="Email" name="Email">
      <br>
      Nachricht:<br>
      <textarea id="Nachricht" name="Nachricht" cols="100" rows="10" maxlength="900"></textarea>
      <br>
      <br>
      <input type="submit" value="Absenden" onclick="return validate()">
  </form>
  <hr noshade>
  <hr noshade>
  <%
      List<GuestbookEntry> guestbookEntries = (List<GuestbookEntry>) request.getAttribute("guestbookEntries");
      ListIterator<GuestbookEntry> it = guestbookEntries.listIterator(guestbookEntries.size());
      while(it.hasPrevious()) {
          GuestbookEntry entry = it.previous();
          out.println(entry.getTimestamp() + " <br><b>Name:</b> " + entry.getName() + "<br>");
          out.println("<b>Email:</b> <a href=\"mailto:" + entry.getEmail() + "\">" + entry.getEmail() + "</a><br>");
          System.out.println("<b>Email:</b> <a href=\"mailto:" + entry.getEmail() + "\"><br>");
          out.println("<b>Nachricht:</b> " + entry.getMessage() + "<br><br>");
          out.println("<hr noshade>");
          }
        out.println("</body>");
        out.flush();
  %>

  </body>
</html>
