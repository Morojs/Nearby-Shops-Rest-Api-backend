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
    private Integer id;
    private Date datepayment;

    public Payment(){}

    public Payment(Integer id, Date datepayment) {
        this.id = id;
        this.datepayment = datepayment;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getDatepayment() {
        return datepayment;
    }

    public void setDatepayment(Date datepayment) {
        this.datepayment = datepayment;
    }

    @Override
    public String toString() {
        return "Payment{" +
                "id=" + id +
                ", datepayment=" + datepayment +
                '}';
    }
}
