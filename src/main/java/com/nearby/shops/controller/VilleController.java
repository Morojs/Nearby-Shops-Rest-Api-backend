package com.nearby.shops.controller;

import com.nearby.shops.models.Ville;
import com.nearby.shops.services.VilleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "/api/v1/shops/ville")
public class VilleController {
    private final VilleService villeService;

    @Autowired
    public VilleController(VilleService villeService) {
        this.villeService = villeService;
    }

    @GetMapping
    public List<Ville> GetAll(){
        return this.villeService.GetAll();
    }

    @GetMapping("/{id}")
    public Optional<Ville> GetByID(@PathVariable Integer id) {return this.villeService.FindByID(id);}

    @PostMapping
    public Ville Add(@RequestBody Ville nouvelleVille) {
        return this.villeService.Add(nouvelleVille);
    }

    @DeleteMapping("/{id}")
    public void DeleteById(@PathVariable Integer id) {
        this.villeService.DeleteById(id);
    }

    @PutMapping("/{id}")
    Ville Update(@RequestBody Ville nouvelleVille, @PathVariable Integer id) {
        return this.villeService.Update(nouvelleVille,id);
    }
}
