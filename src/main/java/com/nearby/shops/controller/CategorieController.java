package com.nearby.shops.controller;

import com.nearby.shops.models.Categorie;
import com.nearby.shops.services.CategorieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "/api/v1/shops/categorie")
public class CategorieController {
    private final CategorieService categorieService;

    @Autowired
    public CategorieController(CategorieService categorieService) {
        this.categorieService = categorieService;
    }

    @GetMapping
    public List<Categorie> GetAll(){
        return this.categorieService.GetAll();
    }

    @GetMapping("/{id}")
    public Optional<Categorie> GetByID(@PathVariable Long id) {return this.categorieService.FindByID(id);}

    @PostMapping
    public Categorie Add(@RequestBody Categorie nouvelleCategorie) {
        return this.categorieService.Add(nouvelleCategorie);
    }

    @DeleteMapping("/{id}")
    public void DeleteById(@PathVariable Long id) {
        this.categorieService.DeleteById(id);
    }

    @PutMapping("/{id}")
    Categorie Update(@RequestBody Categorie nouvelleCategorie, @PathVariable Long id) {
        return this.categorieService.Update(nouvelleCategorie,id);
    }
}
