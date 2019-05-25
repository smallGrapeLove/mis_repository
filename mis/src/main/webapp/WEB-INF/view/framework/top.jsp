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

    <script type="text/javascript">
        var int=self.setInterval("clock()",1000);
        function clock()
        {
            var d=new Date();
            var t=d.toLocaleTimeString();
            $("#currDate").val(t);
        }

        var weekArr = new Array("日", "一", "二", "三", "四", "五", "六");

        function showCurrDate() {
            var date = new Date();
            var currDate = date.toLocaleString();
            var weekStr = weekArr[date.getDay()];
            var currDateStr = "星期" + weekStr + " " + currDate;
            $("#currDate").text(currDateStr);
        }

        $(function () {
            window.setInterval(showCurrDate,1000);
        })
    </script>
</head>
<body style="background:url(${pageContext.request.contextPath}/images/topbg.gif) repeat-x;">

<div class="topleft">
    <a target="_parent"><img src="${pageContext.request.contextPath}/images/logo.png"
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
        <li>
            <span>
                <%--<img src="${pageContext.request.contextPath}/images/help.png" title="帮助" class="helpimg"/>--%>
            </span>
            <a></a></li>
        <li><a id="currDate"></a></li>
        <li><a href="${pageContext.request.contextPath}/user/password/toEdit" target="rightFrame">修改密码</a></li>
        <li><a href="${pageContext.request.contextPath}/login/logOut" target="_parent">退出</a></li>
    </ul>

    <div class="user">
        <span>${loginUser.showName}</span>
        <%--<b>5</b>--%>
    </div>

</div>
<script type="text/javascript">

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
                $(v).show();
            } else {
                $(v).hide();
            }
        });
    }
</script>
</body>
</html>
