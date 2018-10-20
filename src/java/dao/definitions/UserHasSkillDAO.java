package dao.definitions;

import java.util.List;
import model.UserHasSkill;
import model.Skill;
import java.sql.Date;

import model.User;

public interface UserHasSkillDAO {

    public List<UserHasSkill> findUserSkills(Integer userId);    

    public void create(Integer userId, Integer skillId);

    public boolean remove(Integer userId, Integer skillId);   
    
}