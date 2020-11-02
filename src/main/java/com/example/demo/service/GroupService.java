package com.example.demo.service;

import com.example.demo.domain.Group;
import com.example.demo.domain.Trainer;
import com.example.demo.repository.GroupRepository;

import com.example.demo.repository.TrainerRepository;

import org.springframework.stereotype.Service;


import java.util.Collections;
import java.util.List;


@Service
public class GroupService {

    private final TrainerRepository trainerRepository;
    private final GroupRepository groupRepository;

    public GroupService(TrainerRepository trainerRepository, GroupRepository groupRepository) {
        this.trainerRepository = trainerRepository;
        this.groupRepository = groupRepository;
    }

    public void randomGrouping() {

        List<Trainer> trainers = trainerRepository.findAll();

        Collections.shuffle(trainers);
        long IdOfTrainer = 1;
        long IdOfNextTrainer = IdOfTrainer + 1;

        // TODO GTB-工程实践: - 变量名应使用驼峰命名，首字母小写
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
