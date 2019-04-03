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
            clearAllMes();
            var name = $("#name").val();
            var catalog = $("#catalog").val();
            var type = $("#type").val();
            var value = $("#value").val();
            var sort = $("#sort").val();

            var submitFlag = true;
            if (name == '') {
                $("#b_name").html('名称不能为空');
                submitFlag = false;
            }
            if (catalog == '') {
                $("#b_catalog").html('模块不能为空');
                submitFlag = false;
            }
            if (type == '') {
                $("#b_type").html('类型不能为空');
                submitFlag = false;
            }
            if (value == '') {
                $("#b_value").html('值不能为空');
                submitFlag = false;
            }
            if (sort == '') {
                $("#b_sort").html('排序不能为空');
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
        <li><a href="${pageContext.request.contextPath}/enum/list">枚举管理</a></li>
        <li>枚举编辑</li>
    </ul>
</div>

<div class="formbody">

    <form id="editForm" action="${pageContext.request.contextPath}/enum/save" method="post">
        <input type="hidden" id="id" name="id" value="${id}">
        <ul class="forminfo">
            <li>
                <label>模块<b>*</b></label>
                <input id="catalog" name="catalog" type="text" class="dfinput" value="${entity.catalog}"/>
                <b id="b_catalog"></b>
            </li>
            <li>
                <label>类型<b>*</b></label>
                <input id="type" name="type" type="text" class="dfinput" value="${entity.type}"/>
                <b id="b_type"></b>
            </li>
            <li>
                <label>名称<b>*</b></label>
                <input id="name" name="name" type="text" class="dfinput" value="${entity.name}"/>
                <b id="b_name"></b>
            </li>
            <li>
                <label>值<b>*</b></label>
                <input id="value" name="value" type="text" class="dfinput" value="${entity.value}"/>
                <b id="b_value"></b>
            </li>
            <li>
                <label>排序<b>*</b></label>
                <input id="sort" name="sort" type="text" class="dfinput" value="${entity.sort}"/>
                <b id="b_sort"></b>
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
