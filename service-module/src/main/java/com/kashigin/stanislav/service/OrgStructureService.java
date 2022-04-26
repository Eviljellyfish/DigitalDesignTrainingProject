package com.kashigin.stanislav.service;

import com.kashigin.stanislav.dao.repository.RoleRepository;
import com.kashigin.stanislav.dao.repository.UserAuthDataRepository;
import com.kashigin.stanislav.dao.repository.UserRepository;
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
    private final UserRepository userRepository;
    private final UserAuthDataRepository userAuthDataRepository;

    private final RoleRepository roleRepository;

    public OrgStructureService(OrgStructureRepository orgStructureRepository, UserRepository userRepository, UserAuthDataRepository userAuthDataRepository, RoleRepository roleRepository) {
        this.orgStructureRepository = orgStructureRepository;
        this.userRepository = userRepository;
        this.userAuthDataRepository = userAuthDataRepository;
        this.roleRepository = roleRepository;
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
        if (orgStructure.getHead() != null) {
            User user = orgStructure.getHead();
            user.setOrg(orgStructure);
            userRepository.save(user);
            UserAuthData userAuthData = userAuthDataRepository.findByUser(user);
            if (userAuthData!=null && userAuthData.getRole().getId() == 1) {
                userAuthData.setRole(roleRepository.findByName("MODERATOR").get());
                userAuthDataRepository.save(userAuthData);
            }
        }
        else {
            OrgStructure oldOrg = orgStructureRepository.findById(orgStructure.getId()).get();
            User user = oldOrg.getHead();
            UserAuthData userAuthData = userAuthDataRepository.findByUser(user);
            user.setOrg(null);
            userRepository.save(user);
            if (userAuthData!=null && userAuthData.getRole().getId() == 2) {
                userAuthData.setRole(roleRepository.findByName("USER").get());
                userAuthDataRepository.save(userAuthData);
            }
        }
        return addOrg(orgStructure);
    }

    public Set<User> getStaff(OrgStructure orgStructure) {
        return orgStructureRepository.findStaff(orgStructure.getId());
    }

}
