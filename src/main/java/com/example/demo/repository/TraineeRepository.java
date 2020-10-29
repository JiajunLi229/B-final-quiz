package com.example.demo.repository;

import com.example.demo.domain.Trainee;
import org.springframework.data.jpa.repository.JpaRepository;

@org.springframework.stereotype.Repository
public interface TraineeRepository extends JpaRepository<Trainee, Long> {

}
