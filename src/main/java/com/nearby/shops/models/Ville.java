package com.nearby.shops.models;


import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table
public class Ville {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String nomVille;


    @OneToMany(targetEntity = Boutique.class, mappedBy = "ville")
    private List<Boutique> listBoutique = new ArrayList<>();

    public Ville() {
    }

    public List<Boutique> getListBoutique() {
        return listBoutique;
    }

    public void setListBoutique(List<Boutique> listBoutique) {
        this.listBoutique = listBoutique;
    }

    public Ville(String nomVille) {
        this.nomVille = nomVille;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public String getNomVille() {
        return nomVille;
    }

    public void setNomVille(String nomVille) {
        this.nomVille = nomVille;
    }


}
