<%--
  Created by IntelliJ IDEA.
  User: CHENDONG239
  Date: 2016-12-29
  Time: 17:06
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="/jsp/common/path.jsp" %>
<html>
<head>
    <base href=" <%=basePath%>">
    <script type="text/JavaScript" src="js/common/jquery-3.1.1.min.js"></script>
    <script type="text/JavaScript" src="js/user/register.js"></script>
    <title>Register</title>
</head>
<body>
user name:
<input id="userName" type="text"/><br/>
pass word:
<input id="passWord" type="password"/><br/>
e-mail:
<input id="eMail" type="text"/><br/>
telephone:
<input id="telephone" type="text"/><br/>

<button onclick="register()">提交</button>
</body>
</html>
