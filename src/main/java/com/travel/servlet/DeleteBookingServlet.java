package com.travel.servlet;

import java.io.IOException;

import javax.servlet.*;
import javax.servlet.http.*;

import com.travel.dao.*;

public class DeleteBookingServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        try {
            int id = Integer.parseInt(request.getParameter("id"));

            BookingDAO dao = new BookingDAOImpl();
            dao.deleteBooking(id);

            response.sendRedirect("ViewBookingServlet");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}