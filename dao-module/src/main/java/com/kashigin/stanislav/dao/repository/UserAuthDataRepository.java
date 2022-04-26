package com.kashigin.stanislav.dao.repository;

import com.kashigin.stanislav.entity.UserAuthData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface UserAuthDataRepository extends JpaRepository<UserAuthData, Long> {

    @Query("select u " +
            "from UserAuthData u " +
            "where u.login = ?1")
    UserAuthData findByLogin(String string);
}
