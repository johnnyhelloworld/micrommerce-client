package com.ecommerce.micrommerce.repository;

import com.ecommerce.micrommerce.model.ClientModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClientRepository extends JpaRepository<ClientModel, Integer> {
    // Spring Data JPA génère automatiquement les méthodes CRUD de base
    // Vous pouvez ajouter des méthodes personnalisées ici si nécessaire
}