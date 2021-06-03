package com.nearby.shops.models;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table
public class Facture {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long idFacture;
    private Date dateFcture;
    private double montantFacture;
    @OneToOne @JoinColumn(name = "idCommande",nullable = false)
    private Commande commande;
    @OneToOne @JoinColumn(name = "idPayement",nullable = false)
    private Payment payment;
    public Facture() {

    }
    public Facture(Long idFacture, Date dateFcture, double montantFacture, Commande commande, Payment payment) {
        this.idFacture = idFacture;
        this.dateFcture = dateFcture;
        this.montantFacture = montantFacture;
        this.commande = commande;
        this.payment = payment;
    }
    public Long getIdFacture() {
        return idFacture;
    }

    public void setIdFacture(Long idFacture) {
        this.idFacture = idFacture;
    }

    public Date getDateFcture() {
        return dateFcture;
    }

    public void setDateFcture(Date dateFcture) {
        this.dateFcture = dateFcture;
    }

    public double getMontantFacture() {
        return montantFacture;
    }

    public void setMontantFacture(double montantFacture) {
        this.montantFacture = montantFacture;
    }

    public Commande getCommande() {
        return commande;
    }

    public void setCommande(Commande commande) {
        this.commande = commande;
    }

    public Payment getPayment() {
        return payment;
    }

    public void setPayment(Payment payment) {
        this.payment = payment;
    }
}
