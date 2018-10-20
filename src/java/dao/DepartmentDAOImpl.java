package dao;

import dao.definitions.DepartmentDAO;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import jpautils.EntityManagerHelper;
import model.Department;

public class DepartmentDAOImpl extends DaoEM implements DepartmentDAO {

    @Override
    public Department find(Integer id) {
        Department entity = em.find(Department.class, id);
        return entity;
    }

    @Override
    public List<Department> list() {
        Query query = em.createNamedQuery("Department.findAll");
        List<Department> entities = query.getResultList();
        return entities;
    }

    @Override
    public void create(Department entity) {
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();
        em.persist(entity);
        transaction.commit();
    }

    @Override
    public void update(Integer id, Department changes) {
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();
        Department managed = em.find(Department.class, id);

        if (managed != null) {
            if (changes.getDepartmentId()!= null) {
                managed.setDepartmentId(changes.getDepartmentId());
            }
        }

        transaction.commit();
    }

    @Override
    public boolean remove(Integer id) {
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();
        Department managed = em.find(Department.class, id);
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
