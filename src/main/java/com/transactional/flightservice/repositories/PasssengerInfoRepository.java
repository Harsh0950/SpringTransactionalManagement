package com.transactional.flightservice.repositories;

import com.transactional.flightservice.entities.PassengerInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PasssengerInfoRepository extends JpaRepository<PassengerInfo,Long> {
}
