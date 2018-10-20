package dao.definitions;

import java.util.List;
import model.UserApplyAd;
import model.Ad;
import java.sql.Date;

import model.User;
import model.UserFollowsUser;

public interface UserApplyAdDAO {
    
    public List<UserApplyAd> find(Integer userId);

    public List<UserApplyAd> findUserAds(Integer userId);
    
    public List<UserApplyAd> findAdUsers(Integer userId);

    public void create(Integer userId, Integer adId, Date date);

    public boolean remove(Integer userId, Integer adId);   
    
}