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

    private int houseNumer;

    @Column(length = 2)
    private String houseNumerExt;

    private int office;

    @Column(length = 2)
    private String officeExt;

    @JoinColumn(nullable = false)
    @OneToOne(fetch = FetchType.EAGER, orphanRemoval = true)
    private Street sName;

    public Address(int houseNumer, String houseNumerExt, int office, String officeExt) {
        this.houseNumer = houseNumer;
        this.houseNumerExt = houseNumerExt;
        this.office = office;
        this.officeExt = officeExt;
    }


    public void setHouseNumer(int value) {
        this.houseNumer = value;
    }

    public int getHouseNumer(String value) {
        return  this.houseNumer;
    }

    public int getId() {
        return id;
    }

    public String getHouseNumerExt() {
        return houseNumerExt;
    }

    public void setHouseNumerExt(String houseNumerExt) {
        this.houseNumerExt = houseNumerExt.substring(0, 2);
    }

    public int getOffice() {
        return office;
    }

    public void setOffice(int office) {
        this.office = office;
    }

    public String getOfficeExt() {
        return officeExt;
    }

    public void setOfficeExt(String officeExt) {
        this.officeExt = officeExt;
    }

    public Street getsName() {
        return sName;
    }

    public void setsName(Street sName) {
        this.sName = sName;
    }

}
