package com.travel.dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import com.travel.model.Booking;
import com.travel.util.DBConnection;

public class BookingDAOImpl implements BookingDAO {

    @Override
    public void addBooking(Booking booking) throws Exception {
        String sql = "INSERT INTO bookings (customername, destination, traveldate, packageprice) VALUES (?, ?, ?, ?)";

        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, booking.getCustomerName());
            ps.setString(2, booking.getDestination());
            ps.setDate(3, new java.sql.Date(booking.getTravelDate().getTime()));
            ps.setDouble(4, booking.getPackagePrice());

            ps.executeUpdate();
        }
    }

    @Override
    public List<Booking> getAllBookings() throws Exception {
        List<Booking> list = new ArrayList<>();
        String sql = "SELECT * FROM bookings";

        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                Booking booking = new Booking();
                booking.setBookingId(rs.getInt("bookingid"));
                booking.setCustomerName(rs.getString("customername"));
                booking.setDestination(rs.getString("destination"));
                booking.setTravelDate(rs.getDate("traveldate"));
                booking.setPackagePrice(rs.getDouble("packageprice"));

                list.add(booking);
            }
        }

        return list;
    }

    @Override
    public Booking getBookingById(int id) throws Exception {
        String sql = "SELECT * FROM bookings WHERE bookingid = ?";
        Booking booking = null;

        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, id);

            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    booking = new Booking();
                    booking.setBookingId(rs.getInt("bookingid"));
                    booking.setCustomerName(rs.getString("customername"));
                    booking.setDestination(rs.getString("destination"));
                    booking.setTravelDate(rs.getDate("traveldate"));
                    booking.setPackagePrice(rs.getDouble("packageprice"));
                }
            }
        }

        return booking;
    }

    @Override
    public void updateBooking(Booking booking) throws Exception {
        String sql = "UPDATE bookings SET customername=?, destination=?, traveldate=?, packageprice=? WHERE bookingid=?";

        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, booking.getCustomerName());
            ps.setString(2, booking.getDestination());
            ps.setDate(3, new java.sql.Date(booking.getTravelDate().getTime()));
            ps.setDouble(4, booking.getPackagePrice());
            ps.setInt(5, booking.getBookingId());

            ps.executeUpdate();
        }
    }

    @Override
    public void deleteBooking(int id) throws Exception {
        String sql = "DELETE FROM bookings WHERE bookingid=?";

        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, id);
            ps.executeUpdate();
        }
    }
}