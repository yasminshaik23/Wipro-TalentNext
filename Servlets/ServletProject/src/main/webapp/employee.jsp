<%@ page import="com.example.Employee" %>

<jsp:useBean id="employee"
             class="com.example.Employee"
             scope="request" />

<jsp:setProperty name="employee"
                 property="*" />

<!DOCTYPE html>
<html>
<head>
    <title>Employee Information</title>
</head>
<body>

    <h2>Employee Information</h2>

    <p>
        Employee Name:
        <%= employee.getEmployeeName() %>
    </p>

    <p>
        Employee ID:
        <%= employee.getEmployeeID() %>
    </p>

</body>
</html>