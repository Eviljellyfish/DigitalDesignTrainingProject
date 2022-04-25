package com.kashigin.stanislav.controller;

import com.kashigin.stanislav.dto.RoleDto;
import com.kashigin.stanislav.dto.map.RoleMapper;
import com.kashigin.stanislav.service.RoleService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping(path = "/api/v1/roles")
public class RoleController {

    private final RoleService roleService;

    private final RoleMapper roleMapper;

    public RoleController(RoleService roleService, RoleMapper roleMapper) {
        this.roleService = roleService;
        this.roleMapper = roleMapper;
    }

    @PostMapping(consumes = "application/json")
    public RoleDto add(@RequestBody RoleDto role) {
        return roleMapper.convertToDto(roleService.addRole(roleMapper.convertToModel(role)));
    }

    @GetMapping
    public List<RoleDto> getAll() {
        return roleService.
                findAll().
                stream().
                map(role -> roleMapper.convertToDto(role)).
                collect(Collectors.toList());
    }

    @GetMapping(path = "{name}")
    public Optional<RoleDto> findById(@PathVariable String name) {
        return roleService.find(name).map(role -> roleMapper.convertToDto(role));
    }

    @PutMapping(consumes = "application/json")
    public RoleDto update(@RequestBody RoleDto role) {
        return add(role);
    }

    @DeleteMapping(path = "{name}")
    public void delete(@PathVariable String name) {
        roleService.delete(name);
    }
}
