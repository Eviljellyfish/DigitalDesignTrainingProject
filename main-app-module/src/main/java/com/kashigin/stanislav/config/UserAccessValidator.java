package com.kashigin.stanislav.config;

import com.kashigin.stanislav.dao.repository.OrgStructureRepository;
import com.kashigin.stanislav.dao.repository.UserRepository;
import com.kashigin.stanislav.entity.OrgStructure;
import com.kashigin.stanislav.entity.User;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;

import java.util.Set;

@Component
public class UserAccessValidator {

    private final UserRepository userRepository;
    private final OrgStructureRepository orgStructureRepository;

    public UserAccessValidator(UserRepository userRepository, OrgStructureRepository orgStructureRepository) {
        this.userRepository = userRepository;
        this.orgStructureRepository = orgStructureRepository;
    }

    public boolean checkUserOrgAccess(Authentication authentication, long id) {
        String name = authentication.getName();
        User user = userRepository.findById(id).get();
        if (user != null && user.getOrg() != null) {
            Set<OrgStructure> orgStructures = orgStructureRepository.findAllByParentId(user.getOrg().getId());
            return orgStructures.contains(id);
        }
        return false;
    }

}
