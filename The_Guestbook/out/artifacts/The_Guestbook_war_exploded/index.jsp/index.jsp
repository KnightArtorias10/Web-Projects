<%@ page import="GuestbookDB.GuestbookEntry" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.ListIterator" %><%--
  Created by IntelliJ IDEA.
  User: csc4810
  Date: 26.06.2018
  Time: 16:21
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>$Title$</title>

    <script type="text/javascript">
      function validate() {
          var name = document.getElementById("tf_name");
          var comment = document.getElementById("ta_comment");

          if(name.value == "" || name.value==null) {
              alert("Bitte geben Sie Ihren Namen ein");
              Name.style.border = "2px solid red";
              name.focus();
              return false;
          }

          if(comment.value="" || comment.value==null) {
              alert("Bitte geben Sie einen Kommentar ein!");
              Name.style.border = "2px solid red";
              comment.focus();
              return false;
          }
      }
    </script>
  </head>
  <body>
  <form action="Entry" method="post" lang="de">
    <center>
      <table>
        <tr>
          <td><b>Name:</b></td>
        </tr>
        <tr>
          <td><input type="text" id="tf_name"/></td>
        </tr>
        <tr>
          <td><b>Kommentar:</b></td>
        </tr>
        <tr>
          <td><textarea id="ta_comment" cols="30" rows="10"></textarea></td>
        </tr>
        <tr>
          <td><input type="submit" value="Absenden" onclick="return validate()"/></td>
        </tr>
      </table>
    </center>
  </form>

  <%
    List<GuestbookEntry> guestbookEntries = (List<GuestbookEntry>) request.getAttribute("guestbookEntries");
    ListIterator<GuestbookEntry> it = guestbookEntries.listIterator(guestbookEntries.size());
    while(it.hasPrevious()) {
      GuestbookEntry entry = it.previous();
      out.println("<b>Name:</b> " + entry.getName() + "<br>");
      out.println("<b>Kommentar:</b> " + entry.getComment() + "<br><br>");
      out.println("<hr noshade>");
    }
    out.println("</body>");
    out.flush();
  %>
  </body>
</html>
