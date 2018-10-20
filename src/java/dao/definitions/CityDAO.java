package dao.definitions;

import java.util.List;

import model.City;

public interface CityDAO {

    public City find(String email);
    
    public City find(Integer id);

    public List<City> list();

    public void create(City city);

    public void update(Integer id, City city);
    
    public boolean remove(Integer id);   
    
    public List<City> search(String what);
}
