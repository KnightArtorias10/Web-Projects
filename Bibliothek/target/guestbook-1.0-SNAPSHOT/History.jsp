
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
  <head>
    <title>History</title>
  </head>
  <body>
  <c:forEach items="${history.visited}" var="visited">
      ${visited}<br>
  </c:forEach>

  </body>
</html>