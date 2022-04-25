package com.kashigin.stanislav.dto.map;

import com.kashigin.stanislav.dto.OrgDto;
import com.kashigin.stanislav.entity.OrgStructure;
import com.kashigin.stanislav.service.OrgStructureService;
import com.kashigin.stanislav.service.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
public class OrgMapper implements Mapper<OrgStructure, OrgDto> {
    private final ModelMapper modelMapper;

    private final UserService userService;
    private final OrgStructureService orgStructureService;

    public OrgMapper(ModelMapper modelMapper, UserService userService, OrgStructureService orgStructureService) {
        this.modelMapper = modelMapper;
        this.userService = userService;
        this.orgStructureService = orgStructureService;
    }

    @Override
    public OrgDto convertToDto(OrgStructure org) {
        OrgDto dto = new OrgDto(org.getId(), org.getName());
        if (org.getHead() != null)
            dto.setHead(org.getHead().getId());
        if (org.getParent() != null)
            dto.setParent(org.getParent().getId());
        return dto;
    }

    @Override
    public OrgStructure convertToModel(OrgDto dto) {
        OrgStructure org = modelMapper.map(dto, OrgStructure.class);
        if (dto.getHead() != 0)
            org.setHead(userService.findUser(dto.getHead()).get());
        if (dto.getParent() != 0)
            org.setParent(orgStructureService.findOrg(dto.getHead()).get());
        return org;
    }
}
