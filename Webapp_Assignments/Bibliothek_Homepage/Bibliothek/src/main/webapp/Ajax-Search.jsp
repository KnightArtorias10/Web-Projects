<%--
  Created by IntelliJ IDEA.
  User: HP EliteBook 8440p
  Date: 05.09.2018
  Time: 21:58
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <script type="text/javascript" src="jquery key"/>
    <script type="text/javascript">
    function getCities(value) {
        $.post("getCities.php", {name:value}, function(data) {
            $("results").html(data);
        })
    }
    </script>
</head>
<body>
 <input type="text" onkeyup="getCities(this.value)"/>

 <div id="results"></div>
</body>
</html>
