package dao.definitions;

import java.util.List;
import model.UserApplyAd;
import java.sql.Date;


public interface UserApplyAdDAO {
    
    public List<UserApplyAd> find(Integer userId);

    public List<UserApplyAd> findUserAds(Integer userId);
    
    public List<UserApplyAd> findAdUsers(Integer userId);

    public void create(Integer userId, Integer adId, Date date);

    public boolean remove(Integer userId, Integer adId);   
    
}