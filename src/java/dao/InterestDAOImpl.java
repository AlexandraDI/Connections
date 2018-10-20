package dao;

import dao.definitions.InterestDAO;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import jpautils.EntityManagerHelper;
import model.Interest;

public class InterestDAOImpl extends DaoEM implements InterestDAO {

    @Override
    public Interest find(Integer idinterest) {
        Interest interest = em.find(Interest.class, idinterest);
        return interest;
    }

    @Override
    public List<Interest> list() {
        Query query = em.createNamedQuery("Interest.findAll");
        List<Interest> interest = query.getResultList();
        return interest;
    }

    @Override
    public void create(Interest interest) {
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();
        em.persist(interest);
        transaction.commit();
    }

    @Override
    public void update(Integer id, Interest changes) {
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();
        Interest managed = em.find(Interest.class, id);

        if (managed != null) {
            if (changes.getInterestId() != null) {
                managed.setInterestId(changes.getInterestId());
            }
        }

        transaction.commit();
    }

    @Override
    public boolean remove(Integer id) {
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();
        Interest managed = em.find(Interest.class, id);
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
