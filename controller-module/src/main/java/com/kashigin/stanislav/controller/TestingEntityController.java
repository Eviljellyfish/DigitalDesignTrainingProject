package com.kashigin.stanislav.controller;

import com.kashigin.stanislav.entity.TestingEntity;
import com.kashigin.stanislav.service.TestingEntityService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "test")
public class TestingEntityController {

    private final TestingEntityService testingEntityService;

    public TestingEntityController(TestingEntityService testingEntityService) {
        this.testingEntityService = testingEntityService;
    }

    @GetMapping(path = "/test", produces = "application/json")
    public TestingEntity greeting() {
        return new TestingEntity(1L, "asd");
    }

    @GetMapping(path = "/{id}", produces = "application/json")
    public TestingEntity getById(@PathVariable long id) {
        return testingEntityService.findById(id);
    }

    @PostMapping
    public TestingEntity create(@RequestBody TestingEntity testingEntity) {
        testingEntityService.save(testingEntity);
        return testingEntity;
    }

}
