package com.travel.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.*;
import javax.servlet.http.*;

import com.travel.dao.*;
import com.travel.model.Booking;

public class ViewBookingServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        try {
            BookingDAO dao = new BookingDAOImpl();
            List<Booking> list = dao.getAllBookings();

            request.setAttribute("bookingList", list);

            RequestDispatcher rd =
                    request.getRequestDispatcher("view_bookings.jsp");
            rd.forward(request, response);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}