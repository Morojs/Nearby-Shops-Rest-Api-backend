package com.nearby.shops.controller;


import com.nearby.shops.models.Boutique;
import com.nearby.shops.services.BoutiqueService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path="/api/v1/shops/Boutique")
public class BoutiqueController {
    private final BoutiqueService boutiqueService;

    @Autowired
    public BoutiqueController(BoutiqueService boutiqueService) {
        this.boutiqueService = boutiqueService;
    }

    @GetMapping
    public List<Boutique> GetAll(){
        return this.boutiqueService.GetAll();
    }

    @GetMapping("/{id}")
    public Optional<Boutique> GetByID(@PathVariable Integer id) {return this.boutiqueService.FindByID(id);}

    @PostMapping
    public Boutique Add(@RequestBody Boutique nouvelleBoutique) {
        return this.boutiqueService.Add(nouvelleBoutique);
    }

    @DeleteMapping("/{id}")
    public void DeleteById(@PathVariable Integer id) {
        this.boutiqueService.DeleteById(id);
    }

    @PutMapping("/{id}")
    Boutique Update(@RequestBody Boutique nouvelleBoutique, @PathVariable Integer id) {
        return this.boutiqueService.Update(nouvelleBoutique,id);
    }

}
