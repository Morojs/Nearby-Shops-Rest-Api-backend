package com.nearby.shops.services;

import com.nearby.shops.dao.CrudDao;
import com.nearby.shops.models.Categorie;
import com.nearby.shops.repositories.CategorieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategorieService implements CrudDao<Categorie>{
    private final CategorieRepository categorieRepository;

    @Autowired
    public CategorieService(CategorieRepository categorieRepository) {
        this.categorieRepository = categorieRepository;
    }

    @Override
    public Optional<Categorie> FindByID(Integer arg) {
        return this.categorieRepository.findById(arg);
    }

    @Override
    public Categorie Add(Categorie arg) {
        return categorieRepository.save(arg);
    }

    @Override
    public void DeleteById(Integer arg) {
        this.categorieRepository.deleteById(arg);

    }

    @Override
    public Categorie Update(Categorie obj, Integer arg) {
        return this.categorieRepository.findById(arg)
                .map(item->{
                    item.setNomCategorie(obj.getNomCategorie());
                    item.setDesignation(obj.getDesignation());
                    return this.categorieRepository.save(item);
                }).orElseGet(()->{
                            obj.setId(arg);
                            return this.categorieRepository.save(obj);
                        }
                );
    }

    @Override
    public List<Categorie> GetAll() {
        return (List<Categorie>) this.categorieRepository.findAll();
    }
}
