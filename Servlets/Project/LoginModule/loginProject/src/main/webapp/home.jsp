<!DOCTYPE html>
<html>
<head>
    <title>Home</title>
</head>

<body>

    <h1>Welcome : <%= request.getAttribute("username") %></h1>

    <br>

    <a href="changePassword.html">Change Password</a>

    <br><br>

    <a href="login.jsp">Logout</a>

</body>
</html>