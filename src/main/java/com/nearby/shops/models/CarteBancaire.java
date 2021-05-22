package com.nearby.shops.models;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.Date;
@Entity
@Table
@DiscriminatorValue("1")
public class CarteBancaire extends Payment {

    private String nomSurCarte;
    private int numCarte;
    private Date dateExperation;
    private int cvv;
    private String type;
    public CarteBancaire(){}

    public CarteBancaire(String nomSurCarte, int numCarte, Date dateExperation, int cvv, String type) {
        this.nomSurCarte = nomSurCarte;
        this.numCarte = numCarte;
        this.dateExperation = dateExperation;
        this.cvv = cvv;
        this.type = type;
    }

    public CarteBancaire(Integer id, Date datepayment, String nomSurCarte, int numCarte, Date dateExperation, int cvv, String type) {
        super(id, datepayment);
        this.nomSurCarte = nomSurCarte;
        this.numCarte = numCarte;
        this.dateExperation = dateExperation;
        this.cvv = cvv;
        this.type = type;
    }

    public String getNomSurCarte() {
        return nomSurCarte;
    }

    public void setNomSurCarte(String nomSurCarte) {
        this.nomSurCarte = nomSurCarte;
    }

    public int getNumCarte() {
        return numCarte;
    }

    public void setNumCarte(int numCarte) {
        this.numCarte = numCarte;
    }

    public Date getDateExperation() {
        return dateExperation;
    }

    public void setDateExperation(Date dateExperation) {
        this.dateExperation = dateExperation;
    }

    public int getCvv() {
        return cvv;
    }

    public void setCvv(int cvv) {
        this.cvv = cvv;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "CarteBancaire{" +
                "nomSurCarte='" + nomSurCarte + '\'' +
                ", numCarte=" + numCarte +
                ", dateExperation=" + dateExperation +
                ", cvv=" + cvv +
                ", type='" + type + '\'' +
                '}';
    }
}
