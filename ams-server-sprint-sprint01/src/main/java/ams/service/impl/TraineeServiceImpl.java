package ams.service.impl;

import ams.model.entity.Trainee;
import ams.repository.TraineeRepository;
import ams.service.TraineeService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class TraineeServiceImpl extends BaseServiceImpl {
    private final TraineeRepository traineeRepository;


    public TraineeServiceImpl(TraineeRepository traineeRepository) {
        this.traineeRepository = traineeRepository;

    }



    @Override
    public List<Trainee> findAll() {
        return null;
    }



    @Override
    public Page<Trainee> findUndeletedAll(Pageable page) {
        return null;
    }




}
