package com.Assignment04.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Assignment04.model.Passenger;

public interface PassengerRepository extends JpaRepository<Passenger, Long>{

}
