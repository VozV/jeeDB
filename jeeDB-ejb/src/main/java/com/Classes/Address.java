package com.Classes;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity
public class Address {

    @Id
    @GeneratedValue
    private int id;


    @Column(length = 10)
    private String houseNumer;

    @Column(length = 10)
    private String office;

    @JoinColumn(nullable = false)
    @OneToOne(fetch = FetchType.EAGER, orphanRemoval = true)
    private Street street;

    public Address(){}
    public Address(String houseNumer, String office, Street street) {
        this.houseNumer = houseNumer;
        this.office = office;
        this.street = street;
    }

    public int getId() {
        return id;
    }

    public String getHouseNumer() {
        return houseNumer;
    }

    public void setHouseNumer(String houseNumer) {
        this.houseNumer = houseNumer.substring(0, 10);
    }

    public String getOffice() {
        return office;
    }

    public void setOfficeExt(String office) {
        this.office = office;
    }

    public Street getStreet() {
        return street;
    }

    public void setStreet(Street street) {
        this.street = street;
    }

}
