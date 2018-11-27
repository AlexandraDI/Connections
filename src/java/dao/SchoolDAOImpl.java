package dao;

import dao.definitions.SchoolDAO;
import java.util.List;

import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import model.School;

public class SchoolDAOImpl extends DaoEM implements SchoolDAO {

    @Override
    public School find(Integer id) {
        School entity = em.find(School.class, id);
        return entity;
    }

    @Override
    public List<School> list() {
        Query query = em.createNamedQuery("School.findAll");
        List<School> entities = query.getResultList();
        return entities;
    }

    @Override
    public void create(School entity) {
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();
        em.persist(entity);
        transaction.commit();
    }

    @Override
    public void update(Integer id, School changes) {
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();
        School managed = em.find(School.class, id);

        if (managed != null) {
            if (changes.getSchoolId()!= null) {
                managed.setSchoolId(changes.getSchoolId());
            }
        }

        transaction.commit();
    }

    @Override
    public boolean remove(Integer id) {
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();
        School managed = em.find(School.class, id);
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
