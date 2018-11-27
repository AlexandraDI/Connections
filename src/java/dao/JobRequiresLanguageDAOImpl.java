package dao;

import dao.definitions.JobRequiresLanguageDAO;
import java.util.List;

import javax.persistence.EntityTransaction;

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
            transaction.commit();
            return true;
      } else {
            transaction.commit();
            return false;
      }
            
    
    }


}
