
package com.example.tourist.service;

import com.example.tourist.entity.Tourist;
import com.example.tourist.repository.TouristRepository;
import org.springframework.stereotype.Service;

@Service
public class TouristService {

    private final TouristRepository repository;

    public TouristService(TouristRepository repository) {
        this.repository = repository;
    }

    public void deleteTourist(Long id) {
        Tourist tourist = repository.findById(id)
                .orElseThrow(() ->
                    new RuntimeException("Tourist not found"));

        repository.delete(tourist);
    }
}
