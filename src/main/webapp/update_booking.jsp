<!DOCTYPE html>
<html>
<head>
    <title>Add Booking</title>
    <link rel="stylesheet" href="css/styles.css">
</head>
<body>

<div class="container">
    <h2>Add Travel Booking</h2>

    <form action="AddBookingServlet" method="post">
        Customer Name:
        <input type="text" name="customerName" required>

        Destination:
        <input type="text" name="destination" required>

        Travel Date:
        <input type="date" name="travelDate" required>

        Package Price:
        <input type="number" name="packagePrice" required>

        <input type="submit" value="Add Booking">
    </form>

    <br>
    <a href="ViewBookingServlet">View All Bookings</a>
</div>

</body>
</html>