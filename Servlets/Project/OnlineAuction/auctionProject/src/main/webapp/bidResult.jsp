<%@ page import="com.example.Bid" %>

<!DOCTYPE html>
<html>
<head>
    <title>Bid Details</title>
</head>

<body>

    <h1>Online Auction - Bid Details</h1>

    <%
        Bid bid = (Bid) request.getAttribute("bid");
    %>

    <h2>Bid Information</h2>

    <p>
        <strong>Item ID:</strong>
        <%= bid.getItemId() %>
    </p>

    <p>
        <strong>Item Name:</strong>
        <%= bid.getItemName() %>
    </p>

    <p>
        <strong>Bidder Name:</strong>
        <%= bid.getBidderName() %>
    </p>

    <p>
        <strong>Email:</strong>
        <%= bid.getEmail() %>
    </p>

    <p>
        <strong>Amount Bid:</strong>
        ₹<%= bid.getBidAmount() %>
    </p>

    <p>
        <strong>Auto Increment:</strong>
        <%= bid.getAutoIncrement() %>
    </p>

</body>
</html>