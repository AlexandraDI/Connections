package dao.definitions;

import java.util.List;
import model.Skill;


public interface SkillDAO {

    public Skill find(Integer id);

    public List<Skill> list();

    public void create(Skill entity);

    public void update(Integer id, Skill entity);
    
    public boolean remove(Integer id);   
    
}
