package dao.definitions;

import java.util.List;
import model.Certification;


public interface CertificationDAO {

    public Certification find(Integer id);

    public List<Certification> list();

    public void create(Certification entity);

    public void update(Integer id, Certification entity);
    
    public boolean remove(Integer id);   
    
}
