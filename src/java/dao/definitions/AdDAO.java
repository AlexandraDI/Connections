package dao.definitions;

import java.util.List;
import model.Ad;


public interface AdDAO {

    public Ad find(Integer id);

    public List<Ad> list();

    public void create(Ad entity);

    public void update(Integer id, Ad entity);
    
    public boolean remove(Integer id);   
    
    public double[] buildVector(Integer ad_pk, List<Integer> all_language_ids, List<Integer> all_skill_ids) ;
}
