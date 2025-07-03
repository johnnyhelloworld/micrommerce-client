package com.ecommerce.micrommerce.dao;

import com.ecommerce.micrommerce.model.ClientModel;
import java.util.List;

public interface ClientDao {
    List<ClientModel> findAll();
    ClientModel findById(int id);
    ClientModel save(ClientModel client);
    void delete(int id);
}