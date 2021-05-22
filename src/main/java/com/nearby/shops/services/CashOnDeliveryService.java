package com.nearby.shops.services;

import com.nearby.shops.dao.CrudDao;
import com.nearby.shops.models.CashOnDelivery;
import com.nearby.shops.repositories.CashOnDeliveryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class CashOnDeliveryService implements CrudDao<CashOnDelivery> {
    private final CashOnDeliveryRepository cashOnDeliveryRepository;
    @Autowired
    public CashOnDeliveryService(CashOnDeliveryRepository cashOnDeliveryRepository){
        this.cashOnDeliveryRepository=cashOnDeliveryRepository;
    }
    @Override
    public Optional<CashOnDelivery> FindByID(Integer arg) {
        return this.cashOnDeliveryRepository.findById(arg);
    }

    @Override
    public CashOnDelivery Add(CashOnDelivery arg) {
        return this.cashOnDeliveryRepository.save(arg);
    }

    @Override
    public void DeleteById(Integer arg) {
        this.cashOnDeliveryRepository.deleteById(arg);

    }

    @Override
    public CashOnDelivery Update(CashOnDelivery obj, Integer arg) {
        return this.cashOnDeliveryRepository.findById(arg)
                .map(item->{
                    item.setDatePayment(obj.getDatePayment());
                    item.setNumCash((obj.getNumCash()));
                    item.setNomLivreur(obj.getNomLivreur());
                    item.setCinClient(obj.getCinClient());
                    item.setDateLivraison(obj.getDateLivraison());
                    item.setMontant(obj.getMontant());
                    return this.cashOnDeliveryRepository.save(item);
                }).orElseGet(()->{
                    obj.setIdPayement(arg);
                    return this.cashOnDeliveryRepository.save(obj);
                });
    }

    @Override
    public List<CashOnDelivery> GetAll() {
        return (List<CashOnDelivery>) this.cashOnDeliveryRepository.findAll();
    }
}
