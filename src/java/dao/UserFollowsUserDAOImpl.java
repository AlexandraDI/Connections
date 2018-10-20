package dao;

import dao.definitions.LanguageDAO;
import dao.definitions.UserDAO;
import dao.definitions.UserFollowsUserDAO;
import dao.definitions.UserHasLanguageDAO;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import jpautils.EntityManagerHelper;
import model.Language;
import model.User;
import model.UserFollowsUser;
import model.UserHasSetting;

public class UserFollowsUserDAOImpl extends DaoEM implements UserFollowsUserDAO {

    @Override
    public List<UserFollowsUser> find(Integer userId) {
        UserDAOImpl dao = new UserDAOImpl();
        User find = dao.find(userId);
        if (find == null) {
            return null;
        } else {
            return find.getUserFollowsUserList();
        }
    }  
    
    @Override
    public List<UserFollowsUser> find2(Integer userId) {
        UserDAOImpl dao = new UserDAOImpl();
        User find = dao.find(userId);
        if (find == null) {
            return null;
        } else {
            return find.getUserFollowsUserList1();
        }
    }     

    @Override
    public List<User> findFollowers(Integer userId) {
        User who = em.find(User.class, userId);
        if (who != null) {
            List<UserFollowsUser> pairs = who.getUserFollowsUserList1();
            List<User> users = new ArrayList<>();

            for (UserFollowsUser pair : pairs) {
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
    public List<User> findFollowing(Integer userId) {
        User who = em.find(User.class, userId);
        if (who != null) {
            List<UserFollowsUser> pairs = who.getUserFollowsUserList();
            List<User> users = new ArrayList<>();

            for (UserFollowsUser pair : pairs) {
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
    public boolean startFollowing(Integer followerId, Integer followedId) {
        EntityTransaction transaction = em.getTransaction();
        User who = em.find(User.class, followerId);
        User whom = em.find(User.class, followedId);

        if (who != null && whom != null) {
            transaction.begin();
            UserFollowsUser entity = new UserFollowsUser();
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
    public boolean stopFollowing(Integer followerId, Integer followedId) {
        EntityTransaction transaction = em.getTransaction();
        User who = em.find(User.class, followerId);
        User whom = em.find(User.class, followedId);

        if (who != null && whom != null) {
            transaction.begin();
            UserFollowsUser entity = new UserFollowsUser();
            entity.setUser(who);
            entity.setUser1(whom);
            em.remove(entity);
            transaction.commit();
            return true;
        } else {
            return false;
        }
    }
}
