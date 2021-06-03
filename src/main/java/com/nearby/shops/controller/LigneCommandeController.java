package com.nearby.shops.controller;

import com.nearby.shops.models.LigneCommande;
import com.nearby.shops.services.LigneCommandeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "/api/v1/shops/ligneCommande")
public class LigneCommandeController {
    private final LigneCommandeService ligneCommandeService;

    @Autowired
    public LigneCommandeController(LigneCommandeService ligneCommandeService) {
        this.ligneCommandeService = ligneCommandeService;
    }

    @GetMapping
    public List<LigneCommande> GetAll(){
        return this.ligneCommandeService.GetAll();
    }

    @GetMapping("/{id}")
    public Optional<LigneCommande> GetByID(@PathVariable Long id) {return this.ligneCommandeService.FindByID(id);}

    @PostMapping
    public LigneCommande Add(@RequestBody LigneCommande nouvelleLigneCommande) {
        return this.ligneCommandeService.Add(nouvelleLigneCommande);
    }

    @DeleteMapping("/{id}")
    public void DeleteById(@PathVariable Long id) {
        this.ligneCommandeService.DeleteById(id);
    }

    @PutMapping("/{id}")
    LigneCommande Update(@RequestBody LigneCommande nouvelleLigneCommande, @PathVariable Long id) {
        return this.ligneCommandeService.Update(nouvelleLigneCommande,id);
    }

}
