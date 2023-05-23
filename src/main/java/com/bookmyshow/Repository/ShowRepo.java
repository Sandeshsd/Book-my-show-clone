package com.bookmyshow.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bookmyshow.entity.Show;

public interface ShowRepo extends JpaRepository<Show, Long>{

}
