package com.vlsu.entity3.service;

import com.vlsu.entity3.entity.Supply;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;
import java.util.ArrayList;

@Service
public class SupplyService {
    @PersistenceContext
    EntityManager em;

    public ArrayList<Supply> getAll() {
        ArrayList<Supply> result;
        Query query = em.createQuery("select a from Supply a");
        result = (ArrayList<Supply>)query.getResultList();
        return result;
    }

    public Supply getById(int id) {
        Query query = em.createQuery("select a from Supply a where a.idSupply=:id")
                .setParameter("id", id);
        return (Supply) query.getSingleResult();
    }

    @Transactional
    public void update(Supply supply) {
        em.merge(supply);
    }

    @Transactional
    public void create(Supply supply) {
        em.persist(supply);
    }

    @Transactional
    public void delete(Supply supply) {
        em.remove(supply);
    }
}