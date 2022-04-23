package com.kashigin.stanislav.controller;

import org.springframework.web.bind.annotation.*;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;
import com.kashigin.stanislav.entity.*;
import com.kashigin.stanislav.service.*;

import java.util.List;

@RestController
@RequestMapping(path = "orgs")
public class OrgStructureController {

    private final OrgStructureService orgStructureService;

    public OrgStructureController(OrgStructureService orgStructureService) {
        this.orgStructureService = orgStructureService;
    }

    @PostMapping
    public OrgStructure add(OrgStructure orgStructure) {
        throw new NotImplementedException();
    }

    @DeleteMapping
    public boolean delete(OrgStructure orgStructure) {
        throw new NotImplementedException();
    }

    @GetMapping

    public OrgStructure getById(OrgStructure orgStructure) {
        throw new NotImplementedException();
    }

    @PutMapping
    public boolean update(OrgStructure orgStructure) {
        throw new NotImplementedException();
    }

//    public List<OrgStructure> getAllSubOrgs(OrgStructure orgStructure) {
//        throw new NotImplementedException();
//    }
//
//    public List<User> getStaff(OrgStructure orgStructure) {
//        throw new NotImplementedException();
//    }

}
