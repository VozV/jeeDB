package com.ClassesService;

import com.Classes.District;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;

/**
 * Created by Admin on 17.12.2015.
 */
public class DistinctService {

    private EntityManager em;

    public DistinctService(EntityManager em) {
        this.em = em;
    }

    public HashMap getDistinct(int key){
        District ds = em.find(District.class, key);
        if (ds != null) {
            HashMap s = new HashMap();
            s.put(ds.getId(),ds.getName());
            return s;
        } else return null;
    }

    public byte addDistinct(String name){
        try {
            em.persist(new District(name));
        } catch (Exception e){
            return 0;
        }
        return 1;
    }

    public HashMap getAllDistinct (){
        HashMap d = new HashMap();
        for (Object obj : em.createQuery("SELECT e FROM District e").getResultList())
            d.put(((District) obj).getId(),((District) obj).getName());
        return d;
    }

}
