package ams.service.impl;


import ams.exception.ResourceNotFoundException;
import ams.model.entity.BaseEntity;
import ams.repository.BaseRepository;
import ams.repository.CommonSpecifications;
import ams.service.BaseService;
import jakarta.annotation.Nullable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;

import java.io.Serializable;
import java.util.List;
import java.util.Optional;

public class BaseServiceImpl<T extends BaseEntity, ID extends Serializable, R extends BaseRepository<T, ID>>
        implements BaseService<T, ID> {

    @Autowired
    protected R repository;


    @Override
    public T createOrUpdate(T model) {
        if (model.getId() == null) {
            model.setDeleted(false);
        }
        return repository.save(model);
    }

    @Override
    public T create(T model) {
        model.setDeleted(false);
        return repository.save(model);
    }

    @Override
    public T update(T model) {
        return repository.save(model);
    }

    @Override
    public List<T> createOrUpdate(List<T> models) {
        return (List<T>) repository.saveAll(models);
    }

    @Override
    public void delete(ID id) {
        Optional<T> modelOpt = repository.findByIdAndDeletedFalse(id);
        T model = modelOpt.orElseThrow(ResourceNotFoundException::new);
        model.setDeleted(true);
        repository.save(model);
    }

    @Override
    public T findOne(ID id) {
        return repository.findByIdAndDeletedFalse(id)
                .orElseThrow(ResourceNotFoundException::new);
    }

    @Override
    public Optional<T> findOneOpt(ID id) {
        return repository.findByIdAndDeletedFalse(id);
    }

    @Override
    public List<T> findAll() {
        CommonSpecifications<T> spec = new CommonSpecifications<>();
        Specification<T> undeletedSpec = spec.unDeleted();
        return repository.findAll(undeletedSpec);
    }

    @Override
    public Page<T> findAll(@Nullable Specification<T> spec, Pageable page) {
        return repository.findAll(spec, page);
    }

    @Override
    public Page<T> findUndeletedAll(Pageable page) {
        CommonSpecifications<T> spec = new CommonSpecifications<>();
        Specification<T> undeletedSpec = spec.unDeleted();
        return repository.findAll(undeletedSpec, page);
    }

    @Override
    public boolean exists(ID id) {
        return repository.existsByIdAndDeletedFalse(id);
    }

}