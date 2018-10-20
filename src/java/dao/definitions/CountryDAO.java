package dao.definitions;

import java.util.List;

import model.Country;

public interface CountryDAO {

    public Country find(String email);
    
    public Country find(Integer id);

    public List<Country> list();

    public void create(Country country);

    public void update(Integer id, Country country);
    
    public boolean remove(Integer id);   
    
    public List<Country> search(String what);
}
