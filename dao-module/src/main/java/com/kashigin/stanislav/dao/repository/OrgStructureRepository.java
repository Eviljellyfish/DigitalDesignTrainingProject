package com.kashigin.stanislav.dao.repository;

import com.kashigin.stanislav.entity.OrgStructure;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.Set;

@Repository
public interface OrgStructureRepository extends JpaRepository<OrgStructure, Long> {

    @Query("SELECT org " +
            "from OrgStructure org " +
            "where org.parent.id = ?1")
    Set<OrgStructure> findAllByParentId(long id);
}
