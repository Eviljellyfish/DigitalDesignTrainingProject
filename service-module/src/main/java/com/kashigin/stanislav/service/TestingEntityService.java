package com.kashigin.stanislav.service;

import com.kashigin.stanislav.dao.repository.TestingEntityRepository;
import com.kashigin.stanislav.entity.TestingEntity;
import org.springframework.stereotype.Service;

@Service
public class TestingEntityService {

    private final TestingEntityRepository testingEntityRepository;

    public TestingEntityService(TestingEntityRepository testingEntityRepository) {
        this.testingEntityRepository = testingEntityRepository;
    }

    public TestingEntity findById(long id) {
        return testingEntityRepository.findById(id).get();
    }

    public TestingEntity save(TestingEntity testingEntity) {
        testingEntityRepository.save(testingEntity);
        return testingEntity;
    }

}
