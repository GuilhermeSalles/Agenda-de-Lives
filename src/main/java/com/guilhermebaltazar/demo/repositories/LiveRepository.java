package com.guilhermebaltazar.demo.repositories;

import com.guilhermebaltazar.demo.entities.Live;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LiveRepository extends JpaRepository<Live, Long> {
}
