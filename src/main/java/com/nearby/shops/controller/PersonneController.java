package com.nearby.shops.controller;
import com.nearby.shops.models.Personne;
import com.nearby.shops.services.PersonneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

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
        return this.personneService.GetAll();
    }
    @GetMapping("/{id}")
    public Optional<Personne> GetByID(@PathVariable Integer id){
        return this.personneService.FindByID(id);
    }

    @PostMapping
    public Personne Add(@RequestBody Personne nouvelPersonne) {
        return this.personneService.Add(nouvelPersonne);
    }

    @DeleteMapping("/{id}")
    public void DeleteById(@PathVariable Integer id) {
        this.personneService.DeleteById(id);
    }

    @PutMapping("/{id}")
    Personne Update(@RequestBody Personne nouvellePersonne, @PathVariable Integer id) {
        return this.personneService.Update(nouvellePersonne,id);
    }
}
