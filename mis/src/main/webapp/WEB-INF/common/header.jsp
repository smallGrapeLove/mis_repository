<%--
  Created by IntelliJ IDEA.
  User: huan.xu
  Date: 2019/2/27
  Time: 15:57
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/style.css"/>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/select.css"/>

<script type='text/javascript' src='${pageContext.request.contextPath}/js/juicer-min.js'></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-1.8.0.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery.idTabs.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/select-ui.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/plugins/editor/kindeditor.js"></script>

<script type="text/javascript">
    juicer.set({
        'tag::operationOpen': '{@',
        'tag::operationClose': '}',
        'tag::interpolateOpen': '{{',
        'tag::interpolateClose': '}}',
        'tag::noneencodeOpen': '{{{',
        'tag::noneencodeClose': '}}}',
        'tag::commentOpen': '{#',
        'tag::commentClose': '}'
    });

    $(document).ready(function (e) {
        $(".select1").uedSelect({
            width: 345
        });
        $(".select2").uedSelect({
            width: 167
        });
        $(".select3").uedSelect({
            width: 100
        });
    });
</script>