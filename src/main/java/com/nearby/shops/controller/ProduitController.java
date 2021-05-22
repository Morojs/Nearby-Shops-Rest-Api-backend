package com.nearby.shops.controller;

import com.nearby.shops.models.Produit;
import com.nearby.shops.services.ProduitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "/api/v1/shops/produit")
public class ProduitController {
    private final ProduitService produitService;

    @Autowired
    public ProduitController(ProduitService produitService) {
        this.produitService = produitService;
    }

    @GetMapping
    public List<Produit> GetAll(){
        return this.produitService.GetAll();
    }

    @GetMapping("/{id}")
    public Optional<Produit> GetByID(@PathVariable Integer id) {return this.produitService.FindByID(id);}

    @PostMapping
    public Produit Add(@RequestBody Produit nouvelleProduit) {
        return this.produitService.Add(nouvelleProduit);
    }

    @DeleteMapping("/{id}")
    public void DeleteById(@PathVariable Integer id) {
        this.produitService.DeleteById(id);
    }

    @PutMapping("/{id}")
    Produit Update(@RequestBody Produit nouvelleProduit, @PathVariable Integer id) {
        return this.produitService.Update(nouvelleProduit,id);
    }
}
