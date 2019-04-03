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
    <title>账务类型编辑</title>
    <%@include file="/WEB-INF/common/header.jsp" %>
    <script type="text/javascript">
        function submitForm() {
            clearAllMes();
            var name=$("#name").val();
            var type=$("#type").val();
            var submitFlag = true;

            if (name == '') {
                $("#b_name").html('账务类型名称不能为空');
                submitFlag = false;
            }
            if (type == '') {
                $("#b_type").html('请选择出入帐类型');
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
        <li><a href="${pageContext.request.contextPath}/account/type/list">账务类型管理</a></li>
        <li>账务类型编辑</li>
    </ul>
</div>

<div class="formbody">

    <form id="editForm" action="${pageContext.request.contextPath}/account/type/save" method="post">
        <input type="hidden" id="id" name="id" value="${id}">
        <ul class="forminfo">
            <li>
                <label>账务类型名称<b>*</b></label>
                <input id="name" name="name" type="text" class="dfinput" value="${accountType.name}"/>
                <b id="b_name"></b>
            </li>
            <li>
                <label>出入账类型<b>*</b></label>
                <div class="vocation" style="float: left;">
                    <select class="select1" id="type" name="type">
                        <option value="">请选择</option>
                        <c:forEach items="${accountTypeEnumList}" var="accountTypeEnum">
                            <c:choose>
                                <c:when test="${accountTypeEnum.value eq accountType.type}">
                                    <option value="${accountTypeEnum.value}" selected>${accountTypeEnum.name}</option>
                                </c:when>
                                <c:otherwise>
                                    <option value="${accountTypeEnum.value}">${accountTypeEnum.name}</option>
                                </c:otherwise>
                            </c:choose>

                        </c:forEach>
                    </select>
                </div>
                <b id="b_type" style="float: left;"></b>
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
