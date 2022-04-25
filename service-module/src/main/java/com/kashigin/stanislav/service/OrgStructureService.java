package com.kashigin.stanislav.service;

import com.kashigin.stanislav.entity.*;
import com.kashigin.stanislav.dao.repository.OrgStructureRepository;
import org.springframework.stereotype.Service;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
public class OrgStructureService {

    private final OrgStructureRepository orgStructureRepository;

    public OrgStructureService(OrgStructureRepository orgStructureRepository) {
        this.orgStructureRepository = orgStructureRepository;
    }

    public OrgStructure addOrg(OrgStructure orgStructure) {
        orgStructureRepository.save(orgStructure);
        return orgStructure;
    }

    public Set<OrgStructure> findAllByParentId(long id) {
        return orgStructureRepository.findAllByParentId(id);
    }

    public void deleteOrg(long id) {
        orgStructureRepository.deleteById(id);
    }

    public Optional<OrgStructure> findOrg(long id) {
        return orgStructureRepository.findById(id);
    }

    public List<OrgStructure> getAll() {
        return orgStructureRepository.findAll();
    }

    public OrgStructure updateOrg(OrgStructure orgStructure) {
        return addOrg(orgStructure);
    }

    public List<OrgStructure> findOrgsByName(String name) {
        throw new NotImplementedException();
    }

    public List<User> getStaff(long id) {
        throw new NotImplementedException();
    }

}
