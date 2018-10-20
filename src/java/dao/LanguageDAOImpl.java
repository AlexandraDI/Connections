package dao;

import dao.definitions.LanguageDAO;
import dao.definitions.UserDAO;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import jpautils.EntityManagerHelper;
import model.Language;
import model.User;

public class LanguageDAOImpl extends DaoEM implements LanguageDAO {

    @Override
    public Language find(Integer id) {
        Language entity = em.find(Language.class, id);
        return entity;
    }

    @Override
    public List<Language> list() {
        Query query = em.createNamedQuery("Language.findAll");
        List<Language> entities = query.getResultList();
        return entities;
    }

    @Override
    public void create(Language entity) {
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();
        em.persist(entity);
        transaction.commit();
    }

    @Override
    public void update(Integer id, Language changes) {
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();
        Language managed = em.find(Language.class, id);

        if (managed != null) {
            if (changes.getLanguage()!= null) {
                managed.setLanguage(changes.getLanguage());
            }
        }

        transaction.commit();
    }

    @Override
    public boolean remove(Integer id) {
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();
        Language managed = em.find(Language.class, id);
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
