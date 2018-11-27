package dao;

import dao.definitions.SkillDAO;
import java.util.List;

import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import model.Skill;

public class SkillDAOImpl extends DaoEM implements SkillDAO {

    @Override
    public Skill find(Integer id) {
        Skill entity = em.find(Skill.class, id);
        return entity;
    }

    @Override
    public List<Skill> list() {
        Query query = em.createNamedQuery("Skill.findAll");
        List<Skill> entities = query.getResultList();
        return entities;
    }

    @Override
    public void create(Skill entity) {
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();
        em.persist(entity);
        transaction.commit();
    }

    @Override
    public void update(Integer id, Skill changes) {
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();
        Skill managed = em.find(Skill.class, id);

        if (managed != null) {
            if (changes.getSkillId()!= null) {
                managed.setSkillId(changes.getSkillId());
            }
        }

        transaction.commit();
    }

    @Override
    public boolean remove(Integer id) {
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();
        Skill managed = em.find(Skill.class, id);
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
