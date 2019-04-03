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
    <title>角色编辑</title>
    <%@include file="/WEB-INF/common/header.jsp" %>
    <script type="text/javascript">
        $(function () {
            $("#remark").val('${role.remark}');
        });

        function submitForm() {
            clearAllMes();
            var name = $("#name").val();
            var submitFlag = true;
            if (name == '') {
                $("#b_name").html('角色名称不能为空');
                submitFlag = false;
            }
            if (submitFlag) {
                $("#editForm").submit();
            }
        }
    </script>
</head>
<body>

<div class="place">
    <span>位置：</span>
    <ul class="placeul">
        <li>系统管理</li>
        <li><a href="${pageContext.request.contextPath}/role/list">角色管理</a></li>
        <li>角色编辑</li>
    </ul>
</div>

<div class="formbody">

    <form id="editForm" action="${pageContext.request.contextPath}/role/save" method="post">
        <input type="hidden" id="id" name="id" value="${id}">
        <ul class="forminfo">
            <li>
                <label>角色名称<b>*</b></label>
                <input id="name" name="name" type="text" class="dfinput" value="${role.name}"/>
                <b id="b_name"></b>
            </li>
            <li>
                <label>描述</label>
                <textarea id="remark" name="remark" class="textinput"></textarea>
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
