package com.nearby.shops.controller;

import com.nearby.shops.models.Abonnement;
import com.nearby.shops.services.AbonnementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/api/v1/shops/abonnement")
public class AbonnementController {

    private final AbonnementService abonnementService;

    @Autowired
    public AbonnementController(AbonnementService abonnementService) {
        this.abonnementService = abonnementService;
    }

    @GetMapping
    public List<Abonnement> GetAll(){
        return this.abonnementService.getAll();
    }

    @PostMapping
    public Abonnement Add(@RequestBody Abonnement nouvelAbonnement) {
        return this.abonnementService.add(nouvelAbonnement);
    }

    @DeleteMapping("/abonnement/{id}")
    public void DeleteById(@PathVariable Integer id) {
         this.abonnementService.deleteById(id);
    }

    @PutMapping("/abonnement/{id}")
    Abonnement update(@RequestBody Abonnement nouvelAbonnemnt, @PathVariable Integer id) {
        return this.abonnementService.update(nouvelAbonnemnt,id);
    }




}
