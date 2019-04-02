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
    <title>角色菜单权限配置</title>
    <%@include file="/WEB-INF/common/header.jsp" %>
    <script type="text/javascript">

        function submitForm() {
            $("#editForm").submit();
        }

        /**
         * 角色变动
         * @param o
         */
        function changeRole(o) {
            var roleId=$(o).val();
            $("#menuDataDiv").html('');
            if(roleId!=''){
                var menuData=getMenuData(roleId);
                //开始渲染数据，回显菜单
                var data={
                    menuDataList:menuData
                };
                addMenuData(data);
            }
        }

        /**
         * 渲染菜单数据
         * */
        function getMenuData(roleId) {
            var menuData;
            $.ajax({
                url: "${pageContext.request.contextPath}/menu/menu-role/getMenuData",
                data: {roleId: roleId},
                type: 'post',
                dataType: 'json',
                async: false,
                success: function (result) {
                    menuData = result;
                }
            });
            return menuData;
        }

        /**
         * juicer渲染菜单
         */
        function addMenuData(data) {
            var trTemplage = document.getElementById('menuDataTemplate').innerHTML;
            var html = juicer(trTemplage, data);
            $("#menuDataDiv").append(html);
        }

        /**
         * 第一层菜单
         */
        function checkFirst(o){
            checkChildren(o);
        }

        /**
         * 选中第二层菜单
         * @param o
         */
        function checkSecond(o) {
            //选中子节点
            checkChildren(o);
            //判断是否需要选中父节点
            checkParent(o);
        }

        /**
         * 点击第三层菜单
         * */
        function checkThire(o) {
            checkParent(o);
        }

        /**
         * 判断是否需要选中父节点
         * */
        function checkParent(o) {
            var parentId=$(o).attr("parentId");
            if(parentId!=undefined){
                var parent=$("input[menuId="+parentId+"]");
                var flag=false;
                $.each($("input[parentId="+parentId+"]"),function (i, v) {
                    if($(v).is(':checked')){
                        flag=true;
                    }
                });
                if(flag){
                    $(parent).prop("checked","checked");
                    checkParent(parent);
                }else{
                    $(parent).removeAttr("checked");
                    checkParent(parent);
                }
            }
        }

        /**
         * 选中子节点和父节点
         * @param o
         */
        function checkChildren(o){
            var flag=$(o).is(':checked');
            var id=$(o).attr('id');
            $.each($('input[id^='+id+']'),function (i, v) {
                if(flag){
                    $(v).prop("checked","checked");
                }else {
                    $(v).removeAttr("checked");
                }
            })
        }
    </script>
</head>
<body>

<div class="place">
    <span>位置：</span>
    <ul class="placeul">
        <li>系统管理</li>
        <li>角色菜单权限配置</li>
    </ul>
</div>

<div class="formbody">

    <form id="editForm" action="${pageContext.request.contextPath}/menu/menu-role/save" method="post">
        <input type="hidden" id="id" name="id" value="${id}">
        <div class="formtitle"><span>角色信息</span></div>
        <ul class="forminfo">
            <li>
                <label>角色</label>
                <div class="vocation">
                    <select class="select1" id="roleId" name="roleId" onchange="changeRole(this)">
                        <option value="">请选择</option>
                        <c:forEach items="${roleList}" var="role">
                            <option value="${role.id}">${role.name}</option>
                        </c:forEach>
                    </select>
                </div>
            </li>

        </ul>
        <div style="height: 50px;"></div>
        <div class="formtitle"><span>菜单信息</span></div>
        <ul class="forminfo">
            <div id="menuDataDiv" style="padding-left: 86px;">

            </div>

            <li>
                <label>&nbsp;</label>
                <input id="saveBtn" type="button" class="btn" onclick="submitForm()" value="确认保存"/>
            </li>
        </ul>
    </form>

</div>

<script type="text/template" id="menuDataTemplate">
    <li>
        {@each menuDataList as fMenu}
            {@if fMenu.fMenu.hasPrivilege==='true'}
                <input type="checkbox" id="checkBox_{{fMenu.fMenu.id}}" onclick="checkFirst(this)" menuId="{{fMenu.fMenu.id}}" checked/>{{fMenu.fMenu.name}}
            {@else}
                <input type="checkbox" id="checkBox_{{fMenu.fMenu.id}}" onclick="checkFirst(this)" menuId="{{fMenu.fMenu.id}}"/>{{fMenu.fMenu.name}}
            {@/if}
            <br/>
            <br/>
                {@each fMenu.fChildren as sMenu}
                    {@if sMenu.sMenu.hasPrivilege==='true'}
                            &nbsp;&nbsp;&nbsp;&nbsp;<input type="checkbox" id="checkBox_{{fMenu.fMenu.id}}_{{sMenu.sMenu.id}}" onclick="checkSecond(this)" parentId="{{sMenu.sMenu.parentId}}" menuId="{{sMenu.sMenu.id}}" checked/>{{sMenu.sMenu.name}}<br/><br/>
                    {@else}
                        &nbsp;&nbsp;&nbsp;&nbsp;<input type="checkbox" id="checkBox_{{fMenu.fMenu.id}}_{{sMenu.sMenu.id}}" onclick="checkSecond(this)" parentId="{{sMenu.sMenu.parentId}}" menuId="{{sMenu.sMenu.id}}" />{{sMenu.sMenu.name}}<br/><br/>
                    {@/if}
                    {@each sMenu.sChildren as tMenu}
                        {@if tMenu.hasPrivilege==='true'}
                            &nbsp;&nbsp; &nbsp;&nbsp;&nbsp;&nbsp;<input type="checkbox" id="checkBox_{{fMenu.fMenu.id}}_{{sMenu.sMenu.id}}_{{tMenu.id}}" parentId="{{tMenu.parentId}}" onclick="checkThire(this)" checked/>{{tMenu.name}}
                        {@else}
                            &nbsp;&nbsp; &nbsp;&nbsp;&nbsp;&nbsp;<input type="checkbox" id="checkBox_{{fMenu.fMenu.id}}_{{sMenu.sMenu.id}}_{{tMenu.id}}" parentId="{{tMenu.parentId}}" onclick="checkThire(this)" />{{tMenu.name}}
                        {@/if}
                    {@/each}
                     <br/>
                     <br/>
                {@/each}
        {@/each}
    </li>

</script>
</body>
</html>
