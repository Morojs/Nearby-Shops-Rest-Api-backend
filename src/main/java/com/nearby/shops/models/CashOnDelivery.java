package com.nearby.shops.models;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table
@DiscriminatorValue("0")
public class CashOnDelivery extends Payment{

    private int numCash;
    private String nomLivreur;
    private String cinClient;
    private Date dateLivraison;
    private Double montant;

    public CashOnDelivery(){}

    public CashOnDelivery(int numCash, String nomLivreur, String cinClient, Date dateLivraison, Double montant) {
        this.numCash = numCash;
        this.nomLivreur = nomLivreur;
        this.cinClient = cinClient;
        this.dateLivraison = dateLivraison;
        this.montant = montant;
    }

    public CashOnDelivery(Integer id, Date datepayment, int numCash, String nomLivreur, String cinClient, Date dateLivraison, Double montant) {
        super(id, datepayment);
        this.numCash = numCash;
        this.nomLivreur = nomLivreur;
        this.cinClient = cinClient;
        this.dateLivraison = dateLivraison;
        this.montant = montant;
    }

    public int getNumCash() {
        return numCash;
    }

    public void setNumCash(int numCash) {
        this.numCash = numCash;
    }

    public String getNomLivreur() {
        return nomLivreur;
    }

    public void setNomLivreur(String nomLivreur) {
        this.nomLivreur = nomLivreur;
    }

    public String getCinClient() {
        return cinClient;
    }

    public void setCinClient(String cinClient) {
        this.cinClient = cinClient;
    }

    public Date getDateLivraison() {
        return dateLivraison;
    }

    public void setDateLivraison(Date dateLivraison) {
        this.dateLivraison = dateLivraison;
    }

    public Double getMontant() {
        return montant;
    }

    public void setMontant(Double montant) {
        this.montant = montant;
    }

    @Override
    public String toString() {
        return "CashOnDelivery{" +
                "numCash=" + numCash +
                ", nomLivreur='" + nomLivreur + '\'' +
                ", cinClient='" + cinClient + '\'' +
                ", dateLivraison=" + dateLivraison +
                ", montant=" + montant +
                '}';
    }
}
