package dao.definitions;

import java.util.List;
import model.FieldOfStudy;


public interface FieldOfStudyDAO {

    public FieldOfStudy find(Integer id);

    public List<FieldOfStudy> list();

    public void create(FieldOfStudy entity);

    public void update(Integer id, FieldOfStudy entity);
    
    public boolean remove(Integer id);   
    
}
