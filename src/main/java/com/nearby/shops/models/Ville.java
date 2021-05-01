package com.nearby.shops.models;


import javax.persistence.*;
@Entity
@Table
public class Ville {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String nomVille;
    public Ville(){}

    public Ville(Integer idVille, String nomVille) {
        this.id = idVille;
        this.nomVille = nomVille;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNomVille() {
        return nomVille;
    }

    public void setNomVille(String nomVille) {
        this.nomVille = nomVille;
    }

    @Override
    public String toString() {
        return "Ville{" +
                "id=" + id +
                ", nomVille='" + nomVille + '\'' +
                '}';
    }
}
