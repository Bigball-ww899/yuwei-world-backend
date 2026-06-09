package com.yuwei.repository;

import com.yuwei.entity.LifePhoto;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface LifePhotoRepository extends JpaRepository<LifePhoto, Long> {

    List<LifePhoto> findAllByOrderByPhotoDateDesc();
}