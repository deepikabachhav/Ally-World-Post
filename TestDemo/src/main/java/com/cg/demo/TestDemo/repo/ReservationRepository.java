package com.cg.demo.TestDemo.repo;

import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cg.demo.TestDemo.entity.Reservation;
@Repository
public interface ReservationRepository extends JpaRepository<Reservation, Long>{
	Collection<Reservation> findByReservationName(String reservationName);



}
