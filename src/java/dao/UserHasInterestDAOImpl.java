package dao;

import dao.definitions.InterestDAO;
import dao.definitions.UserDAO;
import dao.definitions.UserHasInterestDAO;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import jpautils.EntityManagerHelper;
import model.Interest;
import model.User;

public class UserHasInterestDAOImpl extends DaoEM implements UserHasInterestDAO {

    @Override
    public List<Interest> findUserInterests(Integer userId) {
        UserDAOImpl dao = new UserDAOImpl();
        User find = dao.find(userId);
        if (find == null) {
            return null;
        } else {
            return find.getInterestList();
        }
    }
    @Override
    public List<User> findInterestUsers(Integer languageId) {
        InterestDAOImpl dao = new InterestDAOImpl();
        Interest find = dao.find(languageId);
        if (find == null) {
            return null;
        } else {
            return find.getUserList();
        }
    }

    @Override
    public void create(Integer userId, Integer interestId) {
        EntityTransaction transaction = em.getTransaction();
        
        transaction.begin();
        
        
        User whichuser = em.find(User.class, userId);
        Interest whichinterest = em.find(Interest.class, interestId);
        
        if (whichuser != null && whichinterest != null) {
            whichuser.getInterestList().add(whichinterest);
            whichinterest.getUserList().add(whichuser);
        }
        
        transaction.commit();
    }

    @Override
    public boolean remove(Integer userId, Integer interestId) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    
    
      EntityTransaction transaction = em.getTransaction();
      transaction.begin();
      
      User whichuser = em.find(User.class, userId);
      Interest whichinterest = em.find(Interest.class, interestId);
      
      if (whichuser != null && whichinterest != null) {
            //whichuser.getInterestList().remove(whichinterest);
            whichinterest.getUserList().remove(whichuser); 
            transaction.commit();
            return true;
      } else {
            transaction.commit();
            return false;
      }
            
    
    }


}
