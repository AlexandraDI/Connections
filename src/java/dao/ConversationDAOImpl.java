package dao;

import dao.definitions.UserDAO;
import dao.definitions.ConversationDAO;
import java.util.ArrayList;
import java.util.List;
import java.util.Date;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import jpautils.EntityManagerHelper;
import model.User;
import model.Conversation;
import model.UserIsConnectedToUser;

public class ConversationDAOImpl extends DaoEM implements ConversationDAO {
    
    @Override
    public Conversation findConversation(Integer id) {
        Conversation conversation = em.find(Conversation.class, id);
        return conversation;
    }    

    @Override
    public List<Conversation> find(Integer userId) {
        UserDAOImpl dao = new UserDAOImpl();
        User find = dao.find(userId);
        if (find == null) {
            return null;
        } else {
            return find.getConversationList();
        }
    }  
    
    @Override
    public List<Conversation> find2(Integer userId) {
        UserDAOImpl dao = new UserDAOImpl();
        User find = dao.find(userId);
        if (find == null) {
            return null;
        } else {
            return find.getConversationList1();
        }
    }     
    
    
    @Override
    public List<User> findConnections(Integer userId) {
        User who = em.find(User.class, userId);
        if (who != null) {
            List<Conversation> pairs = who.getConversationList1();
            List<User> users = new ArrayList<>();

            for (Conversation pair : pairs) {
                User other = em.find(User.class, pair.getUser1Id());
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
            List<Conversation> pairs = who.getConversationList();
            List<User> users = new ArrayList<>();

            for (Conversation pair : pairs) {
                User other = em.find(User.class, pair.getUser2Id());
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
    public Conversation startConversation(Integer user1Id, Integer user2Id, Date date, String header) {
        EntityTransaction transaction = em.getTransaction();
        User who = em.find(User.class, user1Id);
        User whom = em.find(User.class, user2Id);

        if (who != null && whom != null) {
            transaction.begin();
            Conversation entity = new Conversation();
            entity.setUser1Id(who);
            entity.setUser2Id(whom);
            entity.setDatetimeStarted(date);
            entity.setDatetimeUpdated(date);
            entity.setHeader(header);
            em.persist(entity);
            transaction.commit();
            return entity;
        } else {
            return null;
        }
    }

    @Override
    public boolean stopConversation(Integer user1Id, Integer user2Id, Date date, String header) {
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();
        User who = em.find(User.class, user1Id);
        User whom = em.find(User.class, user2Id);

        if (who != null && whom != null) {
            transaction.begin();
            Conversation entity = new Conversation();
            entity.setUser1Id(who);
            entity.setUser2Id(whom);
            entity.setDatetimeStarted(date);
            entity.setDatetimeUpdated(date);
            entity.setHeader(header);
            em.remove(entity);
            transaction.commit();
            return true;
        } else {
            return false;
        }      
        
    }
    
    @Override
    public void update(Integer id, Conversation changes) {
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();
        Conversation managed = em.find(Conversation.class, id);

        if (managed != null) {
            if (changes.getDatetimeUpdated()!= null) {
                managed.setDatetimeUpdated(changes.getDatetimeUpdated());
            }
        }

        transaction.commit();
    }
    
    
    
    
}
