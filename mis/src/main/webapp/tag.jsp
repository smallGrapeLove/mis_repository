<%--
  Created by IntelliJ IDEA.
  User: huan.xu
  Date: 2019/3/1
  Time: 14:45
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>自定义标签</title>
    <%--<%@include file="/WEB-INF/common/header.jsp" %>--%>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/jquery-ui.css">
    <script src="${pageContext.request.contextPath}/js/jquery-1.8.0.min.js"></script>
    <script src="${pageContext.request.contextPath}/js/jquery-ui.js"></script>
    <link rel="stylesheet" href="http://jqueryui.com/resources/demos/style.css">
    <script>
        $(function () {
            var availableTags = [
                "ActionScript",
                "AppleScript",
                "Asp",
                "BASIC",
                "C",
                "C++",
                "Clojure",
                "COBOL",
                "ColdFusion",
                "Erlang",
                "Fortran",
                "Groovy",
                "Haskell",
                "Java",
                "JavaScript",
                "Lisp",
                "Perl",
                "PHP",
                "Python",
                "Ruby",
                "Scala",
                "Scheme"
            ];
            $("#tags").autocomplete({
                source: availableTags
            });
        });
    </script>
</head>
<body>

<div class="ui-widget">
    <label for="tags">标签：</label>
    <input id="tags">
</div>


</body>
</html>
