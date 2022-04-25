package com.kashigin.stanislav.controller;

import com.kashigin.stanislav.dto.OrgDto;
import com.kashigin.stanislav.dto.map.OrgMapper;
import org.springframework.web.bind.annotation.*;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;
import com.kashigin.stanislav.entity.*;
import com.kashigin.stanislav.service.*;

import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

@RestController
@RequestMapping(path = "/api/v1/orgs")
public class OrgStructureController {

    private final OrgStructureService orgStructureService;

    private final OrgMapper orgMapper;

    public OrgStructureController(OrgStructureService orgStructureService, OrgMapper orgMapper) {
        this.orgStructureService = orgStructureService;
        this.orgMapper = orgMapper;
    }

    @PostMapping(consumes = "application/json")
    public OrgDto add(@RequestBody OrgDto orgStructure) {
        return orgMapper.convertToDto(orgStructureService.addOrg(orgMapper.convertToModel(orgStructure)));
    }

    @GetMapping
    public List<OrgDto> getAll() {
        return orgStructureService.
                getAll().
                stream().
                map(orgStructure -> orgMapper.convertToDto(orgStructure)).
                collect(Collectors.toList());
    }

    @GetMapping(path = "{id}")
    public Optional<OrgDto> findById(@PathVariable Long id) {
        return orgStructureService.
                findOrg(id).
                map(orgStructure -> orgMapper.convertToDto(orgStructure));
    }

    @PutMapping(consumes = "application/json")
    public OrgDto update(@RequestBody OrgDto orgStructure) {
        return add(orgStructure);
    }

    @GetMapping(path = "parent/{id}")
    public Set<OrgDto> findByParent(@PathVariable long id) {
        return orgStructureService.
                findAllByParentId(id).
                stream().
                map(orgStructure -> orgMapper.convertToDto(orgStructure)).
                collect(Collectors.toSet());
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
