<%--
  Created by IntelliJ IDEA.
  User: huan.xu
  Date: 2019/2/27
  Time: 13:53
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <%@include file="/WEB-INF/common/header.jsp" %>
    <script type="text/javascript">
        $(function () {
            //导航切换
            $(".menuson li").click(function () {
                $(".menuson li.active").removeClass("active")
                $(this).addClass("active");
            });

            $('.title').click(function () {
                var $ul = $(this).next('ul');
                $('dd').find('ul').slideUp();
                if ($ul.is(':visible')) {
                    $(this).next('ul').slideUp();
                } else {
                    $(this).next('ul').slideDown();
                }
            });
        })
    </script>


</head>

<body style="background:#f0f9fd;">
<div class="lefttop"><span></span>通讯录</div>

<dl class="leftmenu" id="leftMenu">

    <c:forEach items="${leftMenuData}" var="topMenu">
        <c:forEach items="${topMenu.sChildrenMapList}" var="sMenu">
            <dd parentMenuId="${sMenu.sMenu.parentId}">
                <div class="title">
                    <span><img src="${pageContext.request.contextPath}/images/${sMenu.sMenu.imgName}"/></span>${sMenu.sMenu.name}
                </div>
                <ul class="menuson">
                    <c:forEach items="${sMenu.tChildrenMapList}" var="tMenu">
                        <li>
                            <cite></cite>
                            <a href="${pageContext.request.contextPath}/${tMenu.url}" target="rightFrame">${tMenu.name}</a>
                            <i></i>
                        </li>
                    </c:forEach>

                </ul>
            </dd>
        </c:forEach>
    </c:forEach>


</dl>
</body>
</html>
