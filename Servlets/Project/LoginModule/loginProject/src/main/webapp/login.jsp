<!DOCTYPE html>
<html>
<head>
    <title>Login</title>
</head>

<body>

    <h1>Login</h1>

    <%
        String error = (String) request.getAttribute("error");

        if (error != null) {
    %>

        <p><%= error %></p>

    <%
        }
    %>

    <form action="login" method="post">

        <label>Username:</label>
        <input type="text" name="username" required>

        <br><br>

        <label>Password:</label>
        <input type="password" name="password" required>

        <br><br>

        <input type="submit" value="Login">

    </form>

    <br>

    <a href="register.html">New User</a>

    <br><br>

    <a href="changePassword.html">Change Password</a>

</body>
</html>