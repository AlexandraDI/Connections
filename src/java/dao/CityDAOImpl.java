package dao;

import dao.definitions.CityDAO;
import java.util.List;

import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import model.City;

public class CityDAOImpl extends DaoEM implements CityDAO {

    @Override
    public City find(String email) {
        Query query = em.createNamedQuery("City.findByEmail").setParameter("email", email);
        Object o =  query.getSingleResult();
        if (o != null) {
            return (City) query.getSingleResult();
        } else {
            return null;
        }
    }

    @Override
    public City find(Integer id) {
        City city = em.find(City.class, id);
        return city;
    }

    @Override
    public List<City> list() {
        Query query = em.createNamedQuery("City.findAll");
        List<City> cities = query.getResultList();
        return cities;
    }

    @Override
    public void create(City city) {
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();
        em.persist(city);
        transaction.commit();
    }

    @Override
    public void update(Integer id, City changes) {
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();
        City managed = em.find(City.class, id);

        if (managed != null) {
            if (changes.getCityId() != null) {
                managed.setCityId(changes.getCityId());
            }            
        }

        transaction.commit();
    }

    @Override
    public boolean remove(Integer id) {
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();
        City managed = em.find(City.class, id);
        if (managed != null) {
            em.remove(managed);
            transaction.commit();
            return true;
        } else {
            transaction.commit();
            return false;
        }

    }

    public List<City> search(String what) {
         Query query = em.createNamedQuery("City.findByQuery").setParameter("what", "%" +  what + "%");
        List<City> cities = query.getResultList();
        return cities;
    }

}
