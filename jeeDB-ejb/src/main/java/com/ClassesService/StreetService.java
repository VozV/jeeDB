package com.ClassesService;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import com.Classes.Address;
import com.Classes.Street;
import com.Classes.District;

import java.util.HashMap;

/**
 * Created by Admin on 17.12.2015.
 */
public class StreetService {
    private EntityManager em;

    public StreetService(EntityManager em) {
        this.em = em;
    }

    public byte addStreet(String name, int distinctId) {
        District ds = em.find(District.class, distinctId);
        try {
            if (ds != null) {
                em.persist(new Street(name, ds));
            } else return 0;
        }catch (Exception e){
            return 0;
        }
        return 1;
    }

    public HashMap getAllStreets (){
        Query query = em.createQuery("SELECT e FROM Street e");
        HashMap s = new HashMap();
        for (Object obj : query.getResultList())
            s.put(((Street) obj).getId(),((Street) obj).getName());
        return s;
    }

    public Street getStreet(int key) {
        return em.find(Street.class, key);
    }

    public HashMap getStreetMap(int key) {
        Street ss = em.find(Street.class, key);
        if (ss != null) {
            HashMap s = new HashMap();
            s.put(ss.getId(), ss.getName());
            return s;
        } else return null;
    }
}
