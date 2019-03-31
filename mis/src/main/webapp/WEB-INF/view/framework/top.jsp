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
    <%@include file="/WEB-INF/common/header.jsp" %>

</head>
<body style="background:url(${pageContext.request.contextPath}/images/topbg.gif) repeat-x;">

<div class="topleft">
    <a href="main.html" target="_parent"><img src="${pageContext.request.contextPath}/images/logo.png"
                                              title="系统首页"/></a>
</div>

<ul class="nav" id="topNav">
    <c:forEach items="${topMenuList}" var="topMenu">
        <li topMenuId="${topMenu.id}">
            <a href="javascript:void(0)" onclick="changeTopMenu(this)" target="rightFrame">
                <img src="${pageContext.request.contextPath}/images/${topMenu.imgName}" title="${topMenu.name}"/>
                <h2>${topMenu.name}</h2>
            </a>
        </li>
    </c:forEach>
</ul>

<div class="topright">
    <ul>
        <li><span><img src="${pageContext.request.contextPath}/images/help.png" title="帮助" class="helpimg"/></span><a
                href="#">帮助</a></li>
        <li><a href="#">关于</a></li>
        <li><a href="${pageContext.request.contextPath}/login/logOut" target="_parent">退出</a></li>
    </ul>

    <div class="user">
        <span>${loginUser.showName}</span>
        <i>消息</i>
        <b>5</b>
    </div>

</div>
<script type="text/javascript">

    $(function () {
        //默认选中第一个
        changeTopMenu($("#topNav").find("li").eq(0).find("a"));

    });

    /**
     * 顶部菜单切换
     * @param menuId
     */
    function changeTopMenu(o) {
        $(".nav li a.selected").removeClass("selected");
        $(o).addClass("selected");
        var topMenuId = $(o).parent().attr("topMenuId");
        var ddArrs = $(parent.frames["leftFrame"].document.getElementById("leftMenu")).find("dd");
        $.each(ddArrs, function (i, v) {
            var leftMenuId = $(v).attr("parentmenuid");
            if (topMenuId == leftMenuId) {
                $(v).hide();
            } else {
                $(v).show();
            }
        });


    }
</script>
</body>
</html>
