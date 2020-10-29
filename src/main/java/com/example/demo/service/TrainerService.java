package com.example.demo.service;

import com.example.demo.domain.Trainer;

import com.example.demo.repository.TrainerRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class TrainerService {
    private final TrainerRepository trainerRepository;

    public TrainerService(TrainerRepository trainerRepository) {
        this.trainerRepository = trainerRepository;
    }

    public void addNewTrainer(Trainer trainer) {
        trainerRepository.save(trainer);
    }

    public void deleteTrainer(long id) {
        if (!trainerRepository.existsById(id)) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, " no such trainer");
        }
        trainerRepository.deleteById(id);
    }

    public List<Trainer> getUngroupedTrainer() {
        List<Trainer> trainerList = trainerRepository.findAll()
                .stream()
                .filter(trainer -> trainer.getGrouped().equals(false))
                .collect(Collectors.toList());

        if (trainerList.size() == 0) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, " no ungrouped trainer");
        }

        return trainerList;
    }
}
