package dao.definitions;

import java.util.List;

import model.FieldOfWork;

public interface FieldOfWorkDAO {

    public FieldOfWork find(Integer id);

    public List<FieldOfWork> list();

    public void create(FieldOfWork field);

    public void update(Integer id, FieldOfWork field);
    
    public boolean remove(Integer id);   
}
