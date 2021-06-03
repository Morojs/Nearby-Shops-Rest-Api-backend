package com.nearby.shops.services;

import com.nearby.shops.dao.CrudDao;
import com.nearby.shops.models.Produit;
import com.nearby.shops.repositories.ProduitRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProduitService implements CrudDao<Produit>{
    private final ProduitRepository produitRepository;

    @Autowired
    public ProduitService(ProduitRepository produitRepository) {
        this.produitRepository = produitRepository;
    }

    @Override
    public Optional<Produit> FindByID(Long arg) {
        return this.produitRepository.findById(arg);
    }

    @Override
    public Produit Add(Produit arg) {
        return produitRepository.save(arg);
    }

    @Override
    public void DeleteById(Long arg) {
        this.produitRepository.deleteById(arg);

    }

    @Override
    public Produit Update(Produit obj, Long arg) {
        return this.produitRepository.findById(arg)
                .map(item->{
                    item.setNom(obj.getNom());
                    item.setReference(obj.getReference());
                    item.setDescription(obj.getDescription());
                    item.setPrix(obj.getPrix());
                    item.setQteStock(obj.getQteStock());
                    item.setBoutique(obj.getBoutique());
                    item.setCategorie(obj.getCategorie());
                    item.setCommande(obj.getCommande());
                    return this.produitRepository.save(item);
                }).orElseGet(()->{
                            obj.setIdProduit(arg);
                            return this.produitRepository.save(obj);
                        }
                );
    }

    @Override
    public List<Produit> GetAll() {
        return (List<Produit>) this.produitRepository.findAll();
    }
}
