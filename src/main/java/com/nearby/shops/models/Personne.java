package com.nearby.shops.models;

import javax.persistence.*;
import java.util.Date;
@Entity
@Table
@Inheritance(strategy=InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name="discriminant",discriminatorType = DiscriminatorType.INTEGER)
public class Personne {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String nom;
    private String prenom;
    private Date dateNaissance;
    private String motDePasse;
    private String email;
    private String pays;
    private String adresse_1;
    private String adresse_2;
    private String codePostal;
    private String telephone;
    private String fix;

    public Personne() {}

    public Personne(Integer id, String nom, String prenom, Date dateNaissance, String motDePasse, String email, String pays, String adresse_1, String adresse_2, String codePostal, String telephone, String fix) {
        this.id = id;
        this.nom = nom;
        this.prenom = prenom;
        this.dateNaissance = dateNaissance;
        this.motDePasse = motDePasse;
        this.email = email;
        this.pays = pays;
        this.adresse_1 = adresse_1;
        this.adresse_2 = adresse_2;
        this.codePostal = codePostal;
        this.telephone = telephone;
        this.fix = fix;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public Date getDateNaissance() {
        return dateNaissance;
    }

    public void setDateNaissance(Date dateNaissance) {
        this.dateNaissance = dateNaissance;
    }

    public String getMotDePasse() {
        return motDePasse;
    }

    public void setMotDePasse(String motDePasse) {
        this.motDePasse = motDePasse;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPays() {
        return pays;
    }

    public void setPays(String pays) {
        this.pays = pays;
    }

    public String getAdresse_1() {
        return adresse_1;
    }

    public void setAdresse_1(String adresse_1) {
        this.adresse_1 = adresse_1;
    }

    public String getAdresse_2() {
        return adresse_2;
    }

    public void setAdresse_2(String adresse_2) {
        this.adresse_2 = adresse_2;
    }

    public String getCodePostal() {
        return codePostal;
    }

    public void setCodePostal(String codePostal) {
        this.codePostal = codePostal;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getFix() {
        return fix;
    }

    public void setFix(String fix) {
        this.fix = fix;
    }
}
