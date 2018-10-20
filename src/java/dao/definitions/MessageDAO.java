package dao.definitions;

import java.util.List;
import model.Message;


public interface MessageDAO {

    public Message find(Integer id);

    public List<Message> list();

    public void create(Message entity);

    public void update(Integer id, Message entity);
    
    public boolean remove(Integer id);   
    
}
