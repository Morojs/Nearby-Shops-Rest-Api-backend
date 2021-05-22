package com.nearby.shops.services;

import com.nearby.shops.dao.CrudDao;
import com.nearby.shops.models.Facture;
import com.nearby.shops.repositories.FactureRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FactureService implements CrudDao<Facture> {

    private final FactureRepository factureRepository;

    @Autowired
    public FactureService(FactureRepository factureRepository) {
        this.factureRepository = factureRepository;
    }

    @Override
    public Optional<Facture> FindByID(Integer arg) {
        return this.factureRepository.findById(arg);
    }

    @Override
    public Facture Add(Facture arg) {
        return this.factureRepository.save(arg);
    }

    @Override
    public void DeleteById(Integer arg) {
        this.factureRepository.deleteById(arg);
    }
    @Override
    public Facture Update(Facture obj, Integer arg) {
        return this.factureRepository.findById(arg)
                .map(item->{
                    item.setDateFcture(obj.getDateFcture());
                    item.setMontantFacture(obj.getMontantFacture());
                    item.setCommande(obj.getCommande());
                    item.setPayment(obj.getPayment());
                    return this.factureRepository.save(item);
                }).orElseGet(()->{
                            obj.setIdFacture(arg);
                            return this.factureRepository.save(obj);
                        }
                );
    }
    @Override
    public List<Facture> GetAll() {
        return (List<Facture>) this.factureRepository.findAll();
    }
}
