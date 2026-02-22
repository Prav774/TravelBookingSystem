package com.travel.servlet;

import java.io.IOException;

import javax.servlet.*;
import javax.servlet.http.*;

import com.travel.dao.*;
import com.travel.model.Booking;

public class EditBookingServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        try {
            int id = Integer.parseInt(request.getParameter("id"));

            BookingDAO dao = new BookingDAOImpl();
            Booking booking = dao.getBookingById(id);

            request.setAttribute("booking", booking);

            RequestDispatcher rd =
                    request.getRequestDispatcher("update_booking.jsp");
            rd.forward(request, response);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}