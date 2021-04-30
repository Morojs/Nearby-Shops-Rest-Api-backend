package com.nearby.shops.services;

import com.nearby.shops.dao.CrudDao;
import com.nearby.shops.repositories.PersonneRepository;
import com.nearby.shops.models.Personne;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonneService implements CrudDao<Personne> {

    private final PersonneRepository personneRepository;

    @Autowired
    public PersonneService(PersonneRepository personneRepository) {
        this.personneRepository = personneRepository;
    }

    @Override
    public Personne add(Personne arg) {
        return this.personneRepository.save(arg);
    }

    @Override
    public void deleteById(Integer arg) {
        this.personneRepository.deleteById(arg);
    }

    @Override
    public Personne update(Personne obj, Integer arg) {
        return this.personneRepository.findById(arg)
                .map( item -> {
                    item.setNom(obj.getNom());
                    item.setPrenom(obj.getNom());
                    item.setDateNaissance(obj.getDateNaissance());
                    item.setMotDePasse(obj.getMotDePasse());
                    item.setPays(obj.getPays());
                    item.setAdresse_1(obj.getAdresse_1());
                    item.setAdresse_2(obj.getAdresse_2());
                    item.setCodePostal(obj.getCodePostal());
                    item.setTelephone(obj.getTelephone());
                    item.setFix(obj.getFix());
                    return this.personneRepository.save(item);
                }).orElseGet(() -> {
                    obj.setId(arg);
                    return this.personneRepository.save(obj);
                });
    }
    @Override
    public List<Personne> getAll() {
        return (List<Personne>) this.personneRepository.findAll();
    }

}
