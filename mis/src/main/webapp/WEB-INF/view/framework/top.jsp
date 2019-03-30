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
    <title>Title</title>
    <%@include file="/WEB-INF/common/header.jsp"%>
    <%--<script type="text/javascript">--%>
        <%--$(function () {--%>
            <%--//顶部导航切换--%>
            <%--$(".nav li a").click(function () {--%>
                <%--$(".nav li a.selected").removeClass("selected")--%>
                <%--$(this).addClass("selected");--%>
            <%--})--%>
        <%--})--%>
    <%--</script>--%>
</head>
<body style="background:url(${pageContext.request.contextPath}/images/topbg.gif) repeat-x;">

<div class="topleft">
    <a href="main.html" target="_parent"><img src="${pageContext.request.contextPath}/images/logo.png" title="系统首页"/></a>
</div>

<%--<ul class="nav">--%>
    <%--<li><a href="default.html" target="rightFrame" class="selected"><img src="${pageContext.request.contextPath}/images/icon01.png" title="工作台"/>--%>
        <%--<h2>工作台</h2></a></li>--%>
    <%--<li><a href="imgtable.html" target="rightFrame"><img src="${pageContext.request.contextPath}/images/icon02.png" title="模型管理"/>--%>
        <%--<h2>模型管理</h2></a></li>--%>
    <%--<li><a href="imglist.html" target="rightFrame"><img src="${pageContext.request.contextPath}/images/icon03.png" title="模块设计"/>--%>
        <%--<h2>模块设计</h2></a></li>--%>
    <%--<li><a href="tools.html" target="rightFrame"><img src="${pageContext.request.contextPath}/images/icon04.png" title="常用工具"/>--%>
        <%--<h2>常用工具</h2></a></li>--%>
    <%--<li><a href="computer.html" target="rightFrame"><img src="${pageContext.request.contextPath}/images/icon05.png" title="文件管理"/>--%>
        <%--<h2>文件管理</h2></a></li>--%>
    <%--<li><a href="tab.html" target="rightFrame"><img src="${pageContext.request.contextPath}/images/icon06.png" title="系统设置"/>--%>
        <%--<h2>系统设置</h2></a></li>--%>
<%--</ul>--%>

<div class="topright">
    <ul>
        <li><span><img src="${pageContext.request.contextPath}/images/help.png" title="帮助" class="helpimg"/></span><a href="#">帮助</a></li>
        <li><a href="#">关于</a></li>
        <li><a href="login.html" target="_parent">退出</a></li>
    </ul>

    <div class="user">
        <span>admin</span>
        <i>消息</i>
        <b>5</b>
    </div>

</div>
</body>
</html>
