package com.example.demo.controller;

import com.example.demo.domain.Trainee;
import com.example.demo.service.TraineeService;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/trainees")
// TODO GTB-知识点: - @Validated注解使用不合理，可以省略
@Validated
public class TraineeController {
    private final TraineeService traineeService;

    public TraineeController(TraineeService traineeService) {
        this.traineeService = traineeService;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    // TODO GTB-知识点: - POST创建资源后，应返回新建的资源
    public void addTrainee(@RequestBody @Valid Trainee trainee) {
        traineeService.addNewTrainee(trainee);
    }

    @DeleteMapping("/{trainee_id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    // TODO GTB-工程实践: - 变量名应使用驼峰命名，并且首字母小写
    public void deleteTrainee(@PathVariable Long trainee_id) {
        traineeService.deleteTrainee(trainee_id);
    }

    @GetMapping
    public List<Trainee> getUngroupedTrainee() {
        return traineeService.getUngroupedTrainee();
    }
}
