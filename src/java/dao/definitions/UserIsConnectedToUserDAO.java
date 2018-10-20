package dao.definitions;

import java.util.List;

import model.User;
import model.UserIsConnectedToUser;

public interface UserIsConnectedToUserDAO {
    
    
    public List<UserIsConnectedToUser> find2(Integer userId);
    
    public List<UserIsConnectedToUser> find(Integer userId);    

    public List<User> findConnections(Integer userId);
    
    public List<User> findConnecting(Integer userId);

    public boolean startConnecting(Integer follower, Integer followed);

    public boolean stopConnecting(Integer follower, Integer followed);   
    
}
