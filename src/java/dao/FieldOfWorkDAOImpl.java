package dao;

import dao.definitions.FieldOfWorkDAO;
import dao.definitions.UserDAO;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import jpautils.EntityManagerHelper;
import model.FieldOfWork;
import model.User;

public class FieldOfWorkDAOImpl extends DaoEM implements FieldOfWorkDAO {

    @Override
    public FieldOfWork find(Integer id) {
        FieldOfWork entity = em.find(FieldOfWork.class, id);
        return entity;
    }

    @Override
    public List<FieldOfWork> list() {
        Query query = em.createNamedQuery("FieldOfWork.findAll");
        List<FieldOfWork> entities = query.getResultList();
        return entities;
    }

    @Override
    public void create(FieldOfWork entity) {
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();
        em.persist(entity);
        transaction.commit();
    }

    @Override
    public void update(Integer id, FieldOfWork changes) {
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();
        FieldOfWork managed = em.find(FieldOfWork.class, id);

        if (managed != null) {
            if (changes.getFieldOfWorkId()!= null) {
                managed.setFieldOfWorkId(changes.getFieldOfWorkId());
            }
        }

        transaction.commit();
    }

    @Override
    public boolean remove(Integer id) {
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();
        FieldOfWork managed = em.find(FieldOfWork.class, id);
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
