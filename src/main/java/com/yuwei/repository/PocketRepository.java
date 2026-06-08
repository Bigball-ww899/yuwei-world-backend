package com.yuwei.repository;

import com.yuwei.entity.Pocket;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PocketRepository
        extends JpaRepository<Pocket, Long> {

}