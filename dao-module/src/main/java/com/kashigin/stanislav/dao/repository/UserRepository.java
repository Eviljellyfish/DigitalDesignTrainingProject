package com.kashigin.stanislav.dao.repository;

import com.kashigin.stanislav.entity.OrgStructure;
import com.kashigin.stanislav.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Set;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {




}
