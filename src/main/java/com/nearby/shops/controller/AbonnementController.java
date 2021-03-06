package com.nearby.shops.controller;

import com.nearby.shops.models.Abonnement;
import com.nearby.shops.services.AbonnementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

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
        return this.abonnementService.GetAll();
    }

    @GetMapping("/{id}")
    public Optional<Abonnement> GetByID(@PathVariable Long id) {return this.abonnementService.FindByID(id);}

    @PostMapping
    public Abonnement Add(@RequestBody Abonnement nouvelAbonnement) {
        return this.abonnementService.Add(nouvelAbonnement);
    }

    @DeleteMapping("/{id}")
    public void DeleteById(@PathVariable Long id) {
         this.abonnementService.DeleteById(id);
    }

    @PutMapping("/{id}")
    Abonnement Update(@RequestBody Abonnement nouvelAbonnemnt, @PathVariable Long id) {
        return this.abonnementService.Update(nouvelAbonnemnt,id);
    }




}
