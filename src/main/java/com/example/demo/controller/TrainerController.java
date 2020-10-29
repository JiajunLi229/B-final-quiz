package com.example.demo.controller;
import com.example.demo.domain.Trainee;
import com.example.demo.domain.Trainer;
import com.example.demo.service.TrainerService;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

@Validated
@RestController
@RequestMapping("/trainers")
public class TrainerController {
    private final TrainerService trainerService;

    public TrainerController(TrainerService trainerService) {
        this.trainerService = trainerService;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void addTrainee(@RequestBody @Valid Trainer trainer) {
        trainerService.addNewTrainer(trainer);
    }

    @DeleteMapping("/{trainer_id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteTrainee(@PathVariable Long trainer_id) {
        trainerService.deleteTrainer(trainer_id);
    }

    @GetMapping
    public List<Trainer> getUngroupedTrainer() {
        return trainerService.getUngroupedTrainer();
    }

}

