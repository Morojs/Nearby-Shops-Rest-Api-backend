package com.nearby.shops.models;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table
public class Boutique {
    @Id
    private String nomBoutique;
    private String description;
    private String adresseBoutique;
    private String siteWeb;
    private Date dateCreation;

    @ManyToOne
    @JoinColumn(name = "idClientAbonne", nullable = false)
    private ClientAbonne clientAbonne;

    @ManyToOne
    @JoinColumn(name="idVille",nullable = false)
    private Ville ville;

    public Boutique() {
    }

    public Boutique(String nomBoutique, String description, String adresseBoutique, String siteWeb, Date dateCreation, ClientAbonne clientAbonne, Ville ville) {
        this.nomBoutique = nomBoutique;
        this.description = description;
        this.adresseBoutique = adresseBoutique;
        this.siteWeb = siteWeb;
        this.dateCreation = dateCreation;
        this.clientAbonne = clientAbonne;
        this.ville = ville;
    }

    public String getNomBoutique() {
        return nomBoutique;
    }

    public String getDescription() {
        return description;
    }

    public String getAdresseBoutique() {
        return adresseBoutique;
    }

    public String getSiteWeb() {
        return siteWeb;
    }

    public void setNomBoutique(String nomBoutique) {
        this.nomBoutique = nomBoutique;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setAdresseBoutique(String adresseBoutique) {
        this.adresseBoutique = adresseBoutique;
    }

    public void setSiteWeb(String siteWeb) {
        this.siteWeb = siteWeb;
    }

    public Date getDateCreation() {
        return dateCreation;
    }

    public ClientAbonne getClientAbonne() {
        return clientAbonne;
    }

    public void setDateCreation(Date dateCreation) {
        this.dateCreation = dateCreation;
    }
    public Ville getVille() {
        return ville;
    }

    public void setClientAbonne(ClientAbonne clientAbonne) {
        this.clientAbonne = clientAbonne;
    }

    public void setVille(Ville ville) {
        this.ville = ville;
    }

}
