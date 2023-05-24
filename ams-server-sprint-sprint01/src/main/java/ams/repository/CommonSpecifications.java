package ams.repository;

import ams.model.entity.BaseEntity;
import org.springframework.data.jpa.domain.Specification;

public class CommonSpecifications<M extends BaseEntity> {

    public Specification<M> unDeleted() {
        return (root, criteriaQuery, criteriaBuilder) -> criteriaBuilder.equal(root.get("deleted"), false);
    }
}
