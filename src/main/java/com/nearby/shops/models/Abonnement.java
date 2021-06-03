package com.nearby.shops.models;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table
public class Abonnement {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)

        private Long idAbonnement;
        private Date dateAbonnement;
        private String description;
        private double prixAbonnement;
        @OneToMany(targetEntity = ClientAbonne.class,mappedBy = "abonnement")
        private List<ClientAbonne> listClientAbonne=new ArrayList<>();

    public Abonnement() {}
    public Abonnement(Long idAbonnement, Date dateAbonnement,String description, double prixAbonnement) {
        this.idAbonnement = idAbonnement;
        this.description=description;
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


    public void setIdAbonnement(Long idAbonnement) {
        this.idAbonnement = idAbonnement;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setListClientAbonne(List<ClientAbonne> listClientAbonne) {
        this.listClientAbonne = listClientAbonne;
    }

    public Long getIdAbonnement() {
        return idAbonnement;
    }


    public Date getDateAbonnement() {
        return dateAbonnement;
    }

    @Override
    public String toString() {
        return "Abonnement{" +
                "idAbonnement=" + idAbonnement +
                ", dateAbonnement=" + dateAbonnement +
                ", prixAbonnement=" + prixAbonnement +
                '}';
    }

    public double getPrixAbonnement() {
        return prixAbonnement;
    }

}
