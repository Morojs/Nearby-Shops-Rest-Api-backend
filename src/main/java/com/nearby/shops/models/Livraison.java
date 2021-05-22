package com.nearby.shops.models;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table
public class Livraison {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private Date dateLivraison;
    @ManyToOne
    @JoinColumn(name = "idCommande", nullable = false)
    private Commande idCommande;

    public Livraison() {
    }

    public Livraison(Integer id, Date dateLivraison, Commande idCommande) {
        this.id = id;
        this.dateLivraison = dateLivraison;
        this.idCommande = idCommande;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getDateLivraison() {
        return dateLivraison;
    }

    public void setDateLivraison(Date dateLivraison) {
        this.dateLivraison = dateLivraison;
    }

    public Commande getIdCommande() {
        return idCommande;
    }

    public void setIdCommande(Commande idCommande) {
        this.idCommande = idCommande;
    }

    @Override
    public String toString() {
        return "Livraison{" +
                "id=" + id +
                ", dateLivraison=" + dateLivraison +
                ", idCommande=" + idCommande +
                '}';
    }
}
