package com.guilhermebaltazar.demo.repositories;

import com.guilhermebaltazar.demo.entities.Live;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;

@Repository
public interface LiveRepository extends JpaRepository<Live, Long> {

    Page<Live> findByLiveDateAfterOrderByLiveDateAsc(LocalDateTime now, Pageable pageable);

    Page<Live> findByLiveDateBeforeOrderByLiveDateDesc(LocalDateTime now, Pageable pageable);
}
