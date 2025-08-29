package com.wipro.bookingms.service;

import com.wipro.bookingms.model.Booking;
import com.wipro.bookingms.model.Passenger;
import com.wipro.bookingms.repository.BookingRepository;
import com.wipro.bookingms.repository.PassengerRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BookingServiceImpl implements BookingService {

    @Autowired
    private BookingRepository bookingRepository;

    @Autowired
    private PassengerRepository passengerRepository;
    
    @Override
    public Booking createBooking(Long flightId, Passenger passenger) {
        Passenger savedPassenger = passengerRepository.save(passenger);

        Booking booking = new Booking();
        booking.setFlightId(flightId);
        booking.setPassenger(savedPassenger);
        booking.setStatus("initiated");
        return bookingRepository.save(booking);
    }
}