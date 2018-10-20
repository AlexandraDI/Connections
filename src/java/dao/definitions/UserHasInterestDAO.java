package dao.definitions;

import java.util.List;
import model.Interest;

import model.User;

public interface UserHasInterestDAO {

    public List<Interest> findUserInterests(Integer userId);
    
    public List<User> findInterestUsers(Integer userId);

    public void create(Integer userId, Integer interestId);

    public boolean remove(Integer userId, Integer interestId);   
    
}
