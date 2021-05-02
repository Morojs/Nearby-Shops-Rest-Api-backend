package com.nearby.shops.models;
import javax.persistence.*;

@Entity
@Table
public class Categorie {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String nomCategorie;
    private String designation;
    public Categorie(){}

    public Categorie(Integer id, String nomCategorie, String designation) {
        this.id = id;
        this.nomCategorie = nomCategorie;
        designation = designation;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNomCategorie() {
        return nomCategorie;
    }

    public void setNomCategorie(String nomCategorie) {
        this.nomCategorie = nomCategorie;
    }

    public String getDesignation() {
        return designation;
    }

    public void setDesignation(String designation) {
        this.designation = designation;
    }

    @Override
    public String toString() {
        return "Categorie{" +
                "id=" + id +
                ", nomCategorie='" + nomCategorie + '\'' +
                ", Designation='" + designation + '\'' +
                '}';
    }
}
