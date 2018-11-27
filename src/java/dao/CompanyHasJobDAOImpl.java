package dao;

import dao.definitions.CompanyHasJobDAO;
import java.util.List;

import javax.persistence.EntityTransaction;

import model.Company;
import model.Job;

public class CompanyHasJobDAOImpl extends DaoEM implements CompanyHasJobDAO {

    @Override
    public List<Job> findCompanyJobs(Integer companyId) {
        CompanyDAOImpl dao = new CompanyDAOImpl();
        Company find = dao.find(companyId);
        if (find == null) {
            return null;
        } else {
            return find.getJobList();
        }
    }
    
    @Override
    public List<Company> findJobCompanies(Integer jobId) {
        JobDAOImpl dao = new JobDAOImpl();
        Job find = dao.find(jobId);
        if (find == null) {
            return null;
        } else {
            return find.getCompanyList();
        }
    }

    @Override
    public void create(Integer companyId, Integer jobId) {
        EntityTransaction transaction = em.getTransaction();
        
        transaction.begin();
        
        
        Company whichcompany = em.find(Company.class, companyId);
        Job whichjob = em.find(Job.class, jobId);
        
        if (whichcompany != null && whichjob != null) {
            whichcompany.getJobList().add(whichjob);
            whichjob.getCompanyList().add(whichcompany);
        }
        
        transaction.commit();
    }

    @Override
    public boolean remove(Integer companyId, Integer jobId) {       
    
    
      EntityTransaction transaction = em.getTransaction();
      transaction.begin();
      
      Company whichcompany = em.find(Company.class, companyId);
      Job whichjob = em.find(Job.class, jobId);
      
      if (whichcompany != null && whichjob != null) {
            whichcompany.getJobList().remove(whichjob);
            whichjob.getCompanyList().remove(whichcompany); 
            transaction.commit();
            return true;
      } else {
            transaction.commit();
            return false;
      }
            
    
    }


}
