package dao;

import dao.definitions.CompanyDAO;
import dao.definitions.UserDAO;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import jpautils.EntityManagerHelper;
import model.Company;
import model.User;

public class CompanyDAOImpl extends DaoEM implements CompanyDAO {

    @Override
    public Company find(Integer id) {
        Company entity = em.find(Company.class, id);
        return entity;
    }

    @Override
    public List<Company> list() {
        Query query = em.createNamedQuery("Company.findAll");
        List<Company> entities = query.getResultList();
        return entities;
    }

    @Override
    public void create(Company entity) {
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();
        em.persist(entity);
        transaction.commit();
    }

    @Override
    public void update(Integer id, Company changes) {
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();
        Company managed = em.find(Company.class, id);

        if (managed != null) {
            if (changes.getCompanyId()!= null) {
                managed.setCompanyId(changes.getCompanyId());
            }
        }

        transaction.commit();
    }

    @Override
    public boolean remove(Integer id) {
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();
        Company managed = em.find(Company.class, id);
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
