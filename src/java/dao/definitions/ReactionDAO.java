package dao.definitions;

import java.util.List;
import model.Reaction;


public interface ReactionDAO {

    public Reaction find(Integer id);

    public List<Reaction> list();

    public void create(Reaction entity);

    public void update(Integer id, Reaction entity);
    
    public boolean remove(Integer id);   
    
}