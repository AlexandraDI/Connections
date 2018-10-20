
package dao;

import dao.definitions.SettingDAO;
import dao.definitions.UserDAO;
import dao.definitions.UserHasSkillDAO;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import jpautils.EntityManagerHelper;
import model.Language;
import model.UserHasSkill;
import model.Skill;
import model.User;
import model.UserConnectionRequestUser;
import model.UserConnectionRequestUserPK;
import model.UserHasSkillPK;





public class UserHasSkillDAOImpl extends DaoEM implements UserHasSkillDAO {

    @Override
    public List<UserHasSkill> findUserSkills(Integer userId) {
        UserDAOImpl dao = new UserDAOImpl();
        User find = dao.find(userId);
        if (find == null) {
            return null;
        } else {
            return find.getUserHasSkillList();
        }
    }
    
    /*
    @Override
    public List<User> findSettingUsers(Integer settingId) {
        SettingDAOImpl dao = new SettingDAOImpl();
        Setting find = dao.find(settingId);
        if (find == null) {
            return null;
        } else {
            return null;//find.;
        }      
        
    }*/

    @Override
    public void create(Integer userId, Integer skillId) {

        
        EntityTransaction transaction = em.getTransaction();
        
        
        
        User whichuser = em.find(User.class, userId);
        Skill whichskill = em.find(Skill.class, skillId);
        
        
        if (whichuser != null && whichskill != null) {            
        
            transaction.begin();
            UserHasSkill entity = new UserHasSkill();
            UserHasSkillPK pk = new UserHasSkillPK();
            pk.setUserId(whichuser.getUserId());
            pk.setSkillId(whichskill.getSkillId());

            entity.setUser(whichuser);
            entity.setSkill(whichskill);
            //entity.setValue("Asxeta");
            entity.setUserHasSkillPK(pk);
            em.persist(entity);
            
            transaction.commit(); 

        }
        
         
                     
        
    }
    
    
    

    @Override
    public boolean remove(Integer userId, Integer skillId) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    /*
      EntityTransaction transaction = em.getTransaction();
      transaction.begin();
      
      User whichuser = em.find(User.class, userId);
      Skill whichskill = em.find(Skill.class, skillId);
      
      if (whichuser != null && whichskill != null) {
            whichuser.getUserHasSkillList().remove(whichskill);
            whichskill.getUserHasSkillList().remove(whichuser); 
            transaction.commit();
            return true;
      } else {
            transaction.commit();
            return false;
      }*/
         EntityTransaction transaction = em.getTransaction();

        UserHasSkillPK userHasSkillPK = new UserHasSkillPK();
        userHasSkillPK.setUserId(userId);
        userHasSkillPK.setSkillId(skillId);

        transaction.begin();
        UserHasSkill entity = em.find(UserHasSkill.class, userHasSkillPK);

        em.remove(entity);
        transaction.commit();
        return true;   
         
    
    }

    

}

