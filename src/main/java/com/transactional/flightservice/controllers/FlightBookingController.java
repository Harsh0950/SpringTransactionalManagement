package com.transactional.flightservice.controllers;

import com.transactional.flightservice.dto.FlightBookingAcknowledgement;
import com.transactional.flightservice.dto.FlightBookingRequest;
import com.transactional.flightservice.services.FlightBookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FlightBookingController {

    @Autowired
    private FlightBookingService flightBookingService;

    @PostMapping("/")
    public FlightBookingAcknowledgement bookFlightTicket(@RequestBody FlightBookingRequest request) {
        return flightBookingService.bookFlightTicket(request);
    }

}
