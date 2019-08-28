<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <link rel="stylesheet" href="css/adduser.css">
    <title>Add User</title>
</head>
<body>
    <div class="title">
        <h2>Please enter your employee details</h2>
    </div>
    <div id="block">
        <form action="${pageContext.request.contextPath}/AddDetailsServlet" method="post" id="form">
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
            <div class="gap">
                <div class="left">
                    <label class="labels">Joining Date:</label>
                </div>
                <div class="right">
                    <input type="text" name="joiningdate" id="joindate" class="fields" autocomplete="off">
                </div>
            </div>
            <div class="gap">
                <div class="left">
                    <label class="labels">Salary:</label>
                </div>
                <div class="right">
                    <input type="text" name="salary" id="salary" class="fields" autocomplete="off">
                </div>
            </div>
            <div class="button">
                <input type="submit" value="Add">
            </div>
        </form>
    </div>
</body>
</html>