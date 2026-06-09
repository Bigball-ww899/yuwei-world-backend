package com.yuwei.service;

import com.yuwei.dto.LifePhotoDto;
import com.yuwei.entity.LifePhoto;
import com.yuwei.repository.LifePhotoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class LifePhotoService {

    @Autowired
    private LifePhotoRepository repository;

    public List<LifePhotoDto> findAll() {

        List<LifePhoto> photos =
                repository.findAllByOrderByPhotoDateDesc();

        return photos.stream().map(photo -> {

            LifePhotoDto dto = new LifePhotoDto();

            dto.setId(photo.getId());
            dto.setTitle(photo.getTitle());
            dto.setDescription(photo.getDescription());
            dto.setPhotoDate(photo.getPhotoDate());
            dto.setImageUrl(photo.getImageUrl());

            return dto;

        }).toList();
    }

    public void save(LifePhotoDto dto) {

        LifePhoto photo = new LifePhoto();

        photo.setTitle(dto.getTitle());
        photo.setDescription(dto.getDescription());
        photo.setPhotoDate(dto.getPhotoDate());
        photo.setImageUrl(dto.getImageUrl());

        photo.setCreatedAt(LocalDateTime.now());
        photo.setUpdatedAt(LocalDateTime.now());

        repository.save(photo);
    }
}