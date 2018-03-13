<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>registration</title>
</head>
<body>
<form method="post" action="registration">
Enter Name= <input name="name" type="text"><br>
${nameMessage}
Enter Username = <input name="username" type="text"><br>
${unameMessage}
${usernameExists}
Enter password = <input name="password" type="password"><br>
${pwdMessage}
<input type="submit">

</form>
</body>
</html>