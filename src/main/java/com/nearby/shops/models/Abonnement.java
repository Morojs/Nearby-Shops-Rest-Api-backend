package com.nearby.shops.models;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.persistence.*;
import java.util.Date;
@Entity
@Table
public class Abonnement {
        @Id
        @GeneratedValue(strategy = GenerationType.AUTO)
        private Integer id;
        private Date dateAbonnement;
        private double prixAbonnement;

    public Abonnement() {}

    public void setDateAbonnement(Date dateAbonnement) {
        this.dateAbonnement = dateAbonnement;
    }

    public void setPrixAbonnement(double prixAbonnement) {
        this.prixAbonnement = prixAbonnement;
    }

    public Abonnement(int idAbonnement, Date dateAbonnement, double prixAbonnement) {
        this.id = idAbonnement;
        this.dateAbonnement = dateAbonnement;
        this.prixAbonnement = prixAbonnement;
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
