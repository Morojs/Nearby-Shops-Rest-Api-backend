package com.nearby.shops.controller;

import com.nearby.shops.models.Livraison;
import com.nearby.shops.services.LivraisonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "/api/v1/shops/livraison")
public class LivraisonController {
    private final LivraisonService livraisonService;

    @Autowired
    public LivraisonController(LivraisonService livraisonService) {
        this.livraisonService = livraisonService;
    }

    @GetMapping
    public List<Livraison> GetAll(){
        return this.livraisonService.GetAll();
    }

    @GetMapping("/{id}")
    public Optional<Livraison> GetByID(@PathVariable Integer id) {return this.livraisonService.FindByID(id);}

    @PostMapping
    public Livraison Add(@RequestBody Livraison nouvelleLivraison) {
        return this.livraisonService.Add(nouvelleLivraison);
    }

    @DeleteMapping("/{id}")
    public void DeleteById(@PathVariable Integer id) {
        this.livraisonService.DeleteById(id);
    }

    @PutMapping("/{id}")
    Livraison Update(@RequestBody Livraison nouvelleLivraison, @PathVariable Integer id) {
        return this.livraisonService.Update(nouvelleLivraison,id);
    }
}
