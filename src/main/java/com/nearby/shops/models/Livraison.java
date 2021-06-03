package com.nearby.shops.models;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table
public class Livraison {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long idLivraison;
    private Date dateLivraison;
    @ManyToOne
    @JoinColumn(name = "idCommande", nullable = false)
    private Commande idCommande;

    public Livraison() {
    }

    public Livraison(Long idLivraison, Date dateLivraison, Commande idCommande) {
        this.idLivraison = idLivraison;
        this.dateLivraison = dateLivraison;
        this.idCommande = idCommande;
    }

    public Long getIdLivraison() {
        return idLivraison;
    }

    public void setIdLivraison(Long id) {
        this.idLivraison = id;
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
                "id=" + idLivraison +
                ", dateLivraison=" + dateLivraison +
                ", idCommande=" + idCommande +
                '}';
    }
}
