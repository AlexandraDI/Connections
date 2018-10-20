package dao;

import dao.definitions.JobDAO;
import dao.definitions.UserDAO;
import dao.definitions.JobRequiresLanguageDAO;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import jpautils.EntityManagerHelper;
import model.Language;
import model.Job;

public class JobRequiresLanguageDAOImpl extends DaoEM implements JobRequiresLanguageDAO {

    @Override
    public List<Job> findLanguageJobs(Integer languageId) {
        LanguageDAOImpl dao = new LanguageDAOImpl();
        Language find = dao.find(languageId);
        if (find == null) {
            return null;
        } else {
            return find.getJobList();
        }
    }
    
    @Override
    public List<Language> findJobLanguages(Integer jobId) {
        JobDAOImpl dao = new JobDAOImpl();
        Job find = dao.find(jobId);
        if (find == null) {
            return null;
        } else {
            return find.getLanguageList();
        }
    }

    @Override
    public void create(Integer languageId, Integer jobId) {
        EntityTransaction transaction = em.getTransaction();
        
        transaction.begin();
        
        
        Language whichlanguage = em.find(Language.class, languageId);
        Job whichjob = em.find(Job.class, jobId);
        
        if (whichlanguage != null && whichjob != null) {
            whichlanguage.getJobList().add(whichjob);
            whichjob.getLanguageList().add(whichlanguage);
        }
        
        transaction.commit();
    }

    @Override
    public boolean remove(Integer languageId, Integer jobId) {
       
    
    
      EntityTransaction transaction = em.getTransaction();
      transaction.begin();
      
      Language whichlanguage = em.find(Language.class, languageId);
      Job whichjob = em.find(Job.class, jobId);
      
      if (whichlanguage != null && whichjob != null) {
            whichjob.getLanguageList().remove(whichlanguage);
            whichlanguage.getJobList().remove(whichjob);          
            //whichjob.getLanguageList().remove(whichlanguage);
            //whichjob.getLanguageList().remove(whichlanguage); 
            transaction.commit();
            return true;
      } else {
            transaction.commit();
            return false;
      }
            
    
    }


}
