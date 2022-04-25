package com.kashigin.stanislav.controller;

import org.springframework.web.bind.annotation.*;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;
import com.kashigin.stanislav.entity.*;
import com.kashigin.stanislav.service.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "/api/v1/orgs")
public class OrgStructureController {

    private final OrgStructureService orgStructureService;

    public OrgStructureController(OrgStructureService orgStructureService) {
        this.orgStructureService = orgStructureService;
    }

    @PostMapping(consumes = "application/json")
    public OrgStructure add(@RequestBody OrgStructure orgStructure) {
        orgStructureService.addOrg(orgStructure);
        return orgStructure;
    }

    @GetMapping
    public List<OrgStructure> getAll() {
        return orgStructureService.getAll();
    }

    @GetMapping(path = "{id}")
    public Optional<OrgStructure> findById(@PathVariable Long id) {
        return orgStructureService.findOrg(id);
    }

    @PutMapping(consumes = "application/json")
    public OrgStructure update(@RequestBody OrgStructure orgStructure) {
        return add(orgStructure);
    }

    @DeleteMapping(path = "{id}")
    public void delete(@PathVariable long id) {
        orgStructureService.deleteOrg(id);
    }

//    public List<OrgStructure> getAllSubOrgs(OrgStructure orgStructure) {
//        throw new NotImplementedException();
//    }
//
//    public List<User> getStaff(OrgStructure orgStructure) {
//        throw new NotImplementedException();
//    }

}
