package dao;

import dao.definitions.ProfessionalExperienceDAO;
import dao.definitions.UserDAO;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import jpautils.EntityManagerHelper;
import model.ProfessionalExperience;
import model.User;

public class ProfessionalExperienceDAOImpl extends DaoEM implements ProfessionalExperienceDAO {

    @Override
    public ProfessionalExperience find(Integer id) {
        ProfessionalExperience entity = em.find(ProfessionalExperience.class, id);
        return entity;
    }

    @Override
    public List<ProfessionalExperience> list() {
        Query query = em.createNamedQuery("ProfessionalExperience.findAll");
        List<ProfessionalExperience> entities = query.getResultList();
        return entities;
    }

    @Override
    public void create(ProfessionalExperience entity) {
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();
        em.persist(entity);
        transaction.commit();
    }

    @Override
    public void update(Integer id, ProfessionalExperience changes) {
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();
        ProfessionalExperience managed = em.find(ProfessionalExperience.class, id);

        if (managed != null) {
            if (changes.getProfessionalExperienceId()!= null) {
                managed.setProfessionalExperienceId(changes.getProfessionalExperienceId());
            }
        }

        transaction.commit();
    }

    @Override
    public boolean remove(Integer id) {
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();
        ProfessionalExperience managed = em.find(ProfessionalExperience.class, id);
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
