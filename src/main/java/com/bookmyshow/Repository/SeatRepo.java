package com.bookmyshow.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bookmyshow.entity.Seat;

public interface SeatRepo extends JpaRepository<Seat, Long>{

}
