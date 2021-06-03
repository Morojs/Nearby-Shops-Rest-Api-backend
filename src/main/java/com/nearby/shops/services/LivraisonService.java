package com.nearby.shops.services;

import com.nearby.shops.dao.CrudDao;
import com.nearby.shops.models.Livraison;
import com.nearby.shops.repositories.LivraisonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LivraisonService implements CrudDao<Livraison> {
    private final LivraisonRepository livraisonRepository;

    @Autowired
    public LivraisonService(LivraisonRepository livraisonRepository) {
        this.livraisonRepository = livraisonRepository;
    }

    @Override
    public Optional<Livraison> FindByID(Long arg) {
        return this.livraisonRepository.findById(arg);
    }

    @Override
    public Livraison Add(Livraison arg) {
        return livraisonRepository.save(arg);
    }

    @Override
    public void DeleteById(Long arg) {
        this.livraisonRepository.deleteById(arg);

    }

    @Override
    public Livraison Update(Livraison obj, Long arg) {
        return this.livraisonRepository.findById(arg)
                .map(item->{
                    item.setDateLivraison(obj.getDateLivraison());
                    item.setIdCommande(obj.getIdCommande());
                    return this.livraisonRepository.save(item);
                }).orElseGet(()->{
                            obj.setIdLivraison(arg);
                            return this.livraisonRepository.save(obj);
                        }
                );
    }

    @Override
    public List<Livraison> GetAll() {
        return (List<Livraison>) this.livraisonRepository.findAll();
    }
}
