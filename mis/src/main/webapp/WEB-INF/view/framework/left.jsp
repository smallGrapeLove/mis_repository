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
    <%@include file="/WEB-INF/common/header.jsp"%>
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

<dl class="leftmenu">

    <dd>
        <div class="title">
            <span><img src="${pageContext.request.contextPath}/images/leftico01.png"/></span>系统管理
        </div>
        <ul class="menuson">
            <li ><cite></cite><a href="${pageContext.request.contextPath}/role/list" target="rightFrame">角色管理</a><i></i></li>
            <li ><cite></cite><a href="${pageContext.request.contextPath}/enum/list" target="rightFrame">枚举管理</a><i></i></li>
            <li ><cite></cite><a href="${pageContext.request.contextPath}/menu/list" target="rightFrame">菜单管理</a><i></i></li>
            <li ><cite></cite><a href="${pageContext.request.contextPath}/user/list" target="rightFrame">用户管理</a><i></i></li>
            <li ><cite></cite><a href="${pageContext.request.contextPath}/account/type/list" target="rightFrame">账务类型管理</a><i></i></li>
        </ul>
    </dd>

    <dd>
        <div class="title">
            <span><img src="${pageContext.request.contextPath}/images/leftico02.png"/></span>账务管理
        </div>
        <ul class="menuson">
            <li ><cite></cite><a href="${pageContext.request.contextPath}/account/list" target="rightFrame">账务记录</a><i></i></li>
        </ul>
    </dd>


    <dd>
        <div class="title"><span><img src="${pageContext.request.contextPath}/images/leftico03.png"/></span>编辑器</div>
        <ul class="menuson">
            <li><cite></cite><a href="#">自定义</a><i></i></li>
            <li><cite></cite><a href="#">常用资料</a><i></i></li>
            <li><cite></cite><a href="#">信息列表</a><i></i></li>
            <li><cite></cite><a href="#">其他</a><i></i></li>
        </ul>
    </dd>


    <dd>
        <div class="title"><span><img src="${pageContext.request.contextPath}/images/leftico04.png"/></span>日期管理</div>
        <ul class="menuson">
            <li><cite></cite><a href="#">自定义</a><i></i></li>
            <li><cite></cite><a href="#">常用资料</a><i></i></li>
            <li><cite></cite><a href="#">信息列表</a><i></i></li>
            <li><cite></cite><a href="#">其他</a><i></i></li>
        </ul>

    </dd>

</dl>
</body>
</html>
