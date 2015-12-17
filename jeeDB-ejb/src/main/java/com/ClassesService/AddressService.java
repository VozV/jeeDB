package com.ClassesService;

import com.Classes.Address;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import java.util.List;

public class AddressService {

    private EntityManager em;

    public AddressService(EntityManager em) {
        this.em = em;
    }

    public void createAddress(int houseNumer, String houseNumerExt, int office, String officeExt) {
        //Address addr =
        em.persist(new Address(houseNumer, houseNumerExt, office, officeExt));
        //return addr;
    }

    public void removeAddress(int id) {
        Address addr = em.find(Address.class, id);
        if (addr != null) {
            em.remove(addr);
        }
    }

    public Address changeAddressHouseNumer(int id, int value) {
        Address addr = em.find(Address.class, id);
        if (addr != null) {
            addr.setHouseNumer(value);
        }
        return addr;
    }

    public Address findAddress(int id) {
        return em.find(Address.class, id);
    }

/*    public List<Address> findAllAddresss() {
        TypedQuery<Address> query = em.createQuery("SELECT a FROM Address a", Address.class);
        return query.getResultList();
    }*/
}
