package dao;

import dao.definitions.LocationDAO;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import jpautils.EntityManagerHelper;
import model.Location;

public class LocationDAOImpl extends DaoEM implements LocationDAO {

    @Override
    public Location find(String email) {
        Query query = em.createNamedQuery("Location.findByEmail").setParameter("email", email);
        Object o =  query.getSingleResult();
        if (o != null) {
            return (Location) query.getSingleResult();
        } else {
            return null;
        }
    }

    @Override
    public Location find(Integer id) {
        Location location = em.find(Location.class, id);
        return location;
    }

    @Override
    public List<Location> list() {
        Query query = em.createNamedQuery("Location.findAll");
        List<Location> locations = query.getResultList();
        return locations;
    }

    @Override
    public void create(Location location) {
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();
        em.persist(location);
        transaction.commit();
    }

    @Override
    public void update(Integer id, Location changes) {
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();
        Location managed = em.find(Location.class, id);

        if (managed != null) {
            if (changes.getLocationId() != null) {
                managed.setLocationId(changes.getLocationId());
            }          
        }

        transaction.commit();
    }

    @Override
    public boolean remove(Integer id) {
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();
        Location managed = em.find(Location.class, id);
        if (managed != null) {
            em.remove(managed);
            transaction.commit();
            return true;
        } else {
            transaction.commit();
            return false;
        }

    }

    public List<Location> search(String what) {
         Query query = em.createNamedQuery("Location.findByQuery").setParameter("what", "%" +  what + "%");
        List<Location> locations = query.getResultList();
        return locations;
    }

}
