package com.nearby.shops.models;

import javax.persistence.*;

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

    public Produit() {
    }
    public Produit(Integer idProduit, String nom, String reference, String description, Double prix, Integer qteStock) {
        this.idProduit = idProduit;
        this.nom = nom;
        this.reference = reference;
        this.description = description;
        this.prix = prix;
        this.qteStock = qteStock;
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
