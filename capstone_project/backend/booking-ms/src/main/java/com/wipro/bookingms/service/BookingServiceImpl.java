package com.wipro.bookingms.service;

import com.wipro.bookingms.model.Booking;
import com.wipro.bookingms.model.Passenger;
import com.wipro.bookingms.repository.BookingRepository;
import com.wipro.bookingms.repository.PassengerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import java.util.Map;
import java.util.Optional;

@Service
public class BookingServiceImpl implements BookingService {

    @Autowired
    private BookingRepository bookingRepository;

    @Autowired
    private PassengerRepository passengerRepository;

    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;

    @Override
    public Booking createBooking(Long flightId, Passenger passenger) {
        Passenger savedPassenger = passengerRepository.save(passenger);
        Booking booking = new Booking();
        booking.setFlightId(flightId);
        booking.setPassenger(savedPassenger);
        booking.setStatus("initiated");
        return bookingRepository.save(booking);
    }

    @Override
    public void initiatePayment(Long bookingId, Map<String, Object> paymentDetails) {
        Optional<Booking> optionalBooking = bookingRepository.findById(bookingId);
        if (optionalBooking.isPresent()) {
            Booking booking = optionalBooking.get();
            booking.setStatus("pending");
            bookingRepository.save(booking);

            // Produce to T1 (format matching your Payment MS)
            String message = "Booking ID: " + bookingId +
                             ", Amount: " + paymentDetails.get("amount") +
                             ", Method: " + paymentDetails.get("method") +
                             ", Card Number: " + paymentDetails.get("cardNumber") +
                             ", Card Holder: " + paymentDetails.get("nameOnCard") +
                             ", Expiry Date: " + paymentDetails.get("expiryMonth") + "/" + paymentDetails.get("expiryYear") +
                             ", CVV: " + paymentDetails.get("cvv");
            kafkaTemplate.send("T1", message);
        }
    }

    @KafkaListener(topics = "T2", groupId = "booking-group")
    public void updateStatusFromT2(String message) {
        // Parse message from T2 (format: "Booking ID: 1, Status: successful")
        String[] parts = message.split(",");
        Long bookingId = Long.parseLong(parts[0].split(":")[1].trim());
        String status = parts[1].split(":")[1].trim();

        Optional<Booking> optionalBooking = bookingRepository.findById(bookingId);
        if (optionalBooking.isPresent()) {
            Booking booking = optionalBooking.get();
            booking.setStatus(status);
            bookingRepository.save(booking);
        }
    }

    @Override
    public Booking getBookingById(Long id) {
        return bookingRepository.findById(id).orElse(null);
    }

    @Override
    public String getBookingStatus(Long id) {
        return bookingRepository.findById(id).map(Booking::getStatus).orElse(null);
    }
}