<%@ page import="java.util.*, com.travel.model.Booking" %>
<!DOCTYPE html>
<html>
<head>
    <title>All Bookings</title>
    <link rel="stylesheet" href="css/styles.css">
</head>
<body>

<div class="container">
    <h2>All Bookings</h2>

    <table>
        <tr>
            <th>ID</th>
            <th>Name</th>
            <th>Destination</th>
            <th>Date</th>
            <th>Price</th>
            <th>Action</th>
        </tr>

<%
List<Booking> list = (List<Booking>) request.getAttribute("bookingList");

if (list != null && !list.isEmpty()) {
    for (Booking b : list) {
%>
        <tr>
            <td><%= b.getBookingId() %></td>
            <td><%= b.getCustomerName() %></td>
            <td><%= b.getDestination() %></td>
            <td><%= b.getTravelDate() %></td>
            <td><%= b.getPackagePrice() %></td>
            <td>
                <a class="btn-edit"
                   href="EditBookingServlet?id=<%= b.getBookingId() %>">
                   Edit
                </a>

                <a class="btn-delete"
                   href="DeleteBookingServlet?id=<%= b.getBookingId() %>">
                   Delete
                </a>
            </td>
        </tr>
<%
    }
} else {
%>
        <tr>
            <td colspan="6">No bookings found.</td>
        </tr>
<%
}
%>

    </table>

    <br>
    <a href="add_booking.jsp" class="btn-main">Add New Booking</a>
</div>

</body>
</html>