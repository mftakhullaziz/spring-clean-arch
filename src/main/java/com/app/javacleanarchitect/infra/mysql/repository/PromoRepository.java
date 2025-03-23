package com.app.javacleanarchitect.infra.mysql.repository;

import com.app.javacleanarchitect.infra.mysql.persistence.PromoPersistence;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PromoRepository extends JpaRepository<PromoPersistence, Integer> {
}
