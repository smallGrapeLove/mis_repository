<%--
  Created by IntelliJ IDEA.
  User: huan.xu
  Date: 2019/2/27
  Time: 16:43
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>修改密码</title>
    <%@include file="/WEB-INF/common/header.jsp" %>
    <script type="text/javascript">

        function submitForm() {
            clearAllMes();
            var oldPassword = $("#oldPassword").val();
            var newPassword = $("#newPassword").val();
            var rNewPassword = $("#rNewPassword").val();
            var submitFlag = true;
            if (oldPassword == '') {
                $("#b_oldPassword").html('旧密码不能为空');
                submitFlag = false;
            }
            if (newPassword == '') {
                $("#b_newPassword").html('新密码不能为空');
                submitFlag = false;
            }
            if (rNewPassword == '') {
                $("#b_rNewPassword").html('请再次输入新密码');
                submitFlag = false;
            }
            if (submitFlag) {
                if (newPassword != rNewPassword) {
                    $("#b_rNewPassword").html('两次密码不一致');
                } else {
                    if (oldPassword == newPassword) {
                        $("#b_newPassword").html('新密码不能和旧密码一致');
                    } else {
                        $("#editForm").submit();
                    }
                }
            }
        }

    </script>
</head>
<body>

<div class="place">
    <span>位置：</span>
    <ul class="placeul">
        <li>修改密码</li>
    </ul>
</div>

<div class="formbody">

    <form id="editForm" action="${pageContext.request.contextPath}/user/password/save" method="post">
        <input type="hidden" id="userId" name="userId" value="${loginUser.id}">
        <ul class="forminfo">
            <li>
                <label>旧密码<b>*</b></label>
                <input id="oldPassword" name="oldPassword" type="password" class="dfinput" />
                <b id="b_oldPassword"></b>
            </li>
            <li>
                <label>新密码<b>*</b></label>
                <input id="newPassword" name="newPassword" type="password" class="dfinput" />
                <b id="b_newPassword"></b>
            </li>
            <li>
                <label>再次输入<b>*</b></label>
                <input id="rNewPassword" name="rNewPassword" type="password" class="dfinput"/>
                <b id="b_rNewPassword"></b>
            </li>
            <li style="height: 5px;">
                <label style="color: red;padding-left: 86px;">${changeUserPsdMsg}</label>
            </li>
            <li>
                <label>&nbsp;</label>
                <input id="saveBtn" type="button" class="btn" onclick="submitForm()" value="确认保存"/>
            </li>
        </ul>
    </form>

</div>
</body>
</html>
