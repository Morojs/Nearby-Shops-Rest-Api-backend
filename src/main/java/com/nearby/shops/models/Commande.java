package com.nearby.shops.models;

import javax.persistence.*;
import java.util.ArrayList;
import java.sql.Date;
import java.util.List;

@Entity
@Table
public class Commande {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer idCommande;
    private Date dateCommande;
    private boolean etatCommande;
    @ManyToOne
    @JoinColumn(name = "idPersonne", nullable = false)
    private Personne personne;
    @ManyToMany
    @JoinTable( name = "T_Commande_Produit_Associations",
            joinColumns = @JoinColumn( name = "idCommande" ),
            inverseJoinColumns = @JoinColumn( name = "idProduit" ) )
    private List<Produit> produit = new ArrayList<>();

    @OneToMany(targetEntity = Livraison.class, mappedBy = "idCommande")
    private List<Livraison> listLivraison = new ArrayList<>();

    public Commande(Integer idCommande, Date dateCommande, boolean etatCommande, Personne personne, List<Produit> produit) {
        this.idCommande = idCommande;
        this.dateCommande = dateCommande;
        this.etatCommande = etatCommande;
        this.personne = personne;
        this.produit = produit;
    }

    public Commande() {
    }

    public Integer getIdCommande() {
        return idCommande;
    }
    public void setIdCommande(Integer idCommande) {
        this.idCommande = idCommande;
    }

    public Date getDateCommande() {
        return dateCommande;
    }

    public void setDateCommande(Date dateCommande) {
        this.dateCommande = dateCommande;
    }

    public boolean isEtatCommande() {
        return etatCommande;
    }

    public void setEtatCommande(boolean etatCommande) {
        this.etatCommande = etatCommande;
    }

    public Personne getPersonne() {
        return personne;
    }

    public void setPersonne(Personne personne) {
        this.personne = personne;
    }

    public List<Produit> getProduit() {
        return produit;
    }

    public void setProduit(List<Produit> produit) {
        this.produit = produit;
    }
    @Override
    public String toString() {
        return "Commande{" +
                "idCommande=" + idCommande +
                ", dateCommande=" + dateCommande +
                ", etatCommande=" + etatCommande +
                ", personne=" + personne +
                ", produit=" + produit +
                '}';
    }
}
