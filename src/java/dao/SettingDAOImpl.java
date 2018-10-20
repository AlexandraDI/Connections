package dao;

import dao.definitions.SettingDAO;
import dao.definitions.UserDAO;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import jpautils.EntityManagerHelper;
import model.Setting;
import model.User;

public class SettingDAOImpl extends DaoEM implements SettingDAO {

    @Override
    public Setting find(Integer id) {
        Setting entity = em.find(Setting.class, id);
        return entity;
    }

    @Override
    public List<Setting> list() {
        Query query = em.createNamedQuery("Setting.findAll");
        List<Setting> entities = query.getResultList();
        return entities;
    }

    @Override
    public void create(Setting entity) {
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();
        em.persist(entity);
        transaction.commit();
    }

    @Override
    public void update(Integer id, Setting changes) {
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();
        Setting managed = em.find(Setting.class, id);

        if (managed != null) {
            if (changes.getSettingId()!= null) {
                managed.setSettingId(changes.getSettingId());
            }
        }

        transaction.commit();
    }

    @Override
    public boolean remove(Integer id) {
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();
        Setting managed = em.find(Setting.class, id);
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