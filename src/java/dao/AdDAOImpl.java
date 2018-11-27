package dao;

import dao.definitions.AdDAO;
import java.util.HashSet;
import java.util.List;

import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import model.Ad;

public class AdDAOImpl extends DaoEM implements AdDAO {

    @Override
    public Ad find(Integer id) {
        Ad entity = em.find(Ad.class, id);
        return entity;
    }

    @Override
    public List<Ad> list() {
        Query query = em.createNamedQuery("Ad.findAll");
        List<Ad> entities = query.getResultList();
        return entities;
    }

    @Override
    public void create(Ad entity) {
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();
        em.persist(entity);
        transaction.commit();
    }

    @Override
    public void update(Integer id, Ad changes) {
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();
        Ad managed = em.find(Ad.class, id);

        if (managed != null) {
            if (changes.getAdId()!= null) {
                managed.setAdId(changes.getAdId());
            }
            if (changes.getTitle()!= null) {
                managed.setTitle(changes.getTitle());
            }
            if (changes.getDescription()!= null) {
                managed.setDescription(changes.getDescription());
            }
            if (changes.getJobId()!= null) {
                managed.setJobId(changes.getJobId());
            }            
        }

        transaction.commit();
    }

    @Override
    public boolean remove(Integer id) {
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();
        Ad managed = em.find(Ad.class, id);
        if (managed != null) {
            em.remove(managed);
            transaction.commit();
            return true;
        } else {
            transaction.commit();
            return false;
        }
    }

    
    private HashSet<Integer> retrieveSkillset(Integer user_pk) {
        Query q = em.createNativeQuery("select skill.skill_id from ad inner join job on ad.job_id = job.job_id inner join job_has_skill on job.job_id = job_has_skill.job_id inner join skill on job_has_skill.skill_id = skill.skill_id where ad_id =  " + user_pk);
        List ids = q.getResultList();

        HashSet<Integer> result = new HashSet<>();

        for (Object r : ids) {
            Integer id = (Integer) r;
            result.add(id);
        }

        return result;
    }

    private HashSet<Integer> retrieveLanguageset(Integer user_pk) {
        Query q = em.createNativeQuery("select language.language_id from ad inner join job on ad.job_id = job.job_id inner join job_requires_language on job.job_id = job_requires_language.job_id inner join language on job_requires_language.language_id = language.language_id where ad_id = " + user_pk);
        List ids = q.getResultList();

        HashSet<Integer> result = new HashSet<>();

        for (Object r : ids) {
            Integer id = (Integer) r;
            result.add(id);
        }

        return result;
    }
    
    public double[] buildVector(Integer ad_pk, List<Integer> all_languages, List<Integer> all_skills) {
        int M = all_skills.size();
        int N = all_languages.size();

        int D = M + N;

        double[] uv = new double[D];

        HashSet<Integer> skilset = retrieveSkillset(ad_pk);
        HashSet<Integer> languageset = retrieveLanguageset(ad_pk);

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
