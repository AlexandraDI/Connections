package dao.definitions;

import java.util.List;
import model.Education;


public interface EducationDAO {

    public Education find(Integer id);

    public List<Education> list();

    public void create(Education entity);

    public void update(Integer id, Education entity);
    
    public boolean remove(Integer id);   
    
}
