package com.nearby.shops.services;

import com.nearby.shops.dao.CrudDao;
import com.nearby.shops.models.Localisation;
import com.nearby.shops.repositories.LocalisationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LocalisationService implements CrudDao<Localisation> {
    private final LocalisationRepository localisationRepository;

    @Autowired
    public LocalisationService(LocalisationRepository localisationRepository) {
        this.localisationRepository = localisationRepository;
    }

    @Override
    public Optional<Localisation> FindByID(Integer arg) {
        return this.localisationRepository.findById(arg);
    }

    @Override
    public Localisation Add(Localisation arg) {
        return localisationRepository.save(arg);
    }

    @Override
    public void DeleteById(Integer arg) {
        this.localisationRepository.deleteById(arg);

    }

    @Override
    public Localisation Update(Localisation obj, Integer arg) {
        return this.localisationRepository.findById(arg)
                .map(item->{
                    item.setAltitude(obj.getAltitude());
                    item.setLangitude(obj.getLangitude());
                    return this.localisationRepository.save(item);
                }).orElseGet(()->{
                            obj.setId(arg);
                            return this.localisationRepository.save(obj);
                        }
                );
    }

    @Override
    public List<Localisation> GetAll() {
        return (List<Localisation>) this.localisationRepository.findAll();
    }
}
