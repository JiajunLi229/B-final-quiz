package com.example.demo.service;

import com.example.demo.domain.Trainer;
import com.example.demo.repository.TraineeRepository;
import com.example.demo.domain.Trainee;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import javax.management.InstanceNotFoundException;
import java.util.List;
import java.util.stream.Collectors;

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
        if (!traineeRepository.existsById(id)) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, " no such trainee");
        }
        traineeRepository.deleteById(id);
    }

    public List<Trainee> getUngroupedTrainee() {
        List<Trainee> traineeList = traineeRepository.findAll()
                .stream()
                .filter(trainee -> trainee.getGrouped().equals(false))
                .collect(Collectors.toList());

        if (traineeList.size()== 0) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, " no ungrouped trainee");
        }

        return traineeList;


    }
}
