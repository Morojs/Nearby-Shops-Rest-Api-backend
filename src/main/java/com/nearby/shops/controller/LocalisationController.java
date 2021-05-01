package com.nearby.shops.controller;

import com.nearby.shops.models.Localisation;
import com.nearby.shops.services.LocalisationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "/api/v1/shops/localisation")
public class LocalisationController {
    private final LocalisationService localisationService;

    @Autowired
    public LocalisationController(LocalisationService localisationService) {
        this.localisationService = localisationService;
    }

    @GetMapping
    public List<Localisation> GetAll(){
        return this.localisationService.GetAll();
    }

    @GetMapping("/{id}")
    public Optional<Localisation> GetByID(@PathVariable Integer id) {return this.localisationService.FindByID(id);}

    @PostMapping
    public Localisation Add(@RequestBody Localisation nouvelleLocalisation) {
        return this.localisationService.Add(nouvelleLocalisation);
    }

    @DeleteMapping("/{id}")
    public void DeleteById(@PathVariable Integer id) {
        this.localisationService.DeleteById(id);
    }

    @PutMapping("/{id}")
    Localisation Update(@RequestBody Localisation nouvelleLocalisation, @PathVariable Integer id) {
        return this.localisationService.Update(nouvelleLocalisation,id);
    }
}
