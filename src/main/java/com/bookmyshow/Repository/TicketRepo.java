package com.bookmyshow.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bookmyshow.entity.Tickets;

public interface TicketRepo extends JpaRepository<Tickets, Long>{

}
