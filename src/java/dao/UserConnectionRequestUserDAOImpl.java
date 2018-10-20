package dao;

import dao.definitions.UserDAO;
import dao.definitions.UserConnectionRequestUserDAO;
import dao.definitions.UserHasLanguageDAO;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import jpautils.EntityManagerHelper;
import model.User;
import model.UserConnectionRequestUser;
import model.UserConnectionRequestUserPK;

public class UserConnectionRequestUserDAOImpl extends DaoEM implements UserConnectionRequestUserDAO {

    @Override
    public List<UserConnectionRequestUser> find(Integer userId) {
        UserDAOImpl dao = new UserDAOImpl();
        User find = dao.find(userId);
        if (find == null) {
            return null;
        } else {
            return find.getUserConnectionRequestUserList();
        }
    }

    public UserConnectionRequestUser find(Integer user1Id, Integer user2Id) {
        Query query = em.createNamedQuery("UserConnectionRequestUser.findByPK").setParameter("user1Id", user1Id).setParameter("user2Id", user2Id);
        return (UserConnectionRequestUser) query.getSingleResult();
    }

    @Override
    public List<UserConnectionRequestUser> find2(Integer userId) {
        UserDAOImpl dao = new UserDAOImpl();
        User find = dao.find(userId);
        if (find == null) {
            return null;
        } else {
            return find.getUserConnectionRequestUserList1();
        }
    }

    @Override
    public List<User> findRequests(Integer userId) {
        User who = em.find(User.class, userId);
        if (who != null) {
            List<UserConnectionRequestUser> pairs = who.getUserConnectionRequestUserList1();
            List<User> users = new ArrayList<>();

            for (UserConnectionRequestUser pair : pairs) {
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
    public List<User> findRequested(Integer userId) {
        User who = em.find(User.class, userId);
        if (who != null) {
            List<UserConnectionRequestUser> pairs = who.getUserConnectionRequestUserList();
            List<User> users = new ArrayList<>();

            for (UserConnectionRequestUser pair : pairs) {
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
    public boolean startRequest(Integer followerId, Integer followedId) {
        EntityTransaction transaction = em.getTransaction();
        User who = em.find(User.class, followerId);
        User whom = em.find(User.class, followedId);

        if (who != null && whom != null) {
            transaction.begin();
            UserConnectionRequestUser entity = new UserConnectionRequestUser();

            UserConnectionRequestUserPK userConnectionRequestUserPK = new UserConnectionRequestUserPK();
            userConnectionRequestUserPK.setUser1Id(followerId);
            userConnectionRequestUserPK.setUser2Id(followedId);

            entity.setUserConnectionRequestUserPK(userConnectionRequestUserPK);

            entity.setUser(who);
            entity.setUser1(whom);
            entity.setDateOfRequest(new Date());
            entity.setStatus(0);
            em.persist(entity);
            transaction.commit();
            return true;
        } else {
            return false;
        }
    }

    @Override
    public boolean stopRequest(Integer followerId, Integer followedId) {
        EntityTransaction transaction = em.getTransaction();

        UserConnectionRequestUserPK userConnectionRequestUserPK = new UserConnectionRequestUserPK();
        userConnectionRequestUserPK.setUser1Id(followerId);
        userConnectionRequestUserPK.setUser2Id(followedId);

        transaction.begin();
        UserConnectionRequestUser entity = em.find(UserConnectionRequestUser.class, userConnectionRequestUserPK);

        em.remove(entity);
        transaction.commit();
        return true;
    }

    public boolean remove(UserConnectionRequestUser managed) {
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();
        if (managed != null) {
            em.remove(managed);
            transaction.commit();
            return true;
        } else {
            transaction.commit();
            return false;
        }
    }

}
