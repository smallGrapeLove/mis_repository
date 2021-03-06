<%--
  Created by IntelliJ IDEA.
  User: huan.xu
  Date: 2019/2/27
  Time: 16:19
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>用户列表</title>
    <%@include file="/WEB-INF/common/header.jsp" %>
    <script type="text/javascript">
        function toAdd() {
            window.location = '${pageContext.request.contextPath}/user/toEdit/0';
        }

        function deleteUser() {
            var checkBoxPrefix = "checkBox_user_";
            var checkedData = $("input[id^='" + checkBoxPrefix + "']:checked");
            if (checkedData.length < 1) {
                alert("请选择需要删除得数据！");
            } else {
                var ids = "";
                $.each(checkedData, function (i, v) {
                    var id = $(v).attr("id");
                    ids += id.replace(checkBoxPrefix, "") + ",";
                });
                window.location = '${pageContext.request.contextPath}/user/delete?ids=' + ids;
            }
        }

        function query() {
            $("#queryForm").submit();
        }
    </script>

</head>
<body>

<div class="place">
    <span>位置：</span>
    <ul class="placeul">
        <li>系统管理</li>
        <li><a href="${pageContext.request.contextPath}/user/list">用户管理</a></li>
    </ul>
</div>

<div class="rightinfo">

    <form id="queryForm" action="${pageContext.request.contextPath}/user/list">
        <ul class="seachform">
            <li><label>显示名称</label><input id="showName" name="showName" type="text" class="scinput"
                                          value="${paramMap.showName}"/></li>
            <li><label>角色</label>
                <div class="vocation">
                    <select class="select2" id="roleId" name="roleId">
                        <option value="">全部</option>
                        <c:forEach items="${roleList}" var="role">
                            <c:choose>
                                <c:when test="${role.id eq paramMap.roleId}">
                                    <option value="${role.id}" selected>${role.name}</option>
                                </c:when>
                                <c:otherwise>
                                    <option value="${role.id}">${role.name}</option>
                                </c:otherwise>
                            </c:choose>
                        </c:forEach>
                    </select>
                </div>
            </li>
            <li><label>&nbsp;</label><input type="button" class="scbtn" value="查询" onclick="query()"/></li>
        </ul>
    </form>

    <div class="tools">

        <ul class="toolbar">
            <li class="click" onclick="toAdd()"><span><img
                    src="${pageContext.request.contextPath}/images/t01.png"/></span>添加
            </li>
            <li class="click" onclick="deleteUser()"><span><img
                    src="${pageContext.request.contextPath}/images/t03.png"/></span>删除
            </li>
        </ul>
    </div>

    <table class="tablelist">
        <thead>
        <tr>
            <th style="width: 30px;"></th>
            <th>显示名称</th>
            <th>登录名称</th>
            <th>角色</th>
            <th>操作</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${dataList}" var="data">
            <tr>
                <td>
                    <input id="checkBox_user_${data.id}" type="checkbox"/>
                </td>
                <td>${data.showName}</td>
                <td>${data.userName}</td>
                <td>${data.roleName}</td>
                <td>
                    <a href="${pageContext.request.contextPath}/user/toEdit/${data.id}" class="tablelink">编辑</a>
                </td>
            </tr>
        </c:forEach>

        </tbody>
    </table>
</div>
</body>
</html>
