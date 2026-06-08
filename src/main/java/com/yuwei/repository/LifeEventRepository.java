package com.yuwei.repository;

import com.yuwei.entity.LifeEvent;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;

public interface LifeEventRepository extends JpaRepository<LifeEvent, Long> {

    List<LifeEvent> findByEventDateAfterOrderByEventDateDesc(LocalDate startDate);

}