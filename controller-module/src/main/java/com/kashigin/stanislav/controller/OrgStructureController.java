package com.kashigin.stanislav.controller;

import com.kashigin.stanislav.dto.OrgDto;
import com.kashigin.stanislav.dto.UserDto;
import com.kashigin.stanislav.dto.map.OrgMapper;
import com.kashigin.stanislav.dto.map.UserMapper;
import org.springframework.security.access.prepost.PreAuthorize;
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
    private final UserMapper userMapper;

    public OrgStructureController(OrgStructureService orgStructureService, OrgMapper orgMapper, UserMapper userMapper) {
        this.orgStructureService = orgStructureService;
        this.orgMapper = orgMapper;
        this.userMapper = userMapper;
    }

    @PreAuthorize("hasAuthority('ADMIN')")
    @PostMapping(consumes = "application/json")
    public OrgDto add(@RequestBody OrgDto orgStructure) {
        return orgMapper.convertToDto(orgStructureService.addOrg(orgMapper.convertToModel(orgStructure)));
    }

    @PreAuthorize("hasAuthority('ADMIN')")
    @GetMapping
    public List<OrgDto> getAll() {
        return orgStructureService
                .getAll()
                .stream()
                .map(orgStructure -> orgMapper.convertToDto(orgStructure))
                .collect(Collectors.toList());
    }

    @PreAuthorize("@validator.isUserAllowedSeeOrg(authentication, #id) or hasAuthority('ADMIN')")
    @GetMapping(path = "{id}")
    public Optional<OrgDto> findById(@PathVariable Long id) {
        return orgStructureService
                .findOrg(id)
                .map(orgStructure -> orgMapper.convertToDto(orgStructure));
    }

    @PreAuthorize("hasAuthority('ADMIN') or (hasAuthority('MODERATOR') and @validator.isUserAllowedSeeOrg(authentication, #id))")
    @PutMapping(consumes = "application/json")
    public OrgDto update(@RequestBody OrgDto orgStructure) {
        return orgMapper.convertToDto(
                orgStructureService.updateOrg(orgMapper.convertToModel(orgStructure))
        );
    }

    @PreAuthorize("@validator.isUserAllowedSeeOrg(authentication, #id) or hasAuthority('ADMIN')")
    @GetMapping(path = "parent/{id}")
    public Set<OrgDto> findByParent(@PathVariable long id) {
        return orgStructureService
                .findAllByParentId(id)
                .stream()
                .map(orgStructure -> orgMapper.convertToDto(orgStructure))
                .collect(Collectors.toSet());
    }

    @PreAuthorize("hasAuthority('ADMIN')")
    @DeleteMapping(path = "{id}")
    public void delete(@PathVariable long id) {
        orgStructureService.deleteOrg(id);
    }

    @PreAuthorize("@validator.isUserAllowedSeeOrg(authentication, #id) or hasAuthority('ADMIN')")
    @GetMapping(path = "{id}/staff")
    public List<UserDto> getStaff(OrgDto orgStructure) {
        return orgStructureService.getStaff(orgMapper.convertToModel(orgStructure))
                .stream()
                .map(user -> userMapper.convertToDto(user))
                .collect(Collectors.toList());
    }

}
