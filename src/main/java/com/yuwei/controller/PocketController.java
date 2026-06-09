package com.yuwei.controller;

import com.yuwei.dto.PocketDto;
import com.yuwei.entity.Pocket;
import com.yuwei.service.PocketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/api/pockets")
public class PocketController {

    @Autowired
    private PocketService service;

    @PostMapping
    public void save(@RequestBody PocketDto dto) {
        service.save(dto);
    }

    @GetMapping
    public List<PocketDto> findAll() {
        return service.findAll();
    }

    @PutMapping("/{id}")
    public Pocket update(@PathVariable Long id, @RequestBody PocketDto pocketDto) {
        return service.update(id, pocketDto);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }
}