package dao;

import dao.definitions.AdministratorDAO;
import java.util.List;

import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import model.Administrator;

public class AdministratorDAOImpl extends DaoEM implements AdministratorDAO {

    @Override
    public Administrator find(Integer id) {
        Administrator administrator = em.find(Administrator.class, id);
        return administrator;
    }
    
    @Override
    public Administrator findAdministrator(Integer admin) {
        Administrator administrator = em.find(Administrator.class, admin);
        return administrator;
    } 
    
    
    
     public Administrator findByUserID(Integer id) {
        
        Query query = em.createNamedQuery("Administrator.findByUserId").setParameter("id",id);
        Object o =  query.getSingleResult();
        if (o != null) {
            return (Administrator) query.getSingleResult();
        } else {
            return null;
        }        
        
    }

    @Override
    public List<Administrator> list() {
        Query query = em.createNamedQuery("Administrator.findAll");
        List<Administrator> administrator = query.getResultList();
        return administrator;
    }

    @Override
    public void create(Administrator administrator) {
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();
        em.persist(administrator);
        transaction.commit();
    }

    @Override
    public void update(Integer id, Administrator changes) {
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();
        Administrator managed = em.find(Administrator.class, id);

        transaction.commit();
    }

    @Override
    public boolean remove(Integer id) {
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();
        Administrator managed = em.find(Administrator.class, id);
        if (managed != null) {
            em.remove(managed);
            transaction.commit();
            return true;
        } else {
            transaction.commit();
            return false;
        }
        
    }

}
