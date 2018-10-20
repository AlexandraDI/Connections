package dao.definitions;

import java.util.List;

import model.Setting;

public interface SettingDAO {

    public Setting find(Integer idsetting);

    public List<Setting> list();

    public void create(Setting setting);

    public void update(Integer id, Setting setting);
  
    public boolean remove(Integer id);   
}
