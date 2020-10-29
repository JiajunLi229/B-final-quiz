package com.example.demo.service;

import com.example.demo.domain.Group;
import com.example.demo.domain.Trainer;
import com.example.demo.repository.GroupRepository;
import com.example.demo.repository.TraineeRepository;
import com.example.demo.repository.TrainerRepository;
import net.bytebuddy.implementation.bind.annotation.This;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Service
public class GroupService {
    private final TraineeRepository traineeRepository;
    private final TrainerRepository trainerRepository;
    private final GroupRepository groupRepository;

    public GroupService(TraineeRepository traineeRepository, TrainerRepository trainerRepository, GroupRepository groupRepository) {
        this.traineeRepository = traineeRepository;
        this.trainerRepository = trainerRepository;
        this.groupRepository = groupRepository;
    }

    public void randomGrouping() {

        List<Trainer> trainers = trainerRepository.findAll();

        Collections.shuffle(trainers);
        long IdOfTrainer = 1;
        long IdOfNextTrainer = IdOfTrainer + 1;

        int NumberOfTrainer = trainers.size();
        if (NumberOfTrainer % 2 == 0) {
            for (int i = NumberOfTrainer; i > 0; i--) {

                Trainer trainer = trainerRepository.findById(IdOfTrainer).orElse(null);
                Trainer nextTrainer = trainerRepository.findById(IdOfNextTrainer).orElse(null);

                Group group = new Group();
                group.getTrainerList().add(trainer);
                group.getTrainerList().add(nextTrainer);
                groupRepository.save(new Group());

                IdOfTrainer += 2;

                if (IdOfTrainer == trainers.size()) {
                    break;
                }
            }
        }

    }
}
