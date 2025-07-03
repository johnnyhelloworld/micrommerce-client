package com.ecommerce.micrommerce.dao;

import com.ecommerce.micrommerce.model.ClientModel;
import com.ecommerce.micrommerce.repository.ClientRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class ClientDaoImpl implements ClientDao {
    
    @Autowired
    private ClientRepository clientRepository;
    
    // Méthode pour initialiser des données de test si nécessaire
    // Cette méthode peut être appelée au démarrage de l'application
    public void initData() {
        if (clientRepository.count() == 0) {
            clientRepository.save(new ClientModel(0, "Ordinateur portable", 150));
            clientRepository.save(new ClientModel(0, "Aspirateur Robot", 500));
            clientRepository.save(new ClientModel(0, "Table de Ping Pong", 750));
        }
    }
    
    @Override
    public List<ClientModel> findAll() {
        return clientRepository.findAll();
    }

    @Override
    public ClientModel findById(int id) {
        return clientRepository.findById(id).orElse(null);
    }

    @Override
    public ClientModel save(ClientModel client) {
        return clientRepository.save(client);
    }

    @Override
    public void delete(int id) {
        clientRepository.deleteById(id);
    }
}