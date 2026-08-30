<!DOCTYPE html>
<html>

<head>
    <title>Home</title>
</head>

<body>

<center>

    <h2>
        Welcome : <%= request.getParameter("userid") %>
    </h2>

    <br>

    <a href="changePassword.html">
        Change Password
    </a>

</center>

</body>

</html>