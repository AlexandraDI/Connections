package dao.definitions;

import java.util.List;
import model.Department;


public interface DepartmentDAO {

    public Department find(Integer id);

    public List<Department> list();

    public void create(Department entity);

    public void update(Integer id, Department entity);
    
    public boolean remove(Integer id);   
    
}
