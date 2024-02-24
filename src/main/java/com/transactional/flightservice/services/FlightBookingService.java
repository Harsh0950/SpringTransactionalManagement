package com.transactional.flightservice.services;

import com.transactional.flightservice.Utils.PaymentUtils;
import com.transactional.flightservice.dto.FlightBookingAcknowledgement;
import com.transactional.flightservice.dto.FlightBookingRequest;
import com.transactional.flightservice.entities.PassengerInfo;
import com.transactional.flightservice.entities.PaymentInfo;
import com.transactional.flightservice.repositories.PasssengerInfoRepository;
import com.transactional.flightservice.repositories.PaymentInfoRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class FlightBookingService {

    @Autowired
    private PasssengerInfoRepository passengerInfoRepository;

    @Autowired
    private PaymentInfoRepository paymentInfoRepository;

    @Transactional
    public FlightBookingAcknowledgement bookFlightTicket(FlightBookingRequest request) {
        PassengerInfo passengerInfo = request.getPassengerInfo();
        passengerInfo = passengerInfoRepository.save(passengerInfo);

        PaymentInfo paymentInfo = request.getPaymentInfo();
        PaymentUtils.validateCreditLimit(paymentInfo.getAccountNo(),passengerInfo.getFare());

        paymentInfo.setPassengerId(passengerInfo.getId());
        paymentInfo.setAmount(passengerInfo.getFare());

        paymentInfoRepository.save(paymentInfo);
        return new FlightBookingAcknowledgement("SUCCESS",passengerInfo.getFare(), UUID.randomUUID().toString(),passengerInfo);

    }

}
