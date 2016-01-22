package com;

import com.ClassesService.AddressService;
import com.ClassesService.DistinctService;
import com.ClassesService.OrderService;
import com.ClassesService.StreetService;

import javax.persistence.*;
import javax.ejb.Stateful;
import java.util.HashMap;

@Stateful
public class JPAService {
    @PersistenceContext(name = "JpaPgDb")
    EntityManager em;

    public HashMap getDistinct() {
        return new DistinctService(em).getAllDistinct();
    }

    public HashMap getDistinct(int key) {
        return new DistinctService(em).getDistinct(key);
    }

    public HashMap getStreet(int key) {
        return new StreetService(em).getStreetMap(key);
    }

    public HashMap getStreet() {
        return new StreetService(em).getAllStreets();
    }

    public byte addOrder(int distinctId, int streetId, String houseNumer, String officeNumer, int count, String text) {
        return new OrderService(em).createOrder(distinctId, streetId, houseNumer, officeNumer, count, text);
    }

    public byte addDistinct(String name) {
        return new DistinctService(em).addDistinct(name);
    }

    public byte addStreet(String street, int distinctId) {
        return new StreetService(em).addStreet(street, distinctId);
    }
}
