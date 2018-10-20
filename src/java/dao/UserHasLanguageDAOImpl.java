package dao;

import dao.definitions.LanguageDAO;
import dao.definitions.UserDAO;
import dao.definitions.UserHasLanguageDAO;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import jpautils.EntityManagerHelper;
import model.Language;
import model.User;

public class UserHasLanguageDAOImpl extends DaoEM implements UserHasLanguageDAO {

    @Override
    public List<Language> findUserLanguages(Integer userId) {
        UserDAOImpl dao = new UserDAOImpl();
        User find = dao.find(userId);
        if (find == null) {
            return null;
        } else {
            return find.getLanguageList();
        }
    }
    
    @Override
    public List<User> findLanguageUsers(Integer languageId) {
        LanguageDAOImpl dao = new LanguageDAOImpl();
        Language find = dao.find(languageId);
        if (find == null) {
            return null;
        } else {
            return find.getUserList();
        }
    }

    @Override
    public void create(Integer userId, Integer languageId) {
        EntityTransaction transaction = em.getTransaction();
        
        transaction.begin();
        
        
        User whichuser = em.find(User.class, userId);
        Language whichlanguage = em.find(Language.class, languageId);
        
        if (whichuser != null && whichlanguage != null) {
            whichuser.getLanguageList().add(whichlanguage);
            whichlanguage.getUserList().add(whichuser);
        }
        
        transaction.commit();
    }

    @Override
    public boolean remove(Integer userId, Integer languageId) {
    
      EntityTransaction transaction = em.getTransaction();
      transaction.begin();
      
      User whichuser = em.find(User.class, userId);
      Language whichlanguage = em.find(Language.class, languageId);
      
      if (whichuser != null && whichlanguage != null) {
            whichuser.getLanguageList().remove(whichlanguage);
            whichlanguage.getUserList().remove(whichuser); 
            transaction.commit();
            return true;
      } else {
            transaction.commit();
            return false;
      }
            
      
    }


}
