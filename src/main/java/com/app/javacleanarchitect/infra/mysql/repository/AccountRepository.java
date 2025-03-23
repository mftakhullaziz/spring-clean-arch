package com.app.javacleanarchitect.infra.mysql.repository;

import com.app.javacleanarchitect.infra.mysql.persistence.AccountPersistence;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountRepository extends JpaRepository<AccountPersistence, Integer> {
    boolean existsByUsername(String username);
    boolean existsByEmail(String email);
}
