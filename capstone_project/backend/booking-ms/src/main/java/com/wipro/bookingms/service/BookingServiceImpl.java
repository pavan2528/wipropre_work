package com.wipro.bookingms.service;

import com.wipro.bookingms.model.Booking;
import com.wipro.bookingms.model.Passenger;
import com.wipro.bookingms.repository.BookingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BookingServiceImpl implements BookingService {

    @Autowired
    private BookingRepository bookingRepository;

    @Override
    public Booking createBooking(Long flightId, Passenger passenger) {
        Booking booking = new Booking();
        booking.setFlightId(flightId);
        booking.setPassenger(passenger);
        booking.setStatus("initiated");
        return bookingRepository.save(booking);
    }
}