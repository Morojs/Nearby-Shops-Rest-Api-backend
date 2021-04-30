package com.nearby.shops.controller;
import com.nearby.shops.models.Personne;
import com.nearby.shops.services.PersonneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/api/v1/shops/personne")
public class PersonneController {
    private final PersonneService personneService;

    @Autowired
    public PersonneController(PersonneService personneService) {
        this.personneService = personneService;
    }

    @GetMapping
    public List<Personne> GetAll(){
        return this.personneService.getAll();
    }

    @PostMapping
    public Personne Add(@RequestBody Personne nouvelPersonne) {
        return this.personneService.add(nouvelPersonne);
    }

    @DeleteMapping("/personne/{id}")
    public void DeleteById(@PathVariable Integer id) {
        this.personneService.deleteById(id);
    }

    @PutMapping("/personne/{id}")
    Personne update(@RequestBody Personne nouvellePersonne, @PathVariable Integer id) {
        return this.personneService.update(nouvellePersonne,id);
    }
}
