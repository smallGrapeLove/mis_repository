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
    <title>枚举列表</title>
    <%@include file="/WEB-INF/common/header.jsp" %>
    <script type="text/javascript">
        function toAdd() {
            window.location = '${pageContext.request.contextPath}/enum/toEdit/0';
        }

        function deleteEnum() {
            var checkBoxPrefix = "checkBox_enum_";
            var checkedData = $("input[id^='" + checkBoxPrefix + "']:checked");
            if (checkedData.length < 1) {
                alert("请选择需要删除得数据！");
            } else {
                var ids = "";
                $.each(checkedData, function (i, v) {
                    var id = $(v).attr("id");
                    ids += id.replace(checkBoxPrefix, "") + ",";
                });
                window.location = '${pageContext.request.contextPath}/enum/delete?ids=' + ids;
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
        <li><a href="${pageContext.request.contextPath}/enum/list">枚举管理</a></li>
    </ul>
</div>

<div class="rightinfo">

    <form id="queryForm" action="${pageContext.request.contextPath}/enum/list">
        <ul class="seachform">
            <li><label>模块</label><input id="catalog" name="catalog" type="text" class="scinput" value="${paramMap.catalog}"/></li>
            <li><label>类型</label><input id="type" name="type" type="text" class="scinput" value="${paramMap.type}"/></li>
            <li><label>名称</label><input id="name" name="name" type="text" class="scinput" value="${paramMap.name}"/></li>
            <li><label>&nbsp;</label><input type="button" class="scbtn" value="查询" onclick="query()"/></li>
        </ul>
    </form>

    <div class="tools">

        <ul class="toolbar">
            <li class="click" onclick="toAdd()"><span><img
                    src="${pageContext.request.contextPath}/images/t01.png"/></span>添加
            </li>
            <li class="click" onclick="deleteEnum()"><span><img
                    src="${pageContext.request.contextPath}/images/t03.png"/></span>删除
            </li>
        </ul>
    </div>

    <table class="tablelist">
        <thead>
        <tr>
            <th style="width: 30px;"></th>
            <th>模块</th>
            <th>类型</th>
            <th>名称</th>
            <th>值</th>
            <th>描述</th>
            <th>操作</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${dataList}" var="data">
            <tr>
                <td>
                    <input id="checkBox_enum_${data.id}" type="checkbox"/>
                </td>
                <td>${data.catalog}</td>
                <td>${data.type}</td>
                <td>${data.name}</td>
                <td>${data.value}</td>
                <td>${data.remark}</td>
                <td>
                    <a href="${pageContext.request.contextPath}/enum/toEdit/${data.id}" class="tablelink">编辑</a>
                </td>
            </tr>
        </c:forEach>

        </tbody>
    </table>
</div>
</body>
</html>
