package com.ClassesService;

import com.Classes.District;
import javax.persistence.EntityManager;
import java.util.Date;

/**
 * Created by Admin on 17.12.2015.
 */
public class DistinctService {

    private EntityManager em;

    public DistinctService(EntityManager em) {
        this.em = em;
    }

    public void createDistinct(String name) {
        em.persist(new District(name));
    }
}
