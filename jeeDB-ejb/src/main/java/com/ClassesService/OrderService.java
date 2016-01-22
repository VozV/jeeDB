package com.ClassesService;

import com.Classes.Address;
import com.Classes.Order;

import javax.persistence.EntityManager;

/**
 * Created by Admin on 23.12.2015.
 */
public class OrderService {
    private EntityManager em;

    public OrderService (EntityManager em) {
        this.em = em;
    }

    public Order findOrder(int id) {
        return em.find(Order.class, id);
    }

    public byte createOrder (int distinctId, int streetId, String houseNumer, String office, int count, String text) {
        try {
            em.persist(new Order(count, text, new AddressService(em).getAddress(houseNumer, office, streetId)));
            return 1;
        }catch (Exception ex){
            return 0;
        }
    }
}
