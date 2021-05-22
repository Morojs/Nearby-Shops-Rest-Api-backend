package com.nearby.shops.services;

import com.nearby.shops.dao.CrudDao;
import com.nearby.shops.models.Payment;
import com.nearby.shops.models.Personne;
import com.nearby.shops.repositories.PaymentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PaymentService implements CrudDao<Payment> {
    private final PaymentRepository paymentRepository;

    @Autowired
    public PaymentService(PaymentRepository paymentRepository) {
        this.paymentRepository = paymentRepository;
    }

    @Override
    public Optional<Payment> FindByID(Integer arg) {
        return this.paymentRepository.findById(arg);
    }

    @Override
    public Payment Add(Payment arg) {
        return this.paymentRepository.save(arg);
    }

    @Override
    public void DeleteById(Integer arg) {
        this.paymentRepository.deleteById(arg);
    }

    @Override
    public Payment Update(Payment obj, Integer arg) {
        return this.paymentRepository.findById(arg)
                .map( item -> {
                    item.setDatepayment(obj.getDatepayment());
                    return this.paymentRepository.save(item);
                }).orElseGet(() -> {
                    obj.setId(arg);
                    return this.paymentRepository.save(obj);
                });
    }

    @Override
    public List<Payment> GetAll() {
        return (List<Payment>) this.paymentRepository.findAll();
    }


}
