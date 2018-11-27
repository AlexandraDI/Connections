package dao.definitions;

import java.util.List;


import model.User;

public interface UserDAO {

    public User find(String email);
    
    public User find(Integer id);

    public List<User> list();

    public void create(User user);

    public void update(Integer id, User user);
    
    public boolean remove(Integer id);   
    
    public List<User> search(String what);
    
    public double[] buildVector(Integer user_pk, List<Integer> all_language_ids, List<Integer> all_skill_ids);
}
