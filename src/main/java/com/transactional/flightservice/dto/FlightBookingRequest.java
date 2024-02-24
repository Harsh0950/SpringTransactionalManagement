package com.transactional.flightservice.dto;

import com.transactional.flightservice.entities.PassengerInfo;
import com.transactional.flightservice.entities.PaymentInfo;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class FlightBookingRequest {
    private PassengerInfo passengerInfo;
    private PaymentInfo paymentInfo;
}
