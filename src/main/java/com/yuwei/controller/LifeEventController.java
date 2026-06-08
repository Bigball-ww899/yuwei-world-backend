package com.yuwei.controller;

import com.yuwei.dto.LifeEventDto;
import com.yuwei.service.LifeEventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/api/life-events")
public class LifeEventController {

    @Autowired
    private LifeEventService service;

    @PostMapping
    public void save(
            @RequestBody LifeEventDto dto
    ) {

        service.save(dto);

    }
    @GetMapping
    public List<LifeEventDto> findAll(
            @RequestParam(required = false) Integer days
    ) {
        if (days == null) {
            return service.findAll();
        }

        return service.findRecent(days);
    }
}