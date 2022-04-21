package com.kashigin.stanislav.dao.repository;

import com.kashigin.stanislav.entity.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Long> {
}
