package com.ClassesService;

import com.Classes.Address;
import com.Classes.Street;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import java.util.List;
import java.util.Queue;

public class AddressService {

    private EntityManager em;

    public AddressService(EntityManager em) {
        this.em = em;
    }

    public void createAddress(String houseNumer, String office, int streetId) {
        em.persist(new Address(houseNumer,  office, new StreetService(em).getStreet(streetId)));
    }

    public void removeAddress(int id) {
        Address addr = em.find(Address.class, id);
        if (addr != null) {
            em.remove(addr);
        }
    }

    public Address changeAddressHouseNumer(int id, String value) {
        Address addr = em.find(Address.class, id);
        if (addr != null) {
            addr.setHouseNumer(value);
        }
        return addr;
    }

    public Address getAddress (String houseNumer, String office, int StreetId){
        TypedQuery<Address> query = em.createQuery("SELECT e from Address e where e.houseNumer = " +
                ":houseNumer  AND e.office = :office AND e.street.id = :streetid", Address.class);
        query.setParameter("houseNumer",houseNumer);
        query.setParameter("office",office);
        query.setParameter("streetid", StreetId);
        if (query.getResultList().size() > 0){
            return query.getResultList().get(0);
        } else {
            this.createAddress(houseNumer,office,StreetId);
            return this.getAddress(houseNumer,office,StreetId);
        }
    }

    public Address findAddress(int id) {
        return em.find(Address.class, id);
    }

/*    public List<Address> findAllAddresss() {
        TypedQuery<Address> query = em.createQuery("SELECT a FROM Address a", Address.class);
        return query.getResultList();
    }*/
}
