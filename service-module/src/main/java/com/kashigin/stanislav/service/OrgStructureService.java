package com.kashigin.stanislav.service;

import com.kashigin.stanislav.entity.*;
import com.kashigin.stanislav.dao.repository.OrgStructureRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
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
        OrgStructure org = orgStructureRepository.getById(id);
        if (org.getHead() != null)
            org.setHead(null);
        List<OrgStructure> subOrgsList = new ArrayList<>(orgStructureRepository.findAllByParentId(id));
        OrgStructure parent = org.getParent();
        for (OrgStructure subOrg: subOrgsList) {
                subOrg.setParent(parent);
        }
        List<User> staff = new ArrayList<>(orgStructureRepository.findStaff(id));
        for (User user: staff) {
            user.setOrg(null);
        }
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

    public Set<User> getStaff(long id) {
        return orgStructureRepository.findStaff(id);
    }

}
