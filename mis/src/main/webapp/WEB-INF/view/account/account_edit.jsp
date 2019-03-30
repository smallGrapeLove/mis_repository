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
    <title>账务记录编辑</title>
    <%@include file="/WEB-INF/common/header.jsp" %>
    <script type="text/javascript">

        var in_index = 0;
        var out_index = 0;

        function submitForm() {
            $("#editForm").submit();
        }

        function getAccountType(type) {
            var selectOption;
            $.ajax({
                url: "${pageContext.request.contextPath}/account/getAccountType",
                data: {type: type},
                type: 'post',
                dataType: 'json',
                async: false,
                success: function (result) {
                    selectOption = result;

                }
            });
            return selectOption;
        }

        function addIn() {
            var selectOption = getAccountType('2');
            var data = {
                index: in_index,
                type: "in",
                selectOption: selectOption
            };

            addTr("body_in", data);
            in_index++;
            $(".select2").uedSelect({
                width: 167
            });

        }

        function addOut() {
            var selectOption = getAccountType('1');
            var data = {
                index: out_index,
                type: "out",
                selectOption: selectOption
            };

            addTr("body_out", data);
            out_index++;
            $(".select2").uedSelect({
                width: 167
            });
        }

        function addTr(bodyId, data) {
            var trTemplage = document.getElementById('body_content').innerHTML;
            var html = juicer(trTemplage, data);
            $("#" + bodyId).append(html);
        }

        function deleteRow(o) {
            $(o).parent().parent().remove();
        }

        $(function () {
            if ('${inDetailList}' != '') {
                var inDetailList = $.parseJSON('${inDetailList}');
                var selectOption = getAccountType('2');
                $.each(inDetailList, function (i, v) {
                    v['index'] = in_index;
                    v['selectOption'] = selectOption;
                    addTr("body_in", v);
                    in_index++;
                    $(".select2").uedSelect({
                        width: 167
                    });
                });
            }

            if ('${outDetailList}' != '') {
                var outDetailList = $.parseJSON('${outDetailList}');
                var selectOption = getAccountType('1');
                $.each(outDetailList, function (i, v) {
                    v['index'] = out_index;
                    v['selectOption'] = selectOption;
                    addTr("body_out", v);
                    out_index++;
                    $(".select2").uedSelect({
                        width: 167
                    });
                });
            }
        });
    </script>
</head>
<body>

<div class="place">
    <span>位置：</span>
    <ul class="placeul">
        <li>系统管理</li>
        <li><a href="${pageContext.request.contextPath}/account/list">账务记录管理</a></li>
        <li>账务类型编辑</li>
    </ul>
</div>

<div class="formbody">

    <form id="editForm" action="${pageContext.request.contextPath}/account/save" method="post">
        <input type="hidden" id="id" name="id" value="${id}">
        <div class="formtitle"><span>基本信息</span></div>
        <ul class="forminfo">
            <li>
                <label>账务日期</label>
                <c:choose>
                    <c:when test="${id == 0}">
                        <input id="accountDate" name="accountDate" type="text" class="dfinput" />
                    </c:when>
                    <c:otherwise>
                        <input id="accountDate" name="accountDate" type="text" class="dfinput"
                               value="${accountApply.year}-${accountApply.month}-${accountApply.day}"/>
                    </c:otherwise>
                </c:choose>
                <i style="color: red;">格式为：yyyy-MM-dd 例如：2019-3-6</i></li>

            </li>

        </ul>
        <div class="formtitle"><span>收入</span></div>
        <div class="tools">
            <ul class="toolbar">
                <li class="click" onclick="addIn()">
                    <span></span>
                    添加
                </li>
            </ul>
        </div>

        <table class="tablelist" style="width: 687px;">
            <thead>
            <tr>
                <th style="width: 187px;">收入类型</th>
                <th style="width: 170px;">金额</th>
                <th style="width: 270px;">描述</th>
                <th style="width: 50px;">操作</th>
            </tr>
            </thead>
            <tbody id="body_in">
            </tbody>
        </table>
        <div class="formtitle"><span>支出</span></div>
        <div class="tools">
            <ul class="toolbar">
                <li class="click" onclick="addOut()">
                    <span></span>
                    添加
                </li>
                <li class="click" onclick="">
                    <span></span>
                    删除
                </li>
            </ul>
        </div>

        <table class="tablelist" style="width: 687px;">
            <thead>
            <tr>
                <th style="width: 187px;">支出类型</th>
                <th style="width: 170px;">金额</th>
                <th style="width: 270px;">描述</th>
                <th style="width: 50px;">操作</th>
            </tr>
            </thead>
            <tbody id="body_out">
            </tbody>
        </table>
        <ul class="forminfo">
            <li>

            </li>
            <li>
                <label>&nbsp;</label>
                <input id="saveBtn" type="button" class="btn" onclick="submitForm()" value="确认保存"/>
            </li>
        </ul>
    </form>

</div>

<script type="text/template" id="body_content">
    <tr>
        <td>
            <div class="vocation" style="padding-top: 12px;padding-left: 12px;">
                <select class="select2" id="type_{{type}}_{{index}}" name="type_{{type}}_{{index}}">
                    <option value="">请选择{{typeId}}</option>
                    {@each selectOption as option}
                        {@if typeId===option.id}
                            <option value="{{option.id}}" selected>{{option.name}}</option>
                        {@else}
                            <option value="{{option.id}}">{{option.name}}</option>
                        {@/if}

                    {@/each}
                </select>
            </div>
        </td>
        <td>
            <input id="price_{{type}}_{{index}}" name="price_{{type}}_{{index}}" type="text" class="scinput" value="{{price}}"/>
        </td>
        <td>
            <input id="remark_{{type}}_{{index}}" name="remark_{{type}}_{{index}}" type="text" class="scinput" value="{{remark}}"
                   style="width: 250px;"/>
        </td>
        <td>
            <input type="hidden" name="hidden_{{type}}" value="{{index}}">
            <a href="javascript:void(0)" class="tablelink" onclick="deleteRow(this)">删除</a>
        </td>
    </tr>
</script>
</body>
</html>
