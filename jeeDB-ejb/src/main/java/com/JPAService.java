/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com;

import com.ClassesService.AddressService;
import com.ClassesService.DistinctService;

import javax.persistence.*;
import javax.ejb.Stateful;

@Stateful
public class JPAService {
    //@PersistenceContext(name = "JpaPgDb")
    //private EntityManagerFactory emf;
/*    public JPAService() {
        emf = Persistence.createEntityManagerFactory("JpaPgDb");
    }*/
    @PersistenceContext(name = "JpaPgDb")
    EntityManager em;

    public String getSome() {
        //em = Persistence.createEntityManagerFactory("JpaPgDb").createEntityManager();
        //emf = Persistence.createEntityManagerFactory("JpaPgDb");
        //EntityManager em = emf.createEntityManager();
        /*AddressService service = new AddressService(em);
        service.createAddress(1, "а", 10, "б");*/
        DistinctService ds = new DistinctService(em);
        ds.createDistinct("123");
        //EntityTransaction transaction = em.getTransaction();
        /*try {
            transaction.begin();
            //service.createAddress(1, "а", 10, "б");
            transaction.commit();
        } catch (Exception e) {
            transaction.rollback();
        } finally {
            em.close();
        }*/
        return "some";
    }
}
