package com.nearby.shops.repositories;

import com.nearby.shops.models.Commande;
import org.springframework.data.repository.CrudRepository;

public interface CommandeRepository extends CrudRepository<Commande,Long> {
}
