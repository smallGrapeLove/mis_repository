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
    <title>账务记录</title>
    <%@include file="/WEB-INF/common/header.jsp" %>
    <script type="text/javascript">
        function toAdd() {
            window.location = '${pageContext.request.contextPath}/account/toEdit/0';
        }

        function deleteAccountType() {
            var checkBoxPrefix = "checkBox_account_";
            var checkedData = $("input[id^='" + checkBoxPrefix + "']:checked");
            if (checkedData.length < 1) {
                alert("请选择需要删除得数据！");
            } else {
                var ids = "";
                $.each(checkedData, function (i, v) {
                    var id = $(v).attr("id");
                    ids += id.replace(checkBoxPrefix, "") + ",";
                });
                window.location = '${pageContext.request.contextPath}/account/type/delete?ids=' + ids;
            }
        }

        function query() {
            $("#queryForm").submit();
        }

        $(function () {
            //datepicker回显数据
            $("#accountDate").datepicker('setDate','${paramMap.accountDate}');
        })
    </script>

</head>
<body>

<div class="place">
    <span>位置：</span>
    <ul class="placeul">
        <li>系统管理</li>
        <li><a href="${pageContext.request.contextPath}/account/list">账务记录</a></li>
    </ul>
</div>

<div class="rightinfo">

    <form id="queryForm" action="${pageContext.request.contextPath}/account/list">
        <ul class="seachform">
            <li>
                <label>账务日期</label><input type="text" id="accountDate" name="accountDate" class="scinput datepicker" />
            </li>
            <li>
                <label>&nbsp;</label>
                <input type="button" class="scbtn" value="查询" onclick="query()"/>
            </li>
        </ul>
    </form>

    <div class="tools">

        <ul class="toolbar">
            <li class="click" onclick="toAdd()"><span><img
                    src="${pageContext.request.contextPath}/images/t01.png"/></span>添加
            </li>
        </ul>
    </div>

    <table class="tablelist">
        <thead>
        <tr>
            <th>账务日期</th>
            <th>收入</th>
            <th>支出</th>
            <th>操作</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${dataList}" var="data">
            <tr>
                <td>${data.accountDate}</td>
                <td style="color: green;">${data.inSumPrice}</td>
                <td style="color: red;">${data.outSumPrice}</td>
                <td>
                    <a href="${pageContext.request.contextPath}/account/toEdit/${data.id}" class="tablelink">编辑</a>
                </td>
            </tr>
        </c:forEach>

        </tbody>
    </table>
</div>
</body>
</html>
