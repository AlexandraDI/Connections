package dao.definitions;

import java.util.List;
import model.Language;


public interface LanguageDAO {

    public Language find(Integer id);

    public List<Language> list();

    public void create(Language entity);

    public void update(Integer id, Language entity);
    
    public boolean remove(Integer id);   
    
}
