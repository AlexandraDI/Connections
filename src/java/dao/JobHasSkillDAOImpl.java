package dao;

import dao.definitions.JobHasSkillDAO;
import java.util.List;

import javax.persistence.EntityTransaction;

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
