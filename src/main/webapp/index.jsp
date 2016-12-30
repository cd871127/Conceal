<%--
  Created by IntelliJ IDEA.
  User: chendong239
  Date: 2016-12-27
  Time: 11:23
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="/jsp/common/path.jsp"%>
<html>
<head>
    <base href=" <%=basePath%>">
    <script type="text/JavaScript" src="js/common/jquery-3.1.1.min.js"></script>
    <script type="text/JavaScript" src="js/user/login.js"></script>
    <title>Conceal</title>
</head>
<body>
    user name:
    <input id="userName" type="text"/>
    <br/>
    pass word:
    <input id="passWord" type="password"/> <br/>
    <label id="errorMessage" hidden></label>
    <button onclick="login()">登录</button>  <button onclick="jumpToRegister()">注册</button><br/>
</body>
</html>
