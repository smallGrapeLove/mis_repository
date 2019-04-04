<%--
  Created by IntelliJ IDEA.
  User: huan.xu
  Date: 2019/2/27
  Time: 13:48
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>欢迎登录信息管理系统</title>
    <link href="../../css/style.css" rel="stylesheet" type="text/css"/>
    <script language="JavaScript" src="../../js/jquery-1.8.0.min.js"></script>
    <script src="../../js/cloud.js" type="text/javascript"></script>
    <script type="text/javascript">
        $(function () {
            $('.loginbox').css({'position': 'absolute', 'left': ($(window).width() - 692) / 2});
            $(window).resize(function () {
                $('.loginbox').css({'position': 'absolute', 'left': ($(window).width() - 692) / 2});
            })
        });

        function submitForm() {
            var userName = $("#userName").val();
            var password = $("#password").val();
            var errorMsg = '';
            if (userName == '') {
                errorMsg = '用户名不能为空';
            }
            if (errorMsg == '') {
                if (password == '') {
                    errorMsg = '密码不能为空';
                }
            }
            if (errorMsg != '') {
                $("#errorMsg").text(errorMsg);
            } else {
                $("#loginForm").submit();
            }
        }
    </script>
</head>

<body style="background-color:#1c77ac; background-image:url(../../images/light.png); background-repeat:no-repeat; background-position:center top; overflow:hidden;">


<div id="mainBody">
    <div id="cloud1" class="cloud"></div>
    <div id="cloud2" class="cloud"></div>
</div>


<%--<div class="logintop">--%>
    <%--<span>欢迎登录信息管理界面平台</span>--%>
    <%--&lt;%&ndash;<ul>&ndash;%&gt;--%>
        <%--&lt;%&ndash;<li><a href="#">回首页</a></li>&ndash;%&gt;--%>
        <%--&lt;%&ndash;<li><a href="#">帮助</a></li>&ndash;%&gt;--%>
        <%--&lt;%&ndash;<li><a href="#">关于</a></li>&ndash;%&gt;--%>
    <%--&lt;%&ndash;</ul>&ndash;%&gt;--%>
<%--</div>--%>

<div class="loginbody">
    <span class="systemlogo"></span>
    <form id="loginForm" action="${pageContext.request.contextPath}/login/logOn" method="post">
        <div class="loginbox">
            <ul>

                <li>
                    <input name="userName" id="userName" type="text" class="loginuser" value="${userName}"/>
                </li>
                <li>
                    <input name="password" id="password" type="password" class="loginpwd" value="${password}"/>
                </li>
                <li style="height: 5px;">
                    <label id="errorMsg" style="color: red;">${errorMsg}</label>
                </li>
                <li>
                    <input name="" type="button" class="loginbtn" value="登录" onclick="submitForm()"/>
                </li>
            </ul>
        </div>
    </form>
</div>
<div class="loginbm">版权所有huan.xu</div>
</body>
</html>
