package dao;

import dao.definitions.CompanyDAO;
import dao.definitions.CompanyHasFieldOfWorkDAO;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import jpautils.EntityManagerHelper;
import model.Company;
import model.FieldOfWork;

public class CompanyHasFieldOfWorkDAOImpl extends DaoEM implements CompanyHasFieldOfWorkDAO {

    @Override
    public List<FieldOfWork> findCompanyFieldOfWorks(Integer companyId) {
        CompanyDAOImpl dao = new CompanyDAOImpl();
        Company find = dao.find(companyId);
        if (find == null) {
            return null;
        } else {
            return find.getFieldOfWorkList();
        }
    }
    
    @Override
    public List<Company> findFieldOfWorkCompanies(Integer fieldId) {
        FieldOfWorkDAOImpl dao = new FieldOfWorkDAOImpl();
        FieldOfWork find = dao.find(fieldId);
        if (find == null) {
            return null;
        } else {
            return find.getCompanyList();
        }
    }

    @Override
    public void create(Integer companyId, Integer fieldId) {
        EntityTransaction transaction = em.getTransaction();
        
        transaction.begin();
        
        
        Company whichcompany = em.find(Company.class, companyId);
        FieldOfWork whichfield = em.find(FieldOfWork.class, fieldId);
        
        if (whichcompany != null && whichfield != null) {
            whichcompany.getFieldOfWorkList().add(whichfield);
            whichfield.getCompanyList().add(whichcompany);
        }
        
        transaction.commit();
    }

    @Override
    public boolean remove(Integer companyId, Integer fieldId) {
       
    
    
      EntityTransaction transaction = em.getTransaction();
      transaction.begin();
      
      Company whichcompany = em.find(Company.class, companyId);
      FieldOfWork whichfield = em.find(FieldOfWork.class, fieldId);
      
      if (whichcompany != null && whichfield != null) {
            whichcompany.getFieldOfWorkList().remove(whichfield);
            whichfield.getCompanyList().remove(whichcompany); 
            transaction.commit();
            return true;
      } else {
            transaction.commit();
            return false;
      }
            
    
    }


}
