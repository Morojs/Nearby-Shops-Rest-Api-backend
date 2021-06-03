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
    public Optional<Abonnement> FindByID(Long arg) {
        return this.abonnementRepository.findById(arg);
    }

    @Override
    public Abonnement Add(Abonnement arg) {
        return this.abonnementRepository.save(arg);
    }

    @Override
    public void DeleteById(Long arg) {
        this.abonnementRepository.deleteById(arg);
    }

    @Override
    public Abonnement Update(Abonnement obj, Long arg) {
            return this.abonnementRepository.findById(arg)
                    .map( item -> {
                        item.setDateAbonnement(obj.getDateAbonnement());
                        item.setDescription(obj.getDescription());
                        item.setPrixAbonnement(obj.getPrixAbonnement());
                        return this.abonnementRepository.save(item);
                    }).orElseGet(() -> {
                        obj.setIdAbonnement(arg);
                        return this.abonnementRepository.save(obj);
                    });
        }
    @Override
    public List<Abonnement> GetAll() {
        return (List<Abonnement>) this.abonnementRepository.findAll();
    }
}
