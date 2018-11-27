package dao.definitions;

import java.util.List;
import model.UserHasSkill;

public interface UserHasSkillDAO {

    public List<UserHasSkill> findUserSkills(Integer userId);    

    public void create(Integer userId, Integer skillId);

    public boolean remove(Integer userId, Integer skillId);   
    
}