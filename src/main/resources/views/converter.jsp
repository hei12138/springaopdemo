<%--
  Created by IntelliJ IDEA.
  User: hei123
  Date: 2017/09/30
  Time: 11:43
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>自定义的消息</title>
</head>
<body>
<div id="resp">
    <input type="button" onclick="req();" value="请求">
</div>
<script src="/assets/jquery-3.2.1.min.js" type="text/javascript"></script>
<script>
    function req() {
        $.ajax({
            url:"convert",
            data:"1-lishencai",
            type:"POST",
            contentType:"application/x-wisely",
            success:function (data) {
                $("#resp").html(data);
            }
        })
    }
</script>
</body>
</html>
