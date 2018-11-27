
package dao;

import dao.definitions.UserApplyAdDAO;
import java.util.List;
import java.sql.Date;

import javax.persistence.EntityTransaction;

import model.UserApplyAd;
import model.Ad;
import model.User;
import model.UserApplyAdPK;




public class UserApplyAdDAOImpl extends DaoEM implements UserApplyAdDAO {
    
    
    @Override
    public List<UserApplyAd> find(Integer adId) {
        UserDAOImpl dao = new UserDAOImpl();
        User find = dao.find(adId);
        if (find == null) {
            return null;
        } else {
            return find.getUserApplyAdList();
        }
    }    

    @Override
    public List<UserApplyAd> findUserAds(Integer userId) {
        UserDAOImpl dao = new UserDAOImpl();
        User find = dao.find(userId);
        if (find == null) {
            return null;
        } else {
            return find.getUserApplyAdList();
        }
    }
    
    @Override
    public List<UserApplyAd> findAdUsers(Integer adId) {
        AdDAOImpl dao = new AdDAOImpl();
        Ad find = dao.find(adId);
        if (find == null) {
            return null;
        } else {
            return find.getUserApplyAdList();
        }      
        
    }

    @Override
    public void create(Integer userId, Integer adId, Date date) {

        
        EntityTransaction transaction = em.getTransaction();
        
        
        
        User whichuser = em.find(User.class, userId);
        Ad whichad = em.find(Ad.class, adId);
        
        
        if (whichuser != null && whichad != null) {            
        
            transaction.begin();
            UserApplyAd entity = new UserApplyAd();
            UserApplyAdPK pk = new UserApplyAdPK();
            pk.setUserId(whichuser.getUserId());
            pk.setAdId(whichad.getAdId());           

            entity.setUser(whichuser);
            entity.setAd(whichad);
            
            entity.setDateOfApplication(date);
            entity.setUserApplyAdPK(pk);
            em.persist(entity);
            
            transaction.commit(); 

        }
        
         
                     
        
    }
    
    
    

    @Override
    public boolean remove(Integer userId, Integer adId) {

         EntityTransaction transaction = em.getTransaction();

        UserApplyAdPK userApplyAdPK = new UserApplyAdPK();
        userApplyAdPK.setUserId(userId);
        userApplyAdPK.setAdId(adId);
        

        transaction.begin();
        UserApplyAd entity = em.find(UserApplyAd.class, userApplyAdPK);

        em.remove(entity);
        transaction.commit();
        return true;     
            
    
    }

    

}

