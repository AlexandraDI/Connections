package dao;

import dao.definitions.SkillDAO;
import dao.definitions.JobDAO;
import dao.definitions.JobHasSkillDAO;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import jpautils.EntityManagerHelper;
import model.Job;
import model.Skill;

public class JobHasSkillDAOImpl extends DaoEM implements JobHasSkillDAO {

    @Override
    public List<Skill> findJobSkills(Integer userId) {
        JobDAOImpl dao = new JobDAOImpl();
        Job find = dao.find(userId);
        if (find == null) {
            return null;
        } else {
            return find.getSkillList();
        }
    }
    
    @Override
    public List<Job> findSkillJobs(Integer skillId) {
        SkillDAOImpl dao = new SkillDAOImpl();
        Skill find = dao.find(skillId);
        if (find == null) {
            return null;
        } else {
            return find.getJobList();
        }
    }

    @Override
    public void create(Integer jobId, Integer skillId) {
        EntityTransaction transaction = em.getTransaction();
        
        transaction.begin();
        
        
        Job whichjob = em.find(Job.class, jobId);
        Skill whichskill = em.find(Skill.class, skillId);
        
        if (whichjob != null && whichskill != null) {
            whichjob.getSkillList().add(whichskill);
            whichskill.getJobList().add(whichjob);
        }
        
        transaction.commit();
    }

    @Override
    public boolean remove(Integer jobId, Integer skillId) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    
    
      EntityTransaction transaction = em.getTransaction();
      transaction.begin();
      
      Job whichjob = em.find(Job.class, jobId);
      Skill whichskill = em.find(Skill.class, skillId);
      
      if (whichskill != null && whichjob != null) {
            whichjob.getSkillList().remove(whichskill);
            whichskill.getJobList().remove(whichjob); 
            transaction.commit();
            return true;
      } else {
            transaction.commit();
            return false;
      }
            
    
    }


}
