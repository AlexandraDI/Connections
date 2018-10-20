package dao.definitions;

import java.util.List;
import model.School;


public interface SchoolDAO {

    public School find(Integer id);

    public List<School> list();

    public void create(School entity);

    public void update(Integer id, School entity);
    
    public boolean remove(Integer id);   
    
}
