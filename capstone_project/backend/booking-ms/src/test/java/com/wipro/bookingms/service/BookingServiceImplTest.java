package com.wipro.bookingms.service;

import com.wipro.bookingms.model.Booking;
import com.wipro.bookingms.model.Passenger;
import com.wipro.bookingms.repository.BookingRepository;
import com.wipro.bookingms.repository.PassengerRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class BookingServiceImplTest {

    @Mock
    private BookingRepository bookingRepository;

    @Mock
    private PassengerRepository passengerRepository;

    @InjectMocks
    private BookingServiceImpl bookingService;

    @Test
    public void testCreateBooking() {
        Passenger passenger = new Passenger();
        Passenger savedPassenger = new Passenger();
        savedPassenger.setId(1L);
        when(passengerRepository.save(passenger)).thenReturn(savedPassenger);

        Booking booking = new Booking();
        booking.setId(1L);
        booking.setStatus("initiated");
        when(bookingRepository.save(booking)).thenReturn(booking);

        Booking result = bookingService.createBooking(1L, passenger);
        assertEquals("initiated", result.getStatus());
    }
}