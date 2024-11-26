package com.guilhermebaltazar.demo.controllers;

import com.guilhermebaltazar.demo.entities.Live;
import com.guilhermebaltazar.demo.services.LiveService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/lives")
public class LiveController {

    private final LiveService liveService;

    public LiveController(LiveService liveService) {
        this.liveService = liveService;
    }

    @PostMapping
    public ResponseEntity<Live> create(@Valid @RequestBody Live live) {
        Live createdLive = liveService.create(live);
        return ResponseEntity.status(201).body(createdLive);
    }

    @GetMapping
    public ResponseEntity<List<Live>> getAll() {
        return ResponseEntity.ok(liveService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Live> getById(@PathVariable("id") @Valid Long id) {
        return liveService.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
    public ResponseEntity<Live> update(@PathVariable Long id, @Valid @RequestBody Live live) {
        Live updatedLive = liveService.update(id, live);
        return ResponseEntity.ok(updatedLive);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        if (liveService.delete(id)) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }
}
