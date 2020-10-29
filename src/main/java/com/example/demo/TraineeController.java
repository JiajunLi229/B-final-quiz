package com.example.demo;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/trainees")
public class TraineeController {
    private final TraineeService traineeService;

    public TraineeController(TraineeService traineeService) {
        this.traineeService = traineeService;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void addTrainee(@RequestBody @Valid Trainee trainee) {
         traineeService.addNewTrainee(trainee);
    }

    @DeleteMapping("/{trainee_id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteTrainee(@PathVariable Long trainee_id) {
        traineeService.deleteTrainee(trainee_id);
    }
}
