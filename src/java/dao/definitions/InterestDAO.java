package dao.definitions;

import java.util.List;

import model.Interest;

public interface InterestDAO {

    public Interest find(Integer idinterest);

    public List<Interest> list();

    public void create(Interest interest);

    public void update(Integer id, Interest interest);
    
    public boolean remove(Integer id);   
}
