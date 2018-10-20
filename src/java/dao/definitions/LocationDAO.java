package dao.definitions;

import java.util.List;

import model.Location;

public interface LocationDAO {

    public Location find(String email);
    
    public Location find(Integer id);

    public List<Location> list();

    public void create(Location location);

    public void update(Integer id, Location location);
    
    public boolean remove(Integer id);   
    
    public List<Location> search(String what);
}
