package com.devsuperior.challenge.repositories;

import com.devsuperior.challenge.entities.Client;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientRepository extends JpaRepository<Client, Long> {
}
