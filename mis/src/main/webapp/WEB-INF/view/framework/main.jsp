<%--
  Created by IntelliJ IDEA.
  User: huan.xu
  Date: 2019/2/27
  Time: 13:52
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>信息管理系统</title>
</head>
<frameset rows="88,*" cols="*" frameborder="no" border="0" framespacing="0">
    <frame src="${pageContext.request.contextPath}/login/top" name="topFrame" scrolling="No" noresize="noresize" id="topFrame" title="topFrame"/>
    <frameset cols="187,*" frameborder="no" border="0" framespacing="0">
        <frame src="${pageContext.request.contextPath}/login/left" name="leftFrame" scrolling="No" noresize="noresize" id="leftFrame" title="leftFrame"/>
        <frame src="${pageContext.request.contextPath}/login/index" name="rightFrame" id="rightFrame" title="rightFrame"/>
    </frameset>
</frameset>
<noframes>
    <body>
    </body>
</noframes>
</html>
