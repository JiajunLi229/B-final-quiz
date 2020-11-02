package com.example.demo.repository;

import com.example.demo.domain.Trainee;
import org.springframework.data.jpa.repository.JpaRepository;

// TODO GTB-工程实践: - 先import，再引用，避免直接使用类的全名
@org.springframework.stereotype.Repository
public interface TraineeRepository extends JpaRepository<Trainee, Long> {

}
