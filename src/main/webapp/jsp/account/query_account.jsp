<%--
  Created by IntelliJ IDEA.
  User: Anthony
  Date: 2017/1/1
  Time: 2:04
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="/jsp/common/path.jsp" %>
<html>
<head>
    <base href=" <%=basePath%>">
    <script type="text/JavaScript" src="js/common/jquery-3.1.1.min.js"></script>
    <script type="text/JavaScript" src="js/common/common.js"></script>
    <script type="text/JavaScript" src="js/account/account.js"></script>
    <title>Title</title>
</head>
<body>
<div id="tableDiv">

</div>
<button id="nextPage" onclick="queryAccount(curPage++)">下一页</button>
</body>
</html>
