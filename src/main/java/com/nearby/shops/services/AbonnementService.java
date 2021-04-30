package com.nearby.shops.services;

import com.nearby.shops.dao.CrudDao;
import com.nearby.shops.repositories.AbonnementRepository;
import com.nearby.shops.models.Abonnement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AbonnementService implements CrudDao<Abonnement> {

    private final AbonnementRepository abonnementRepository;

    @Autowired
    public AbonnementService(AbonnementRepository abonnementRepository) {
        this.abonnementRepository = abonnementRepository;
    }

    @Override
    public Optional<Abonnement> findByID(Integer arg) {
        return this.abonnementRepository.findById(arg);
    }

    @Override
    public Abonnement add(Abonnement arg) {
        return this.abonnementRepository.save(arg);
    }

    @Override
    public void deleteById(Integer arg) {
        this.abonnementRepository.deleteById(arg);
    }

    @Override
    public Abonnement update(Abonnement obj, Integer arg) {
            return this.abonnementRepository.findById(arg)
                    .map( item -> {
                        item.setDateAbonnement(obj.getDateAbonnement());
                        item.setPrixAbonnement(obj.getPrixAbonnement());
                        return this.abonnementRepository.save(item);
                    }).orElseGet(() -> {
                        obj.setId(arg);
                        return this.abonnementRepository.save(obj);
                    });
        }
    @Override
    public List<Abonnement> getAll() {
        return (List<Abonnement>) this.abonnementRepository.findAll();
    }
}
