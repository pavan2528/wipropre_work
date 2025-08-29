package com.wipro.bookingms.controller;

import com.wipro.bookingms.model.Booking;
import com.wipro.bookingms.model.Passenger;
import com.wipro.bookingms.service.BookingService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/booking")
@Tag(name = "Booking API", description = "Endpoints for booking management")
public class BookingController {

    @Autowired
    private BookingService bookingService;

    @PostMapping("/create")
    @Operation(summary = "Create a booking with user details")
    public ResponseEntity<Booking> createBooking(@RequestParam Long flightId, @RequestBody Passenger passenger) {
        Booking booking = bookingService.createBooking(flightId, passenger);
        return ResponseEntity.ok(booking);
    }
}