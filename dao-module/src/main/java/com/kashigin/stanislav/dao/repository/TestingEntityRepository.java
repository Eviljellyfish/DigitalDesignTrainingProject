package com.kashigin.stanislav.dao.repository;

import com.kashigin.stanislav.entity.TestingEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Deprecated
@Repository
public interface TestingEntityRepository extends CrudRepository<TestingEntity, Long> {
}
