package com.nearby.shops.controller;

import com.nearby.shops.models.Facture;
import com.nearby.shops.services.FactureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "/api/v1/shops/facture")
public class FactureController {
    private final FactureService factureService;

    @Autowired
    public FactureController(FactureService factureService) {
        this.factureService = factureService;
    }
    @GetMapping
    public List<Facture> GetAll() {
        return this.factureService.GetAll();
    }

    @GetMapping("/{id}")
    public Optional<Facture> GetByID(@PathVariable Integer id) {
        return this.factureService.FindByID(id);
    }

    @PostMapping
    public Facture Add(@RequestBody Facture nouvelleFacture) {
        return this.factureService.Add(nouvelleFacture);
    }

    @DeleteMapping("/{id}")
    public void DeleteById(@PathVariable Integer id) {
        this.factureService.DeleteById(id);
    }

    @PutMapping("/{id}")
    Facture Update(@RequestBody Facture nouvelleFacture, @PathVariable Integer id) {
        return this.factureService.Update(nouvelleFacture, id);
    }




}
