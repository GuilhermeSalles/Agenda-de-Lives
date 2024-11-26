package com.guilhermebaltazar.demo.controllers;

import java.time.LocalDateTime;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.guilhermebaltazar.demo.entities.Live;
import com.guilhermebaltazar.demo.services.LiveService;

import jakarta.validation.Valid;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/lives")
public class LiveController {

    private final LiveService liveService;

    public LiveController(LiveService liveService) {
        this.liveService = liveService;
    }

    @GetMapping
    public ResponseEntity<Page<Live>> getAllLives(
            @PageableDefault(page = 0, size = 10, sort = "id", direction = Sort.Direction.ASC) Pageable pageable,
            @RequestParam(required = false) String flag) {
        Page<Live> livePage = liveService.findAll(pageable, flag);
        if (livePage.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else {
            return new ResponseEntity<>(livePage, HttpStatus.OK);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<Live> getOneLive(@PathVariable("id") Long id) {
        Optional<Live> liveO = liveService.findById(id);
        if (!liveO.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else {
            return new ResponseEntity<>(liveO.get(), HttpStatus.OK);
        }
    }

    @PostMapping
    public ResponseEntity<Live> saveLive(@Valid @RequestBody Live live) {
        live.setRegistrationDate(LocalDateTime.now());
        Live savedLive = liveService.create(live);
        return new ResponseEntity<>(savedLive, HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteLive(@PathVariable("id") Long id) {
        Optional<Live> liveO = liveService.findById(id);
        if (!liveO.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else {
            liveService.delete(id);
            return new ResponseEntity<>(HttpStatus.OK);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Live> updateLive(@PathVariable("id") Long id, @Valid @RequestBody Live live) {
        Optional<Live> liveO = liveService.findById(id);
        if (!liveO.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else {
            live.setId(liveO.get().getId());
            Live updatedLive = liveService.update(id, live);
            return new ResponseEntity<>(updatedLive, HttpStatus.OK);
        }
    }
}
