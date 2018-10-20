package dao;

import dao.definitions.ArticleDAO;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import jpautils.EntityManagerHelper;
import model.Article;

public class ArticleDAOImpl extends DaoEM implements ArticleDAO {

    @Override
    public Article find(Integer id) {
        Article article = em.find(Article.class, id);
        return article;
    }

    @Override
    public List<Article> list() {
        Query query = em.createNamedQuery("Article.findAll");
        List<Article> articles = query.getResultList();
        return articles;
    }

    @Override
    public void create(Article article) {
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();
        em.persist(article);
        transaction.commit();
    }

    @Override
    public void update(Integer id, Article changes) {
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();
        Article managed = em.find(Article.class, id);

        if (managed != null) {
            if (changes.getArticleId() != null) {
                managed.setArticleId(changes.getArticleId());
            }
        }

        transaction.commit();
    }

    @Override
    public boolean remove(Integer id) {
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();
        Article managed = em.find(Article.class, id);
        if (managed != null) {
            em.remove(managed);
            transaction.commit();
            return true;
        } else {
            transaction.commit();
            return false;
        }

    }

    private HashSet<Integer> retrieveReactionset(Integer user_pk) {
        Query q = em.createNativeQuery("select reaction.user_id from reaction where reaction.article_id = " + user_pk);
        List ids = q.getResultList();

        HashSet<Integer> result = new HashSet<>();

        if (ids != null) {
            for (Object r : ids) {
                Integer id = (Integer) r;
                result.add(id);
            }
        }
        return result;
    }

    private HashSet<Integer> retrieveCommentset(Integer user_pk) {
        Query q = em.createNativeQuery("select comment.comment_id from comment where comment.article_id =" + user_pk);
        List ids = q.getResultList();

        HashSet<Integer> result = new HashSet<>();

        if (ids != null) {
            for (Object r : ids) {
                Integer id = (Integer) r;
                result.add(id);
            }
        }

        return result;
    }

    public double[] buildVector(Integer ad_pk, List<Integer> all_reactions, List<Integer> all_comments) {
        int M = all_reactions.size();
        int N = all_comments.size();

        int D = M + N;

        double[] uv = new double[D];

        HashSet<Integer> reactionset = retrieveReactionset(ad_pk);
        HashSet<Integer> commentset = retrieveCommentset(ad_pk);

        for (int i = 0; i < all_reactions.size(); i++) {
            if (reactionset.contains(all_reactions.get(i))) {
                uv[i] = 1;
            }
        }

        for (int i = 0; i < all_comments.size(); i++) {
            if (commentset.contains(all_comments.get(i))) {
                uv[i + M] = 1;
            }
        }

        return uv;
    }

}
