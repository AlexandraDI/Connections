package dao.definitions;

import java.util.List;
import model.Company;

import model.User;

public interface CompanyDAO {

    public Company find(Integer id);

    public List<Company> list();

    public void create(Company entity);

    public void update(Integer id, Company entity);
    
    public boolean remove(Integer id);   
    
}

