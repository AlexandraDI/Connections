package dao;

import dao.definitions.CertificationDAO;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import jpautils.EntityManagerHelper;
import model.Certification;

public class CertificationDAOImpl extends DaoEM implements CertificationDAO {

    @Override
    public Certification find(Integer id) {
        Certification entity = em.find(Certification.class, id);
        return entity;
    }

    @Override
    public List<Certification> list() {
        Query query = em.createNamedQuery("Certification.findAll");
        List<Certification> entities = query.getResultList();
        return entities;
    }

    @Override
    public void create(Certification entity) {
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();
        em.persist(entity);
        transaction.commit();
    }

    @Override
    public void update(Integer id, Certification changes) {
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();
        Certification managed = em.find(Certification.class, id);

        if (managed != null) {
            if (changes.getCertificationId()!= null) {
                managed.setCertificationId(changes.getCertificationId());
            }
        }

        transaction.commit();
    }

    @Override
    public boolean remove(Integer id) {
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();
        Certification managed = em.find(Certification.class, id);
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
