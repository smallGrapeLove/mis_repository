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
    <title>用户编辑</title>
    <%@include file="/WEB-INF/common/header.jsp" %>
    <script type="text/javascript">

        function submitForm() {
            clearAllMes();
            var showName = $("#showName").val();
            var userName = $("#userName").val();
            var roleId = $("#roleId").val();
            var submitFlag = true;
            if (showName == '') {
                $("#b_showName").html('显示名称不能为空');
                submitFlag = false;
            }
            if (userName == '') {
                $("#b_userName").html('登陆名称不能为空');
                submitFlag = false;
            }
            if (roleId == '') {
                $("#b_roleId").html('请选择角色');
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
        <li><a href="${pageContext.request.contextPath}/user/list">用户管理</a></li>
        <li>用户编辑</li>
    </ul>
</div>

<div class="formbody">

    <form id="editForm" action="${pageContext.request.contextPath}/user/save" method="post">
        <input type="hidden" id="id" name="id" value="${id}">
        <ul class="forminfo">
            <li>
                <label>显示名称<b>*</b></label>
                <input id="showName" name="showName" type="text" class="dfinput" value="${entity.showName}"/><b
                    id="b_showName"></b>
            </li>
            <li>
                <label>登录名称<b>*</b></label>
                <input id="userName" name="userName" type="text" class="dfinput" value="${entity.userName}"/><b
                    id="b_userName"></b>
            </li>
            <li>
                <label>角色<b>*</b></label>
                <div class="vocation" style="float: left;">
                    <select class="select1" id="roleId" name="roleId">
                        <option value="">请选择</option>
                        <c:forEach items="${roleList}" var="role">
                            <c:choose>
                                <c:when test="${role.id eq entity.roleId}">
                                    <option value="${role.id}" selected>${role.name}</option>
                                </c:when>
                                <c:otherwise>
                                    <option value="${role.id}">${role.name}</option>
                                </c:otherwise>
                            </c:choose>
                        </c:forEach>
                    </select>
                </div>
                <div style="float: left;"><b id="b_roleId"></b></div>
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
