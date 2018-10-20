package dao;

import dao.definitions.ToolsAndTechnologyDAO;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import jpautils.EntityManagerHelper;
import model.ToolsAndTechnology;

public class ToolsAndTechnologyDAOImpl extends DaoEM implements ToolsAndTechnologyDAO {

    @Override
    public ToolsAndTechnology find(Integer id) {
        ToolsAndTechnology entity = em.find(ToolsAndTechnology.class, id);
        return entity;
    }

    @Override
    public List<ToolsAndTechnology> list() {
        Query query = em.createNamedQuery("ToolsAndTechnology.findAll");
        List<ToolsAndTechnology> entities = query.getResultList();
        return entities;
    }

    @Override
    public void create(ToolsAndTechnology entity) {
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();
        em.persist(entity);
        transaction.commit();
    }

    @Override
    public void update(Integer id, ToolsAndTechnology changes) {
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();
        ToolsAndTechnology managed = em.find(ToolsAndTechnology.class, id);

        if (managed != null) {
            if (changes.getToolsAndTechnologyId()!= null) {
                managed.setToolsAndTechnologyId(changes.getToolsAndTechnologyId());
            }
        }

        transaction.commit();
    }

    @Override
    public boolean remove(Integer id) {
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();
        ToolsAndTechnology managed = em.find(ToolsAndTechnology.class, id);
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
