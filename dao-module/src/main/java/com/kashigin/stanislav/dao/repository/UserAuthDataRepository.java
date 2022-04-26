package com.kashigin.stanislav.dao.repository;

import com.kashigin.stanislav.entity.User;
import com.kashigin.stanislav.entity.UserAuthData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserAuthDataRepository extends JpaRepository<UserAuthData, Long> {

    @Query("select u " +
            "from UserAuthData u " +
            "where u.login = ?1")
    UserAuthData findByLogin(String string);

    @Query("select u " +
            "from UserAuthData u " +
            "where u.role.id = ?1")
    List<UserAuthData> findAllByRoleId(long id);

    @Query("select u " +
            "from UserAuthData u " +
            "where u.user = ?1")
    UserAuthData findByUser(User user);
}
