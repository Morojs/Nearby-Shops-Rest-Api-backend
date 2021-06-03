package com.nearby.shops.services;

import com.nearby.shops.dao.CrudDao;
import com.nearby.shops.models.Boutique;
import com.nearby.shops.repositories.BoutiqueRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class BoutiqueService implements CrudDao<Boutique> {
    private BoutiqueRepository boutiqueRepository;

    @Autowired
    public BoutiqueService(BoutiqueRepository boutiqueRepository) {
        this.boutiqueRepository = boutiqueRepository;
    }

    @Override
    public Optional<Boutique> FindByID(Long arg) {
        return this.boutiqueRepository.findById(arg);
    }

    @Override
    public Boutique Add(Boutique arg) {
        return this.boutiqueRepository.save(arg);
    }

    @Override
    public void DeleteById(Long arg) {
        this.boutiqueRepository.deleteById(arg);
    }

    @Override
    public Boutique Update(Boutique obj, Long arg) {
        return this.boutiqueRepository.findById(arg)
                .map( item -> {
                    item.setNomBoutique(obj.getNomBoutique());
                    item.setDescription(obj.getDescription());
                    item.setAdresseBoutique(obj.getAdresseBoutique());
                    item.setSiteWeb(obj.getSiteWeb());
                    item.setDateCreation(obj.getDateCreation());
                    item.setClientAbonne(obj.getClientAbonne());
                    item.setLocalisation(obj.getLocalisation());
                    item.setVille(obj.getVille());
                    return this.boutiqueRepository.save(item);
                }).orElseGet(() -> {
                    obj.setIdBoutique(arg);
                    return this.boutiqueRepository.save(obj);
                });
    }
    @Override
    public List<Boutique> GetAll() {
        return (List<Boutique>) this.boutiqueRepository.findAll();
    }
}
