package com.kashigin.stanislav.dao.repository;

import com.kashigin.stanislav.entity.OrgStructure;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrgStructureRepository extends CrudRepository<OrgStructure, Long> {
}
