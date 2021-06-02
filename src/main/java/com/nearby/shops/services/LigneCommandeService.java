package com.nearby.shops.services;

import com.nearby.shops.dao.CrudDao;
import com.nearby.shops.models.LigneCommande;
import com.nearby.shops.repositories.LigneCommandeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class LigneCommandeService implements CrudDao<LigneCommande> {

    private final LigneCommandeRepository ligneCommandeRepository;

    @Autowired
    public LigneCommandeService(LigneCommandeRepository ligneCommandeRepository) {
        this.ligneCommandeRepository = ligneCommandeRepository;
    }
    @Override
    public Optional<LigneCommande> FindByID(Integer arg) {
        return this.ligneCommandeRepository.findById(arg);
    }
    @Override
    public LigneCommande Add(LigneCommande arg) {
        return this.ligneCommandeRepository.save(arg);
    }
    @Override
    public void DeleteById(Integer arg) {
    }
    @Override
    public LigneCommande Update(LigneCommande obj, Integer arg) {
        return this.ligneCommandeRepository.findById(arg)
                .map(item->{
                    item.setQuantite(obj.getQuantite());
                    item.setMontant(obj.getMontant());
                    return this.ligneCommandeRepository.save(item);
                }).orElseGet(()->{
                            obj.setIdLigneCommande(arg);
                            return this.ligneCommandeRepository.save(obj);
                        }
                );
    }
    @Override
    public List<LigneCommande> GetAll() {
        return (List<LigneCommande>)this.ligneCommandeRepository.findAll();
    }
}
