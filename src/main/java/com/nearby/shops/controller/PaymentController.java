package com.nearby.shops.controller;


import com.nearby.shops.models.Payment;
import com.nearby.shops.services.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "/api/v1/shops/payment")
public class PaymentController {
    private final PaymentService paymentService;

    @Autowired
    public PaymentController(PaymentService paymentService) {
        this.paymentService =paymentService;
    }

    @GetMapping
    public List<Payment> GetAll(){
        return this.paymentService.GetAll();
    }

    @GetMapping("/{id}")
    public Optional<Payment> GetByID(@PathVariable Integer id) {return this.paymentService.FindByID(id);}

    @PostMapping
    public Payment Add(@RequestBody Payment nouveauPayment) {
        return this.paymentService.Add(nouveauPayment);
    }

    @DeleteMapping("/{id}")
    public void DeleteById(@PathVariable Integer id) {
        this.paymentService.DeleteById(id);
    }

    @PutMapping("/{id}")
    Payment Update(@RequestBody Payment nouveauPayment, @PathVariable Integer id) {
        return this.paymentService.Update(nouveauPayment,id);
    }
}
