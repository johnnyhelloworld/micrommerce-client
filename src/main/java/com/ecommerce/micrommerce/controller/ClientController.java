package com.ecommerce.micrommerce.controller;

import com.ecommerce.micrommerce.dao.ClientDao;
import com.ecommerce.micrommerce.model.ClientModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/clients")
public class ClientController {

    @Autowired
    private ClientDao clientDao;

    // READ - Récupérer tous les clients
    @GetMapping
    public List<ClientModel> listeClients() {
        return clientDao.findAll();
    }

    // READ - Récupérer un client par son ID
    @GetMapping("/{id}")
    public ResponseEntity<ClientModel> afficherUnClient(@PathVariable int id) {
        ClientModel client = clientDao.findById(id);
        if (client == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(client, HttpStatus.OK);
    }

    // CREATE - Ajouter un nouveau client
    @PostMapping
    public ResponseEntity<ClientModel> ajouterClient(@RequestBody ClientModel client) {
        ClientModel nouveauClient = clientDao.save(client);
        return new ResponseEntity<>(nouveauClient, HttpStatus.CREATED);
    }

    // UPDATE - Modifier un client existant
    @PutMapping("/{id}")
    public ResponseEntity<ClientModel> modifierClient(@PathVariable int id, @RequestBody ClientModel client) {
        ClientModel clientExistant = clientDao.findById(id);
        if (clientExistant == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        
        // Mise à jour des propriétés
        clientExistant.setName(client.getName());
        clientExistant.setPrice(client.getPrice());
        
        // Sauvegarde des modifications en utilisant la méthode save() du DAO
        ClientModel clientMisAJour = clientDao.save(clientExistant);
        
        return new ResponseEntity<>(clientMisAJour, HttpStatus.OK);
    }

    // DELETE - Supprimer un client
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> supprimerClient(@PathVariable int id) {
        ClientModel clientExistant = clientDao.findById(id);
        if (clientExistant == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        
        // Suppression du client en utilisant la méthode delete du DAO
        clientDao.delete(id);
        
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}