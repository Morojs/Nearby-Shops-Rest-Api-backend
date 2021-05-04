package com.nearby.shops.models;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table
public class Abonnement {
        @Id
        @GeneratedValue(strategy = GenerationType.AUTO)
        private Integer id;
        private Date dateAbonnement;
        private double prixAbonnement;
        @OneToMany(targetEntity = ClientAbonne.class,mappedBy = "abonnement")
        private List<ClientAbonne> listClientAbonne=new ArrayList<>();

    public Abonnement() {}
    public Abonnement(int idAbonnement, Date dateAbonnement, double prixAbonnement) {
        this.id = idAbonnement;
        this.dateAbonnement = dateAbonnement;
        this.prixAbonnement = prixAbonnement;
    }
    public void setDateAbonnement(Date dateAbonnement) {
        this.dateAbonnement = dateAbonnement;
    }

    public void setPrixAbonnement(double prixAbonnement) {
        this.prixAbonnement = prixAbonnement;
    }

    public List<ClientAbonne> getListClientAbonne() {
        return listClientAbonne;
    }



    public int getId() {
        return id;
    }

    public void setId(int idAbonnement) {
        this.id = idAbonnement;
    }

    public Date getDateAbonnement() {
        return dateAbonnement;
    }

    @Override
    public String toString() {
        return "Abonnement{" +
                "idAbonnement=" + id +
                ", dateAbonnement=" + dateAbonnement +
                ", prixAbonnement=" + prixAbonnement +
                '}';
    }

    public double getPrixAbonnement() {
        return prixAbonnement;
    }

}
