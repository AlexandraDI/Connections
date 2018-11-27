package dao;

import dao.definitions.ReactionDAO;
import java.util.List;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import model.Reaction;


public class ReactionDAOImpl extends DaoEM implements ReactionDAO {

    @Override
    public Reaction find(Integer id) {
        Reaction entity = em.find(Reaction.class, id);
        return entity;
    }
    
    public Reaction find(Integer userId, Integer articleId) {
         Query query = em.createNamedQuery("Reaction.findByPK").setParameter("userId", userId).setParameter("articleId", articleId);
        return (Reaction) query.getSingleResult();
    }
    

    @Override
    public List<Reaction> list() {
        Query query = em.createNamedQuery("Reaction.findAll");
        List<Reaction> entities = query.getResultList();
        return entities;
    }

    @Override
    public void create(Reaction entity) {
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();
        em.persist(entity);
        transaction.commit();
    }

    @Override
    public void update(Integer id, Reaction changes) {
    }

    @Override
    public boolean remove(Integer id) {
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();
        Reaction managed = em.find(Reaction.class, id);
        if (managed != null) {
            em.remove(managed);
            transaction.commit();
            return true;
        } else {
            transaction.commit();
            return false;
        }
    }
    
     public boolean remove(Reaction managed) {
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();
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