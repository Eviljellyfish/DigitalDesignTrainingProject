package com.kashigin.stanislav.service;

import com.kashigin.stanislav.entity.*;
import com.kashigin.stanislav.dao.repository.OrgStructureRepository;
import org.springframework.stereotype.Service;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.util.List;

@Service
public class OrgStructureService {

    private final OrgStructureRepository orgStructureRepository;

    public OrgStructureService(OrgStructureRepository orgStructureRepository) {
        this.orgStructureRepository = orgStructureRepository;
    }

    public boolean addOrg() {
        throw new NotImplementedException();
    }

    public boolean deleteOrg(int id) {
        throw new NotImplementedException();
    }

    public OrgStructure findOrg(int id) {
        throw new NotImplementedException();
    }

    public List<OrgStructure> findOrgsByName(String name) {
        throw new NotImplementedException();
    }

    public boolean changeOrgParent(int id, OrgStructure org) {
        throw new NotImplementedException();
    }

    public boolean changeOrgHead(int orgId, int userId) {
        throw new NotImplementedException();
    }

    public boolean addSubOrg(int orgId, int subOrgId) {
        throw new NotImplementedException();
    }

    public boolean changeOrgName(int id, String name) {
        throw new NotImplementedException();
    }

    public List<User> getStaff(int id) {
        throw new NotImplementedException();
    }

    public List<OrgStructure> getSubOrgs(int id) {
        throw new NotImplementedException();
    }
}
