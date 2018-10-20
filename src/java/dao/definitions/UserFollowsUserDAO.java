package dao.definitions;

import java.util.List;
import model.Language;

import model.User;
import model.UserFollowsUser;

public interface UserFollowsUserDAO {
    
    public List<UserFollowsUser> find2(Integer userId);
    
    public List<UserFollowsUser> find(Integer userId);
    
    public List<User> findFollowers(Integer userId);
    
    public List<User> findFollowing(Integer userId);

    public boolean startFollowing(Integer follower, Integer followed);

    public boolean stopFollowing(Integer follower, Integer followed);   
    
}
