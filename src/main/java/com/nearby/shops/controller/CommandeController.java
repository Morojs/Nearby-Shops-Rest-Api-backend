package com.nearby.shops.controller;

import com.nearby.shops.models.Commande;
import com.nearby.shops.services.CommandeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "/api/v1/shops/commande")
public class CommandeController {
    private final CommandeService commandeService;

    @Autowired
    public CommandeController(CommandeService commandeService) {
        this.commandeService = commandeService;
    }

    @GetMapping
    public List<Commande> GetAll() {
        return this.commandeService.GetAll();
    }

    @GetMapping("/{id}")
    public Optional<Commande> GetByID(@PathVariable Long id) {
        return this.commandeService.FindByID(id);
    }

    @PostMapping
    public Commande Add(@RequestBody Commande nouvelleCommande) {
        return this.commandeService.Add(nouvelleCommande);
    }

    @DeleteMapping("/{id}")
    public void DeleteById(@PathVariable Long id) {
        this.commandeService.DeleteById(id);
    }

    @PutMapping("/{id}")
    Commande Update(@RequestBody Commande nouvelleCommande, @PathVariable Long id) {
        return this.commandeService.Update(nouvelleCommande, id);
    }

}
