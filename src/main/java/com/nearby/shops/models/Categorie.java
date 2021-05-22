package com.nearby.shops.models;
import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table
public class Categorie {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String nomCategorie;
    private String designation;
    @OneToMany(targetEntity = Produit.class,mappedBy = "categorie")
    private List<Produit> listProduit=new ArrayList<>();
    public Categorie(){}

    public Categorie(Integer id, String nomCategorie, String designation, List<Produit> listProduit) {
        this.id = id;
        this.nomCategorie = nomCategorie;
        this.designation = designation;
        this.listProduit = listProduit;
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

    public List<Produit> getListProduit() {
        return listProduit;
    }

    public void setListProduit(List<Produit> listProduit) {
        this.listProduit = listProduit;
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
