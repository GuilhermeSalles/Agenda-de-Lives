package com.guilhermebaltazar.demo.services;

import com.guilhermebaltazar.demo.entities.Live;
import com.guilhermebaltazar.demo.repositories.LiveRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LiveService {

    @Autowired
    private LiveRepository liveRepository;

    public Live create(Live live) {
        return liveRepository.save(live);
    }

    public List<Live> findAll() {
        return liveRepository.findAll();
    }

    public Optional<Live> findById(Long id) {
        return liveRepository.findById(id);
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

    public boolean delete(Long id) {
        if (liveRepository.existsById(id)) {
            liveRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
