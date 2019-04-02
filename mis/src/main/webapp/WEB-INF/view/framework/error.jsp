<%--
  Created by IntelliJ IDEA.
  User: huan.xu
  Date: 2019/2/27
  Time: 15:29
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <title>无标题文档</title>
    <%@include file="/WEB-INF/common/header.jsp"%>

    <script language="javascript">
        $(function(){
            $('.error').css({'position':'absolute','left':($(window).width()-490)/2});
            $(window).resize(function(){
                $('.error').css({'position':'absolute','left':($(window).width()-490)/2});
            })
        });
    </script>


</head>


<body style="background:#edf6fa;">

<div class="place">
    <span>位置：</span>
    <ul class="placeul">
        <li><a href="#">首页</a></li>
        <li><a href="#">404错误提示</a></li>
    </ul>
</div>

<div class="error">

    <h2>非常遗憾，您访问的页面不存在！</h2>
    <div class="reindex"><a target="_parent"></a></div>

</div>
</body>
</html>
