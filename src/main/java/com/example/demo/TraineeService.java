package com.example.demo;

import org.springframework.stereotype.Service;

@Service
public class TraineeService {
    private final TraineeRepository traineeRepository;

    public TraineeService(TraineeRepository traineeRepository) {
        this.traineeRepository = traineeRepository;
    }

    public void addNewTrainee(Trainee trainee) {
        traineeRepository.save(trainee);
    }

    public void deleteTrainee(long id) {
        traineeRepository.deleteById(id);
    }

}
