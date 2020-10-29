package com.example.demo.service;

import com.example.demo.domain.Trainee;
import com.example.demo.domain.Trainer;
import com.example.demo.repository.TraineeRepository;
import com.example.demo.repository.TrainerRepository;
import org.springframework.stereotype.Service;

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
        trainerRepository.deleteById(id);
    }
}
