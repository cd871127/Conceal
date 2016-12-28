<%--
  Created by IntelliJ IDEA.
  User: chendong239
  Date: 2016-12-27
  Time: 11:23
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <script type="text/JavaScript" src="js/common/jquery-3.1.1.min.js"></script>
    <script type="text/JavaScript" src="js/login.js"></script>
    <title>Conceal</title>
</head>
<body>
<form method="post">
    user name:
    <input id="username" type="text" name="username"/>
    <br>
    pass word:
    <input id="password" type="password" name="password"/>
    <button onclick="loginFunc()">登录</button>
</form>

</body>
</html>
