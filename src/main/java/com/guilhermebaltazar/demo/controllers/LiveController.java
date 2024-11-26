package com.guilhermebaltazar.demo.controllers;

import com.guilhermebaltazar.demo.entities.Live;
import com.guilhermebaltazar.demo.services.LiveService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/lives")
public class LiveController {

    @Autowired
    private LiveService liveService;

    @PostMapping
    public ResponseEntity<Live> create(@RequestBody Live live) {
        Live createdLive = liveService.create(live);
        return ResponseEntity.status(201).body(createdLive);
    }

    @GetMapping
    public ResponseEntity<List<Live>> getAll() {
        return ResponseEntity.ok(liveService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Live> getById(@PathVariable Long id) {
        return liveService.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
    public ResponseEntity<Live> update(@PathVariable Long id, @RequestBody Live live) {
        try {
            Live updatedLive = liveService.update(id, live);
            return ResponseEntity.ok(updatedLive);
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        if (liveService.delete(id)) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }
}
