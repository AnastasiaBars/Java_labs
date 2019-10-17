package com.vlsu.entity3.service;

import com.vlsu.entity3.entity.Shop;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;
import java.util.ArrayList;

@Service
public class ShopService {
    @PersistenceContext
    EntityManager em;

    public ArrayList<Shop> getAll() {
        ArrayList<Shop> result;
        Query query = em.createQuery("select a from Shop a ");
        result = (ArrayList<Shop>)query.getResultList();
        return result;
    }

    public Shop getById(int id) {
        Query query = em.createQuery("select a from Shop a where a.idShop=:id")
                .setParameter("id", id);
        return (Shop)query.getSingleResult();
    }

    @Transactional(value = Transactional.TxType.REQUIRED)
    public void update(Shop shop) { em.merge(shop);}

    @Transactional
    public void create(Shop shop) {
        em.persist(shop);
    }

    @Transactional
    public void delete(Shop shop) { em.remove(shop); }
}
