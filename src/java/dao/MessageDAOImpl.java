package dao;

import dao.definitions.MessageDAO;
import java.util.List;

import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import model.Message;

public class MessageDAOImpl extends DaoEM implements MessageDAO {

    @Override
    public Message find(Integer id) {
        Message entity = em.find(Message.class, id);
        return entity;
    }

    @Override
    public List<Message> list() {
        Query query = em.createNamedQuery("Message.findAll");
        List<Message> entities = query.getResultList();
        return entities;
    }

    @Override
    public void create(Message entity) {
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();
        em.persist(entity);
        transaction.commit();
    }

    @Override
    public void update(Integer id, Message changes) {
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();
        Message managed = em.find(Message.class, id);

        if (managed != null) {
            if (changes.getMessageId()!= null) {
                managed.setMessageId(changes.getMessageId());
            }
        }

        transaction.commit();
    }

    @Override
    public boolean remove(Integer id) {
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();
        Message managed = em.find(Message.class, id);
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
