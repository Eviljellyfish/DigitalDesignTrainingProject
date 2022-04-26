package com.kashigin.stanislav.security;

import com.kashigin.stanislav.dao.repository.OrgStructureRepository;
import com.kashigin.stanislav.dao.repository.UserAuthDataRepository;
import com.kashigin.stanislav.dao.repository.UserRepository;
import com.kashigin.stanislav.entity.OrgStructure;
import com.kashigin.stanislav.entity.User;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;

@Component("validator")
public class IsUserHasOrgAccessAuthorizationExpression {

    private final UserRepository userRepository;
    private final UserAuthDataRepository userAuthDataRepository;

    private final OrgStructureRepository orgStructureRepository;

    public IsUserHasOrgAccessAuthorizationExpression(UserRepository userRepository, UserAuthDataRepository userAuthDataRepository, OrgStructureRepository orgStructureRepository) {
        this.userRepository = userRepository;
        this.userAuthDataRepository = userAuthDataRepository;
        this.orgStructureRepository = orgStructureRepository;
    }


    public boolean isUserAllowedSeeOrg(Authentication authentication, long id) {
        String name = authentication.getName();
        User user = userAuthDataRepository.findByLogin(name).getUser();
        OrgStructure org = orgStructureRepository.getById(id);
        if (user != null && org != null) {
            while (org.getId() != user.getOrg().getId()) {
                if (org.getParent() == null)
                        return false;
                org = org.getParent();
            }
            return true;
        }
        return false;
    }

    public boolean isModerAllowedChangeUser(Authentication authentication, User user) {
        String name = authentication.getName();
        User moder = userAuthDataRepository.findByLogin(name).getUser();
        OrgStructure org;
        if (user.getOrg() != null) {
            org = user.getOrg();
            while (org != moder.getOrg()) {
                if (org == null)
                    return false;
                org = org.getParent();
            }
        }
        org = userRepository.findById(user.getId()).get().getOrg();
        if (org != null) {
            while (org.getId() != moder.getOrg().getId()) {
                if (org.getParent() == null)
                    return false;
                org = org.getParent();
            }
            return true;
        }
        return false;
    }

}
