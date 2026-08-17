<%@ page import="com.example.Employee1" %>

<jsp:useBean id="employee"
             class="com.example.Employee1"
             scope="request" />

<jsp:setProperty name="employee"
                 property="*" />

<!DOCTYPE html>
<html>
<head>
    <title>Employee Details</title>
</head>
<body>

    <h2>Employee Details</h2>

    <p>
        <b>Name:</b>
        <%= employee.getName() %>
    </p>

    <p>
        <b>ID:</b>
        <%= employee.getId() %>
    </p>

    <p>
        <b>Designation:</b>
        <%= employee.getDesignation() %>
    </p>

    <form action="insertEmployee" method="post">

        <input type="hidden"
               name="name"
               value="<%= employee.getName() %>">

        <input type="hidden"
               name="id"
               value="<%= employee.getId() %>">

        <input type="hidden"
               name="designation"
               value="<%= employee.getDesignation() %>">

        <input type="submit" value="Save Employee">

    </form>

</body>
</html>