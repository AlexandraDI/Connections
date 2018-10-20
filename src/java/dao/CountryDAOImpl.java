package dao;

import dao.definitions.CountryDAO;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import jpautils.EntityManagerHelper;
import model.Country;

public class CountryDAOImpl extends DaoEM implements CountryDAO {

    @Override
    public Country find(String email) {
        Query query = em.createNamedQuery("Country.findByEmail").setParameter("email", email);
        Object o =  query.getSingleResult();
        if (o != null) {
            return (Country) query.getSingleResult();
        } else {
            return null;
        }
    }

    @Override
    public Country find(Integer id) {
        Country user = em.find(Country.class, id);
        return user;
    }

    @Override
    public List<Country> list() {
        Query query = em.createNamedQuery("Country.findAll");
        List<Country> countries = query.getResultList();
        return countries;
    }

    @Override
    public void create(Country country) {
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();
        em.persist(country);
        transaction.commit();
    }

    @Override
    public void update(Integer id, Country changes) {
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();
        Country managed = em.find(Country.class, id);

        if (managed != null) {
    
            if (changes.getCountryId() != null) {
                managed.setCountryId(changes.getCountryId());
            }            
        }

        transaction.commit();
    }

    @Override
    public boolean remove(Integer id) {
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();
        Country managed = em.find(Country.class, id);
        if (managed != null) {
            em.remove(managed);
            transaction.commit();
            return true;
        } else {
            transaction.commit();
            return false;
        }

    }

    public List<Country> search(String what) {
         Query query = em.createNamedQuery("Country.findByQuery").setParameter("what", "%" +  what + "%");
        List<Country> countries = query.getResultList();
        return countries;
    }

}
