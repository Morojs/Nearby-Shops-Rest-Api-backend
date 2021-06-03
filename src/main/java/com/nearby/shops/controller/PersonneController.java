package com.nearby.shops.controller;
import com.nearby.shops.models.Personne;
import com.nearby.shops.services.PersonneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "/api/v1/shops/personne",consumes = MediaType.APPLICATION_JSON_VALUE)
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
    public Optional<Personne> GetByID(@PathVariable Long id){
        return this.personneService.FindByID(id);
    }

    @PostMapping
    public Personne Add(@RequestBody Personne nouvellePersonne) {
        return this.personneService.Add(nouvellePersonne);
    }

    @DeleteMapping("/{id}")
    public void DeleteById(@PathVariable Long id) {
        this.personneService.DeleteById(id);
    }

    @PutMapping("/{id}")
    Personne Update(@RequestBody Personne nouvellePersonne, @PathVariable Long id) {
        return this.personneService.Update(nouvellePersonne,id);
    }
}
