package com.nearby.shops.models;

import javax.persistence.*;

@Entity
@Table
public class Localisation {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private Double altitude;
    private Double langitude;
    public Localisation(){}

    public Localisation(Long idLocalisation, Double altitude, Double langitude) {
        this.id = idLocalisation;
        this.altitude = altitude;
        this.langitude = langitude;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Double getAltitude() {
        return altitude;
    }

    public void setAltitude(Double altitude) {
        this.altitude = altitude;
    }

    public Double getLangitude() {
        return langitude;
    }

    public void setLangitude(Double langitude) {
        this.langitude = langitude;
    }

    @Override
    public String toString() {
        return "Localisation{" +
                "id=" + id +
                ", altitude=" + altitude +
                ", langitude=" + langitude +
                '}';
    }
}
