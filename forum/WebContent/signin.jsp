<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Sign In</title>
</head>
<body>
<form action="SignIn" method="post">
	<label for="username">Username: </label>
	<input type="text" name="username" id="username" />
	<label for="password">Password: </label>
	<input type="password" name="password" id="password" />
	<button type="submit">Sign in</button>
</form>
</body>
</html>