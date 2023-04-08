package com.keepintouch.main.repository;

import com.keepintouch.main.model.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Long> {
}
