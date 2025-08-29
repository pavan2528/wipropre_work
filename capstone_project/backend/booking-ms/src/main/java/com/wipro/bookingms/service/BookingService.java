package com.wipro.bookingms.service;

import com.wipro.bookingms.model.Booking;
import com.wipro.bookingms.model.Passenger;

public interface BookingService {
    Booking createBooking(Long flightId, Passenger passenger);
}