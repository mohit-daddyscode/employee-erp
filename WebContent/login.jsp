<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="css/login.css" type="text/css">
<link rel="shortcut icon" href="img/favicon.png" type="image/png">
<title>Admin Login</title>
</head>
<body>
	<div class="title">
        <h2>Please enter your login credentials</h2>
    </div>
    <div id="block">
        <form action="LoginServlet" method="post" id="form">
            <div class="gap">
                <div class="left">
                    <label class="labels">Username:</label>
                </div>
                <div class="right">
                    <input type="text" name="username" id="uname" class="fields" autocomplete="off">
                </div>
            </div>
            <div class="gap">
                <div class="left">
                    <label class="labels">Password:</label>
                </div>
                <div class="right">
                    <input type="password" name="password" id="pwd" class="fields"><br>
                </div>
            </div>
            <div class="button">
                <input type="submit" value="Login">
            </div>
        </form>
    </div>
</body>
</html>