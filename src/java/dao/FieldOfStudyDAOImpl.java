package dao;

import dao.definitions.FieldOfStudyDAO;
import java.util.List;

import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import model.FieldOfStudy;

public class FieldOfStudyDAOImpl extends DaoEM implements FieldOfStudyDAO {

    @Override
    public FieldOfStudy find(Integer id) {
        FieldOfStudy entity = em.find(FieldOfStudy.class, id);
        return entity;
    }

    @Override
    public List<FieldOfStudy> list() {
        Query query = em.createNamedQuery("FieldOfStudy.findAll");
        List<FieldOfStudy> entities = query.getResultList();
        return entities;
    }

    @Override
    public void create(FieldOfStudy entity) {
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();
        em.persist(entity);
        transaction.commit();
    }

    @Override
    public void update(Integer id, FieldOfStudy changes) {
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();
        FieldOfStudy managed = em.find(FieldOfStudy.class, id);

        if (managed != null) {
            if (changes.getFieldOfStudyId()!= null) {
                managed.setFieldOfStudyId(changes.getFieldOfStudyId());
            }
        }

        transaction.commit();
    }

    @Override
    public boolean remove(Integer id) {
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();
        FieldOfStudy managed = em.find(FieldOfStudy.class, id);
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
