package dao;

import dao.definitions.EducationDAO;
import dao.definitions.UserDAO;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import jpautils.EntityManagerHelper;
import model.Education;
import model.User;

public class EducationDAOImpl extends DaoEM implements EducationDAO {

    @Override
    public Education find(Integer id) {
        Education entity = em.find(Education.class, id);
        return entity;
    }

    @Override
    public List<Education> list() {
        Query query = em.createNamedQuery("Education.findAll");
        List<Education> entities = query.getResultList();
        return entities;
    }

    @Override
    public void create(Education entity) {
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();
        em.persist(entity);
        transaction.commit();
    }

    @Override
    public void update(Integer id, Education changes) {
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();
        Education managed = em.find(Education.class, id);

        if (managed != null) {
            if (changes.getEducationId()!= null) {
                managed.setEducationId(changes.getEducationId());
            }
        }

        transaction.commit();
    }

    @Override
    public boolean remove(Integer id) {
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();
        Education managed = em.find(Education.class, id);
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
