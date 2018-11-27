package dao;

import dao.definitions.DepartmentHasFieldOfStudyDAO;
import java.util.List;

import javax.persistence.EntityTransaction;

import model.Department;
import model.FieldOfStudy;

public class DepartmentHasFieldOfStudyDAOImpl extends DaoEM implements DepartmentHasFieldOfStudyDAO {

    @Override
    public List<FieldOfStudy> find1(Integer departmentId) {
        DepartmentDAOImpl dao = new DepartmentDAOImpl();
        Department find = dao.find(departmentId);
        if (find == null) {
            return null;
        } else {
            return find.getFieldOfStudyList();
        }
    }
    
    @Override
    public List<Department> find2(Integer fieldofstudyId) {
        FieldOfStudyDAOImpl dao = new FieldOfStudyDAOImpl();
        FieldOfStudy find = dao.find(fieldofstudyId);
        if (find == null) {
            return null;
        } else {
            return find.getDepartmentList();
        }
    }

    @Override
    public void create(Integer departmentId, Integer fieldofstudyId) {
        EntityTransaction transaction = em.getTransaction();
        
        transaction.begin();
        
        
        Department whichdepartment = em.find(Department.class, departmentId);
        FieldOfStudy whichfield = em.find(FieldOfStudy.class, fieldofstudyId);
        
        if (whichdepartment != null && whichfield != null) {
            whichdepartment.getFieldOfStudyList().add(whichfield);
            whichfield.getDepartmentList().add(whichdepartment);
        }
        
        transaction.commit();
    }

    @Override
    public boolean remove(Integer departmentId, Integer fieldofstudyId) {
    
      EntityTransaction transaction = em.getTransaction();
      transaction.begin();
      
      Department whichdepartment = em.find(Department.class, departmentId);
      FieldOfStudy whichfield = em.find(FieldOfStudy.class, fieldofstudyId);
      
      if (whichdepartment != null && whichfield != null) {
            whichdepartment.getFieldOfStudyList().remove(whichfield);
            whichfield.getDepartmentList().remove(whichdepartment); 
            transaction.commit();
            return true;
      } else {
            transaction.commit();
            return false;
      }
            
      
    }


}
