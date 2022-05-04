package com.zappts.api.repository;

import com.zappts.api.models.Carta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CartaReposytory extends JpaRepository<Carta, Long> {
}
