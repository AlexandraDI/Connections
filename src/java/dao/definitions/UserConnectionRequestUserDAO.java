package dao.definitions;

import java.util.List;

import model.User;
import model.UserConnectionRequestUser;


public interface UserConnectionRequestUserDAO {
    
    public List<UserConnectionRequestUser> find2(Integer userId);
    
    public List<UserConnectionRequestUser> find(Integer userId);     

    public List<User> findRequests(Integer userId);
    
    public List<User> findRequested(Integer userId);

    public boolean startRequest(Integer follower, Integer followed);

    public boolean stopRequest(Integer follower, Integer followed);   
}
