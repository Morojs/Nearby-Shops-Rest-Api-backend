package com.nearby.shops.models;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table
public class Produit {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer idProduit;
    private String nom;
    private String reference;
    private String description;
    private Double prix;
    private Integer qteStock;
    @ManyToOne @JoinColumn(name="idBoutique", nullable=false)
    private Boutique boutique;
    @ManyToOne @JoinColumn(name="id", nullable=false)
    private Categorie categorie;
    @ManyToMany
    @JoinTable( name = "T_Commande_Produit_Associations",
            joinColumns = @JoinColumn( name = "idProduit" ),
            inverseJoinColumns = @JoinColumn( name = "idCommande" ) )
    private List<Commande> commande = new ArrayList<>();

    public Produit() {
    }

    public Produit(Integer idProduit, String nom, String reference, String description, Double prix, Integer qteStock, Boutique boutique, Categorie categorie, List<Commande> commande) {
        this.idProduit = idProduit;
        this.nom = nom;
        this.reference = reference;
        this.description = description;
        this.prix = prix;
        this.qteStock = qteStock;
        this.boutique = boutique;
        this.categorie = categorie;
        this.commande = commande;
    }

    public Integer getIdProduit() {
        return idProduit;
    }

    public void setIdProduit(Integer id) {
        this.idProduit = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getReference() {
        return reference;
    }

    public void setReference(String reference) {
        this.reference = reference;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Double getPrix() {
        return prix;
    }

    public void setPrix(Double prix) {
        this.prix = prix;
    }

    public Integer getQteStock() {
        return qteStock;
    }

    public void setQteStock(Integer qteStock) {
        this.qteStock = qteStock;
    }

    public Boutique getBoutique() {
        return boutique;
    }

    public void setBoutique(Boutique boutique) {
        this.boutique = boutique;
    }

    public Categorie getCategorie() {
        return categorie;
    }

    public void setCategorie(Categorie categorie) {
        this.categorie = categorie;
    }

    public List<Commande> getCommande() {
        return commande;
    }

    public void setCommande(List<Commande> commande) {
        this.commande = commande;
    }

    @Override
    public String toString() {
        return "Produit{" +
                "id=" + idProduit +
                ", nom='" + nom + '\'' +
                ", reference='" + reference + '\'' +
                ", description='" + description + '\'' +
                ", prix=" + prix +
                ", qteStock=" + qteStock +
                '}';
    }
}
