package com.Classes;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name="orders")
public class Order {

    public Order(int count, String text, Address adr){
        this.status = 1;
        this.dateOrder = new Date();
        this.count = count;
        this.textAbout = text;
        this.arddress = adr;
    }

    public Order() {}

    public int getId() {
        return id;
    }

    @Id
    @GeneratedValue
    private int id;

    public byte getStatus() {
        return status;
    }

    public void setStatus(byte status) {
        this.status = status;
    }

    private byte status;

    public Address getArddress() {
        return arddress;
    }

    public void setArddress(Address arddress) {
        this.arddress = arddress;
    }

    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(nullable = false)
    private Address arddress;



    //@Column(length = 45)
    private Date dateOrder;

    public Date getDateOrder() {
        return dateOrder;
    }

    public void setDateOrder(Date dateOrder) {
        this.dateOrder = dateOrder;
    }

    public String getTextAbout() {
        return textAbout;
    }

    public void setTextAbout(String textAbout) {
        this.textAbout = textAbout;
    }

    public int getMaster() {

        return master;
    }

    public void setMaster(int master) {
        this.master = master;
    }

    public int getCount() {

        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    private int count;

    private int master;
    
    private String textAbout;
}
