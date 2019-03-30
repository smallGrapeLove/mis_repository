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
    <title>枚举编辑</title>
    <%@include file="/WEB-INF/common/header.jsp" %>
    <script type="text/javascript">
        $(function () {
            $("#remark").val('${entity.remark}');
        });

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
        <li><a href="${pageContext.request.contextPath}/enum/list">枚举管理</a></li>
        <li>枚举编辑</li>
    </ul>
</div>

<div class="formbody">

    <form id="editForm" action="${pageContext.request.contextPath}/enum/save" method="post">
        <input type="hidden" id="id" name="id" value="${id}">
        <ul class="forminfo">
            <li>
                <label>模块</label>
                <input id="catalog" name="catalog" type="text" class="dfinput" value="${entity.catalog}"/>
            </li>
            <li>
                <label>类型</label>
                <input id="type" name="type" type="text" class="dfinput" value="${entity.type}"/>
            </li>
            <li>
                <label>名称</label>
                <input id="name" name="name" type="text" class="dfinput" value="${entity.name}"/>
            </li>
            <li>
                <label>值</label>
                <input id="value" name="value" type="text" class="dfinput" value="${entity.value}"/>
            </li>
            <li>
                <label>排序</label>
                <input id="sort" name="sort" type="text" class="dfinput" value="${entity.sort}"/>
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
