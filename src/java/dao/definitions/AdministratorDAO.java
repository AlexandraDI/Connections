package dao.definitions;

import java.util.List;

import model.Administrator;

public interface AdministratorDAO {

    public Administrator find(Integer id);
    
    public Administrator findAdministrator(Integer id);

    public List<Administrator> list();

    public void create(Administrator administrator);

    public void update(Integer id, Administrator administrator);
    
    public boolean remove(Integer id);   
}
