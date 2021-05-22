package com.nearby.shops.services;

import com.nearby.shops.dao.CrudDao;
import com.nearby.shops.models.CarteBancaire;
import com.nearby.shops.repositories.CarteBancaireRepository;
import com.nearby.shops.repositories.PersonneRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;

public class CarteBancaireService implements CrudDao<CarteBancaire> {
    private final CarteBancaireRepository carteBancaireRepository;
    @Autowired
    public CarteBancaireService(CarteBancaireRepository carteBancaireRepository) {
        this.carteBancaireRepository = carteBancaireRepository;
    }
    @Override
    public Optional<CarteBancaire> FindByID(Integer arg) {
        return this.carteBancaireRepository.findById(arg);
    }

    @Override
    public CarteBancaire Add(CarteBancaire arg) {
        return this.carteBancaireRepository.save(arg);
    }

    @Override
    public void DeleteById(Integer arg) {
        this.carteBancaireRepository.deleteById(arg);

    }

    @Override
    public CarteBancaire Update(CarteBancaire obj, Integer arg) {
        return this.carteBancaireRepository.findById(arg)
                .map(item ->{
                    item.setDatepayment(obj.getDatepayment());
                    item.setNomSurCarte(obj.getNomSurCarte());
                    item.setNumCarte(obj.getNumCarte());
                    item.setDateExperation(obj.getDateExperation());
                    item.setCvv(obj.getCvv());
                    item.setType(obj.getType());
                    return this.carteBancaireRepository.save(item);

                }).orElseGet(()->{
                    obj.setId(arg);
                    return this.carteBancaireRepository.save(obj);
                });
    }

    @Override
    public List<CarteBancaire> GetAll() {
        return (List<CarteBancaire>) this.carteBancaireRepository.findAll();
    }
}
