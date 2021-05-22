package com.nearby.shops.models;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table
@Inheritance(strategy= InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name="discriminant",discriminatorType = DiscriminatorType.INTEGER)
public class Payment {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer idPayement;
    private Date datePayment;

    public Payment(){}

    public Payment(Integer idPayement, Date datepayment) {
        this.idPayement = idPayement;
        this.datePayment = datepayment;
    }

    public Integer getIdPayement() {
        return idPayement;
    }

    public void setIdPayement(Integer id) {
        this.idPayement = id;
    }

    public Date getDatePayment() {
        return datePayment;
    }

    public void setDatePayment(Date datepayment) {
        this.datePayment = datepayment;
    }

    @Override
    public String toString() {
        return "Payment{" +
                "id=" + idPayement +
                ", datepayment=" + datePayment +
                '}';
    }
}
