package com.travel.servlet;

import java.io.IOException;
import java.text.SimpleDateFormat;

import javax.servlet.*;
import javax.servlet.http.*;

import com.travel.dao.*;
import com.travel.model.Booking;

public class AddBookingServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        try {
            Booking booking = new Booking();

            booking.setCustomerName(request.getParameter("customerName"));
            booking.setDestination(request.getParameter("destination"));

            booking.setTravelDate(
                new SimpleDateFormat("yyyy-MM-dd")
                        .parse(request.getParameter("travelDate"))
            );

            booking.setPackagePrice(
                Double.parseDouble(request.getParameter("packagePrice"))
            );

            BookingDAO dao = new BookingDAOImpl();
            dao.addBooking(booking);

            response.sendRedirect("ViewBookingServlet");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}