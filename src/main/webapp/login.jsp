<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1><%=request.getAttribute("error")%></h1>
<form action="login" method="post">
    Name:<input type="text" name="email"><br>
    Password:<input type="password" name="password"><br>
    <input type="submit" value="login">
</form>
</body>
</html>
