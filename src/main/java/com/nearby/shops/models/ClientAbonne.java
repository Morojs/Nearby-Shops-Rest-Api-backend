package com.nearby.shops.models;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table
@DiscriminatorValue("1")
public class ClientAbonne extends Personne {

    private String cin;

    @ManyToOne
    @JoinColumn(name = "idAbonnement", nullable = false, updatable = false, insertable = false)
    private Abonnement abonnement;

    @OneToMany(targetEntity = Boutique.class, mappedBy = "clientAbonne")
    private List<Boutique> listBoutique = new ArrayList<>();

    public ClientAbonne() {

    }

    public ClientAbonne(Integer id, String nom, String prenom, Date dateNaissance, String motDePasse, String pays, String adresse_1, String adresse_2, String codePostal, String telephone, String fix, String cin, Abonnement abonnement) {
        super(id, nom, prenom, dateNaissance, motDePasse, pays, adresse_1, adresse_2, codePostal, telephone, fix);
        this.cin = cin;
        this.abonnement = abonnement;
    }

    public String getCin() {
        return cin;
    }

    public void setCin(String cin) {
        this.cin = cin;
    }

    public Abonnement getAbonnement() {
        return abonnement;
    }

    public List<Boutique> getListBoutique() {
        return listBoutique;
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
