package com.example.demo.service;

import com.example.demo.domain.Trainee;
import com.example.demo.domain.Trainer;
import com.example.demo.repository.TraineeRepository;
import com.example.demo.repository.TrainerRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

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
            throw new  ResponseStatusException(HttpStatus.NOT_FOUND, " no such trainer");
        }
        trainerRepository.deleteById(id);
    }
}
