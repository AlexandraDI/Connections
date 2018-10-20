package dao.definitions;

import java.util.List;
import model.Language;

import model.Job;

public interface JobDAO {

    public Job find(Integer id);

    public List<Job> list();

    public void create(Job entity);

    public void update(Integer id, Job entity);
    
    public boolean remove(Integer id);   
    
}
