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
    <title>菜单编辑</title>
    <%@include file="/WEB-INF/common/header.jsp" %>
    <script type="text/javascript">

        function submitForm() {
            $("#editForm").submit();
        }
    </script>
</head>
<body>

<div class="place">
    <span>位置：</span>
    <ul class="placeul">
        <li>系统管理</li>
        <li><a href="${pageContext.request.contextPath}/menu/list">菜单管理</a></li>
        <li>菜单编辑</li>
    </ul>
</div>

<div class="formbody">

    <form id="editForm" action="${pageContext.request.contextPath}/menu/save" method="post">
        <input type="hidden" id="id" name="id" value="${id}">
        <ul class="forminfo">
            <li>
                <label>名称</label>
                <input id="name" name="name" type="text" class="dfinput" value="${entity.name}"/>
            </li>
            <li>
                <label>url</label>
                <input id="url" name="url" type="text" class="dfinput" value="${entity.url}"/>
            </li>
            <li>
                <label>上级菜单</label>
                <div class="vocation">
                    <select class="select1" id="parentId" name="parentId">
                        <option value="">请选择</option>
                        <c:forEach items="${selectOptionMap}" var="selectOption">
                            <c:choose>
                                <c:when test="${selectOption.key eq entity.parentId}">
                                    <option value="${selectOption.key}" selected>${selectOption.value}</option>
                                </c:when>
                                <c:otherwise>
                                    <option value="${selectOption.key}">${selectOption.value}</option>
                                </c:otherwise>
                            </c:choose>

                        </c:forEach>
                    </select>
                </div>
            </li>
            <li>
                <label>排序</label>
                <input id="sort" name="sort" type="text" class="dfinput" value="${entity.sort}"/>
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
