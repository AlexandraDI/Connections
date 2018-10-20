package dao.definitions;

import java.util.List;
import model.ToolsAndTechnology;


public interface ToolsAndTechnologyDAO {

    public ToolsAndTechnology find(Integer id);

    public List<ToolsAndTechnology> list();

    public void create(ToolsAndTechnology entity);

    public void update(Integer id, ToolsAndTechnology entity);
    
    public boolean remove(Integer id);   
    
}
