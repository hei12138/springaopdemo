<%--
  Created by IntelliJ IDEA.
  User: hei123
  Date: 2017/09/28
  Time: 10:26
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>upload page</title>
</head>
<body>
    <div class="upload">
        <form action="upload" enctype="multipart/form-data" method="post">
            <input type="file" name="file"><br/>
            <input type="submit" value="上传">
        </form>
    </div>
</body>
</html>
