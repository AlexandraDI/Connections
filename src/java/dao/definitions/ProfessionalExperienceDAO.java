package dao.definitions;

import java.util.List;
import model.ProfessionalExperience;


public interface ProfessionalExperienceDAO {

    public ProfessionalExperience find(Integer id);

    public List<ProfessionalExperience> list();

    public void create(ProfessionalExperience entity);

    public void update(Integer id, ProfessionalExperience entity);
    
    public boolean remove(Integer id);   
    
}