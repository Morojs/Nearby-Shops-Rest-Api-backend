package com.nearby.shops.controller;

import com.nearby.shops.models.CashOnDelivery;
import com.nearby.shops.services.CashOnDeliveryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "/api/v1/shops/cashDelivery")
public class CashOnDeliveryController {
    private final CashOnDeliveryService cashOnDeliveryService;
    @Autowired
    public CashOnDeliveryController(CashOnDeliveryService cashOnDeliveryService){
        this.cashOnDeliveryService=cashOnDeliveryService;
    }

    @GetMapping
    public List<CashOnDelivery> GetAll(){
        return this.cashOnDeliveryService.GetAll();
    }

    @GetMapping("/{id}")
    public Optional<CashOnDelivery> GetByID(@PathVariable Long id) {return this.cashOnDeliveryService.FindByID(id);}

    @PostMapping
    public CashOnDelivery Add(@RequestBody CashOnDelivery nouveauCashOnDelivery) {
        return this.cashOnDeliveryService.Add(nouveauCashOnDelivery);
    }

    @DeleteMapping("/{id}")
    public void DeleteById(@PathVariable Long id) {
        this.cashOnDeliveryService.DeleteById(id);
    }

    @PutMapping("/{id}")
    CashOnDelivery Update(@RequestBody CashOnDelivery nouveauCashOnDelivery, @PathVariable Long id) {
        return this.cashOnDeliveryService.Update(nouveauCashOnDelivery,id);
    }

}
