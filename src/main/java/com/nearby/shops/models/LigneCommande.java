package com.nearby.shops.models;

import org.springframework.stereotype.Service;

import javax.persistence.*;

@Entity

public class LigneCommande {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer idLigneCommande;

    @ManyToOne
    @JoinColumn(name = "idProduit")
    private Produit produit;

    @ManyToOne
    @JoinColumn(name = "idCommande")
    private Commande commande;

    private Double montant;
    private Integer quantite;

    public LigneCommande() {
    }

    public LigneCommande(Integer idLigneCommande, Produit produit, Commande commande, Double montant, Integer quantite) {
        this.idLigneCommande = idLigneCommande;
        this.produit = produit;
        this.commande = commande;
        this.montant = montant;
        this.quantite = quantite;
    }

    public LigneCommande(Produit produit, Commande commande, Double montant, Integer quantite) {
        this.produit = produit;
        this.commande = commande;
        this.montant = montant;
        this.quantite = quantite;
    }

    public Integer getIdLigneCommande() {
        return idLigneCommande;
    }

    public void setIdLigneCommande(Integer idLigneCommande) {
        this.idLigneCommande = idLigneCommande;
    }

    public Produit getProduit() {
        return produit;
    }

    public void setProduit(Produit produit) {
        this.produit = produit;
    }

    public Commande getCommande() {
        return commande;
    }

    public void setCommande(Commande commande) {
        this.commande = commande;
    }

    public Double getMontant() {
        return montant;
    }

    public void setMontant(Double montant) {
        this.montant = montant;
    }

    public Integer getQuantite() {
        return quantite;
    }

    public void setQuantite(Integer quantite) {
        this.quantite = quantite;
    }
}
