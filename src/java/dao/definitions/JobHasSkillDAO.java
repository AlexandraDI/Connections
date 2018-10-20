package dao.definitions;

import java.util.List;
import model.Job;

import model.Skill;

public interface JobHasSkillDAO {

    public List<Skill> findJobSkills(Integer userId);
    
    public List<Job> findSkillJobs(Integer userId);

    public void create(Integer userId, Integer skillId);

    public boolean remove(Integer userId, Integer skillId);   
    
}
