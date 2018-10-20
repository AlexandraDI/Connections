package dao.definitions;

import java.util.List;
import model.Language;

import model.User;

public interface UserHasLanguageDAO {

    public List<Language> findUserLanguages(Integer userId);
    
    public List<User> findLanguageUsers(Integer userId);

    public void create(Integer userId, Integer languageId);

    public boolean remove(Integer userId, Integer languageId);   
    
}
