package com.yuwei.service;

import com.yuwei.dto.LifeEventDto;
import com.yuwei.entity.LifeEvent;
import com.yuwei.repository.LifeEventRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class LifeEventService {

    @Autowired
    private LifeEventRepository repository;

    public void save(LifeEventDto dto) {

        LifeEvent event = new LifeEvent();

        event.setContent(dto.getContent());
        event.setEventDate(dto.getEventDate());

        event.setCreatedAt(LocalDateTime.now());
        event.setUpdatedAt(LocalDateTime.now());

        repository.save(event);
    }
    public List<LifeEventDto> findAll() {
        List<LifeEvent> events = repository.findAll();

        return events.stream().map(event -> {
            LifeEventDto dto = new LifeEventDto();
            dto.setContent(event.getContent());
            dto.setEventDate(event.getEventDate());
            return dto;
        }).toList();
    }
    public List<LifeEventDto> findRecent(Integer days) {
        LocalDate startDate = LocalDate.now().minusDays(days);

        List<LifeEvent> events = repository.findByEventDateAfterOrderByEventDateDesc(startDate);

        return events.stream().map(event -> {
            LifeEventDto dto = new LifeEventDto();
            dto.setContent(event.getContent());
            dto.setEventDate(event.getEventDate());
            return dto;
        }).toList();
    }
}