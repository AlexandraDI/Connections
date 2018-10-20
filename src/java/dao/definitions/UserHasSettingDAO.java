package dao.definitions;

import java.util.List;
import model.UserHasSetting;
import model.Setting;

import model.User;

public interface UserHasSettingDAO {

    public List<UserHasSetting> findUserSettings(Integer userId);
    
    public List<User> findSettingUsers(Integer userId);

    public void create(Integer userId, Integer settingId, String value);
    
    public void update(Integer id, Integer id2, UserHasSetting changes);

    public boolean remove(Integer userId, Integer settingId);   
    
}
