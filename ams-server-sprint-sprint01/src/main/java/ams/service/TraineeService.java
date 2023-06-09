package ams.service;

import ams.model.entity.Trainee;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;

public interface TraineeService  {
    Page<Trainee> findAllPaging(Specification<Trainee> spec, Pageable pageable);

}
