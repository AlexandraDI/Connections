package dao;

import dao.definitions.UserDAO;
import java.util.HashSet;
import java.util.List;

import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import model.User;

public class UserDAOImpl extends DaoEM implements UserDAO {

    @Override
    public User find(String email) {
        Query query = em.createNamedQuery("User.findByEmail").setParameter("email", email);
        Object o = query.getSingleResult();
        if (o != null) {
            return (User) query.getSingleResult();
        } else {
            return null;
        }
    }

    @Override
    public User find(Integer id) {
        User user = em.find(User.class, id);
        return user;
    }

    @Override
    public List<User> list() {
        Query query = em.createNamedQuery("User.findAll");
        List<User> users = query.getResultList();
        return users;
    }

    @Override
    public void create(User user) {
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();
        em.persist(user);
        transaction.commit();
    }

    @Override
    public void update(Integer id, User changes) {
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();
        User managed = em.find(User.class, id);

        if (managed != null) {
            if (changes.getPassword() != null) {
                managed.setPassword(changes.getPassword());
            }

            if (changes.getFirstname() != null) {
                managed.setFirstname(changes.getFirstname());
            }

            if (changes.getEmail() != null) {
                managed.setEmail(changes.getEmail());
            }
        }

        transaction.commit();
    }

    @Override
    public boolean remove(Integer id) {
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();
        User managed = em.find(User.class, id);
        if (managed != null) {
            em.remove(managed);
            transaction.commit();
            return true;
        } else {
            transaction.commit();
            return false;
        }

    }

    public List<User> search(String what) {
        Query query = em.createNamedQuery("User.findByQuery").setParameter("what", "%" + what + "%");
        List<User> users = query.getResultList();
        return users;
    }

    private HashSet<Integer> retrieveSkillset(Integer user_pk) {
        Query q = em.createNativeQuery("select skill_id from user natural join user_has_skill natural join skill where user_id = " + user_pk);
        List ids = q.getResultList();

        HashSet<Integer> result = new HashSet<>();

        for (Object r : ids) {
            Integer id = (Integer) r;
            result.add(id);
        }

        return result;
    }

    private HashSet<Integer> retrieveLanguageset(Integer user_pk) {
        Query q = em.createNativeQuery("select language_id from user natural join user_has_language natural join language where user_id = " + user_pk);
        List ids = q.getResultList();

        HashSet<Integer> result = new HashSet<>();

        for (Object r : ids) {
            Integer id = (Integer) r;
            result.add(id);
        }

        return result;
    }

    public double[] buildVector(Integer user_pk, List<Integer> all_languages, List<Integer> all_skills) {
        int M = all_skills.size();
        int N = all_languages.size();

        int D = M + N;

        double[] uv = new double[D];

        HashSet<Integer> skilset = retrieveSkillset(user_pk);
        HashSet<Integer> languageset = retrieveLanguageset(user_pk);

        for (int i = 0; i < all_skills.size(); i++) {
            if (skilset.contains(all_skills.get(i))) {
                uv[i] = 1;
            }
        }
        
         for (int i = 0; i < all_languages.size(); i++) {
            if (languageset.contains(all_languages.get(i))) {
                uv[i+M] = 1;
            }
        }

        return uv;
    }

}
