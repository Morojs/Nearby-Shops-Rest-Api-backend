package com.nearby.shops.services;

import com.nearby.shops.dao.CrudDao;
import com.nearby.shops.models.Commande;
import com.nearby.shops.repositories.CommandeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CommandeService implements CrudDao<Commande> {

    private final CommandeRepository commandeRepository;

    @Autowired
    public CommandeService(CommandeRepository commandeRepository) {
        this.commandeRepository = commandeRepository;
    }

    @Override
    public Optional<Commande> FindByID(Long arg) {
        return this.commandeRepository.findById(arg);
    }

    @Override
    public Commande Add(Commande arg) {
        return this.commandeRepository.save(arg);
    }

    @Override
    public void DeleteById(Long arg) {
        this.commandeRepository.deleteById(arg);
    }

    @Override
    public Commande Update(Commande obj, Long arg) {
        return this.commandeRepository.findById(arg)
                .map(item->{
                    item.setDateCommande(obj.getDateCommande());
                    item.setEtatCommande(obj.isEtatCommande());
                    item.setPersonne(obj.getPersonne());
                    return this.commandeRepository.save(item);
                }).orElseGet(()->{
                            obj.setIdCommande(arg);
                            return this.commandeRepository.save(obj);
                        }
                );
    }
    @Override
    public List<Commande> GetAll() {
        return (List<Commande>) this.commandeRepository.findAll();
    }
}
