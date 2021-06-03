package com.nearby.shops.controller;

import com.nearby.shops.models.CarteBancaire;
import com.nearby.shops.services.CarteBancaireService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "/api/v1/shops/carte")
public class CarteBancaireController {
    private final CarteBancaireService carteBancaireService;

    @Autowired
    public CarteBancaireController(CarteBancaireService carteBancaireService) {
        this.carteBancaireService =carteBancaireService;
    }

    @GetMapping
    public List<CarteBancaire> GetAll(){
        return this.carteBancaireService.GetAll();
    }

    @GetMapping("/{id}")
    public Optional<CarteBancaire> GetByID(@PathVariable Long id) {return this.carteBancaireService.FindByID(id);}

    @PostMapping
    public CarteBancaire Add(@RequestBody CarteBancaire nouvelleCarteBancaire) {
        return this.carteBancaireService.Add(nouvelleCarteBancaire);
    }

    @DeleteMapping("/{id}")
    public void DeleteById(@PathVariable Long id) {
        this.carteBancaireService.DeleteById(id);
    }

    @PutMapping("/{id}")
    CarteBancaire Update(@RequestBody CarteBancaire nouvelleCarteBancaire, @PathVariable Long id) {
        return this.carteBancaireService.Update(nouvelleCarteBancaire,id);
    }
}
