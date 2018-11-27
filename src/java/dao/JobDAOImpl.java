package dao;

import dao.definitions.JobDAO;
import java.util.List;

import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import model.Job;

public class JobDAOImpl extends DaoEM implements JobDAO {

    @Override
    public Job find(Integer id) {
        Job entity = em.find(Job.class, id);
        return entity;
    }

    @Override
    public List<Job> list() {
        Query query = em.createNamedQuery("Job.findAll");
        List<Job> entities = query.getResultList();
        return entities;
    }

    @Override
    public void create(Job entity) {
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();
        em.persist(entity);
        transaction.commit();
    }

    @Override
    public void update(Integer id, Job changes) {
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();
        Job managed = em.find(Job.class, id);

        if (managed != null) {
            if (changes.getJobId()!= null) {
                managed.setJobId(changes.getJobId());
            }
        }

        transaction.commit();
    }

    @Override
    public boolean remove(Integer id) {
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();
        Job managed = em.find(Job.class, id);
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
