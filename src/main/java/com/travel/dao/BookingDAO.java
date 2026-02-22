package com.travel.dao;

import java.util.List;
import com.travel.model.Booking;

public interface BookingDAO {

    void addBooking(Booking booking) throws Exception;

    List<Booking> getAllBookings() throws Exception;

    Booking getBookingById(int id) throws Exception;

    void updateBooking(Booking booking) throws Exception;

    void deleteBooking(int id) throws Exception;
}