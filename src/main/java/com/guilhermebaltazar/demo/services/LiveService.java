package com.guilhermebaltazar.demo.services;

import java.time.LocalDateTime;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.guilhermebaltazar.demo.entities.Live;
import com.guilhermebaltazar.demo.repositories.LiveRepository;

@Service
public class LiveService {

    private final LiveRepository liveRepository;

    public LiveService(LiveRepository liveRepository) {
        this.liveRepository = liveRepository;
    }

    public Page<Live> findAll(Pageable pageable, String flag) {
        if (flag != null) {
            if (flag.equals("next")) {
                return liveRepository.findByLiveDateAfterOrderByLiveDateAsc(LocalDateTime.now(), pageable);
            } else if (flag.equals("previous")) {
                return liveRepository.findByLiveDateBeforeOrderByLiveDateDesc(LocalDateTime.now(), pageable);
            }
        }
        return liveRepository.findAll(pageable);
    }

    public Optional<Live> findById(Long id) {
        return liveRepository.findById(id);
    }

    public Live create(Live live) {
        return liveRepository.save(live);
    }

    public Live update(Long id, Live updatedLive) {
        return liveRepository.findById(id).map(existingLive -> {
            existingLive.setLiveName(updatedLive.getLiveName());
            existingLive.setChannelName(updatedLive.getChannelName());
            existingLive.setLiveDate(updatedLive.getLiveDate());
            existingLive.setLiveLink(updatedLive.getLiveLink());
            existingLive.setLiveStatus(updatedLive.getLiveStatus());
            return liveRepository.save(existingLive);
        }).orElseThrow(() -> new RuntimeException("Live not found"));
    }

    public void delete(Long id) {
        if (liveRepository.existsById(id)) {
            liveRepository.deleteById(id);
        } else {
            throw new RuntimeException("Live not found");
        }
    }
}
