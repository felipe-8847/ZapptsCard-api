package com.zappts.api.repository;

import com.zappts.api.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserReposytory extends JpaRepository<User, Long> {
}
