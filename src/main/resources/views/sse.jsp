<%--
  Created by IntelliJ IDEA.
  User: hei123
  Date: 2017/09/30
  Time: 11:58
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>服务器向客户端推送数据</title>
</head>
<body>

<div id="msgFromPush"></div>
<script type="text/javascript" src="/assets/jquery-3.2.1.min.js"></script>
<script>
    if(!!window.EventSource){
        var source = new EventSource("push");
        var s='';
        source.addEventListener('message',function (e) {
            s+=e.data+"<br/>";
            $("#msgFromPush").html(s);
        });
        source.addEventListener("open",function (e) {
            console.log("连接打开");
        },false);
        source.addEventListener("error",function (e) {
            if(e.readyState==EventSource.CLOSED){
                console.log("连接关闭");
            }else{
                console.log(e.readyState);
            }
        },false);
    }else{
        console.log("不支持sse");
    }
</script>
</body>
</html>
