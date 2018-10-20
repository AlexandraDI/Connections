package dao;

import dao.definitions.CommentDAO;
import dao.definitions.UserDAO;
import java.util.ArrayList;
import java.util.List;
import java.util.Date;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import jpautils.EntityManagerHelper;
import model.Article;
import model.Comment;
import model.User;

public class CommentDAOImpl extends DaoEM implements CommentDAO {

    @Override
    public Comment find(Integer id) {
        Comment entity = em.find(Comment.class, id);
        return entity;
    }

    @Override
    public List<Comment> list() {
        Query query = em.createNamedQuery("Comment.findAll");
        List<Comment> entities = query.getResultList();
        return entities;
    }

    @Override
    public void create(Comment entity) {
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();
        em.persist(entity);
        transaction.commit();
    }
    
    @Override
    public boolean startComment(Integer userId, Integer articleId, Date date, String content) {
        EntityTransaction transaction = em.getTransaction();
        User who = em.find(User.class, userId);
        Article article = em.find(Article.class, articleId);

        if (who != null && article != null) {
            transaction.begin();
            Comment entity = new Comment();
            entity.setUserId(who);
            entity.setArticleId(article);
            entity.setDatetimeCreated(date);
            //entity.s
            //entity.setDatetimeUpdated(date);
            entity.setContent(content);
            em.persist(entity);
            transaction.commit();
            return true;
        } else {
            return false;
        }
    }    

    @Override
    public void update(Integer id, Comment changes) {
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();
        Comment managed = em.find(Comment.class, id);

        if (managed != null) {
            if (changes.getCommentId()!= null) {
                managed.setCommentId(changes.getCommentId());
            }
        }

        transaction.commit();
    }

    @Override
    public boolean remove(Integer id) {
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();
        Comment managed = em.find(Comment.class, id);
        if (managed != null) {
            em.remove(managed);
            transaction.commit();
            return true;
        } else {
            transaction.commit();
            return false;
        }
    }
    
     public boolean remove(Comment managed) {
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
