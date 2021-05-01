package com.nearby.shops.services;

import com.nearby.shops.dao.CrudDao;
import com.nearby.shops.models.Ville;
import com.nearby.shops.repositories.VilleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class VilleService implements CrudDao<Ville> {

    private final VilleRepository villeRepository;

    @Autowired
    public VilleService(VilleRepository villeRepository) {
        this.villeRepository = villeRepository;
    }

    @Override
    public Optional<Ville> FindByID(Integer arg) {
        return this.villeRepository.findById(arg);
    }

    @Override
    public Ville Add(Ville arg) {
        return this.villeRepository.save(arg);
    }

    @Override
    public void DeleteById(Integer arg) {
        this.villeRepository.deleteById(arg);
    }

    @Override
    public Ville Update(Ville obj, Integer arg) {
        return this.villeRepository.findById(arg)
                .map(item->{
                    item.setNomVille(obj.getNomVille());
                    return this.villeRepository.save(item);
                }).orElseGet(()->{
                    obj.setId(arg);
                    return this.villeRepository.save(obj);
                        }
                        );
    }

    @Override
    public List<Ville> GetAll() {
        return (List<Ville>) this.villeRepository.findAll() ;
    }
}
