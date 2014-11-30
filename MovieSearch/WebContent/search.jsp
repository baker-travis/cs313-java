<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Search For Movies</title>
</head>
<body>
<form action="FindMovies" method="POST">
	<label for="movie">Movie: </label>
	<input type="text" name="movie" placeholder="Movie to search for..." />
	<button type="submit">Search</button>
</form>
</body>
</html>