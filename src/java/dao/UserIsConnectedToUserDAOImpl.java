package dao;

import dao.definitions.UserDAO;
import dao.definitions.UserIsConnectedToUserDAO;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import jpautils.EntityManagerHelper;
import model.User;
import model.UserFollowsUser;
import model.UserIsConnectedToUser;
import model.UserIsConnectedToUserPK;

public class UserIsConnectedToUserDAOImpl extends DaoEM implements UserIsConnectedToUserDAO {

    @Override
    public List<UserIsConnectedToUser> find(Integer userId) {
        UserDAOImpl dao = new UserDAOImpl();
        User find = dao.find(userId);
        if (find == null) {
            return null;
        } else {
            return find.getUserIsConnectedToUserList();
        }
    }  
    
    @Override
    public List<UserIsConnectedToUser> find2(Integer userId) {
        UserDAOImpl dao = new UserDAOImpl();
        User find = dao.find(userId);
        if (find == null) {
            return null;
        } else {
            return find.getUserIsConnectedToUserList1();
        }
    }     
    
    
    @Override
    public List<User> findConnections(Integer userId) {
        User who = em.find(User.class, userId);
        if (who != null) {
            List<UserIsConnectedToUser> pairs = who.getUserIsConnectedToUserList1();
            List<User> users = new ArrayList<>();

            for (UserIsConnectedToUser pair : pairs) {
                User other = em.find(User.class, pair.getUser());
                if (other != null) {
                    users.add(other);
                }
            }
            return users;
        } else {
            return null;
        }
    }

    @Override
    public List<User> findConnecting(Integer userId) {
        User who = em.find(User.class, userId);
        if (who != null) {
            List<UserIsConnectedToUser> pairs = who.getUserIsConnectedToUserList();
            List<User> users = new ArrayList<>();

            for (UserIsConnectedToUser pair : pairs) {
                User other = em.find(User.class, pair.getUser1());
                if (other != null) {
                    users.add(other);
                }
            }
            return users;
        } else {
            return null;
        }
    }

    @Override
    public boolean startConnecting(Integer followerId, Integer followedId) {
        EntityTransaction transaction = em.getTransaction();
        User who = em.find(User.class, followerId);
        User whom = em.find(User.class, followedId);

        if (who != null && whom != null) {
            transaction.begin();
            UserIsConnectedToUser entity = new UserIsConnectedToUser();
            entity.setUser(who);
            entity.setUser1(whom);
            em.persist(entity);
            transaction.commit();
            return true;
        } else {
            return false;
        }
    }

    @Override
    public boolean stopConnecting(Integer followerId, Integer followedId) {
        EntityTransaction transaction = em.getTransaction();
        User who = em.find(User.class, followerId);
        User whom = em.find(User.class, followedId);

        if (who != null && whom != null) {
            transaction.begin();
            UserIsConnectedToUser entity = new UserIsConnectedToUser();
            entity.setUser(who);
            entity.setUser1(whom);
            em.remove(entity);
            transaction.commit();
            return true;
        } else {
            return false;
        }
    }
    public void create(Integer userId, Integer adId, Date date) {

        
        EntityTransaction transaction = em.getTransaction();
        
        
        
        User whichuser = em.find(User.class, userId);
        User whichad = em.find(User.class, adId);
        
        
        if (whichuser != null && whichad != null) {            
        
            transaction.begin();
            UserIsConnectedToUser entity = new UserIsConnectedToUser();
            UserIsConnectedToUserPK pk = new UserIsConnectedToUserPK();
            pk.setUser1Id(whichuser.getUserId());
            pk.setUser2Id(whichad.getUserId());           

            entity.setUser(whichuser);
            entity.setUser1(whichad);
            
            entity.setDatetimeConnectionMade(date);
            entity.setUserIsConnectedToUserPK(pk);
            em.persist(entity);
            
            transaction.commit(); 

        }
        
         
                     
        
    }    
    
}
