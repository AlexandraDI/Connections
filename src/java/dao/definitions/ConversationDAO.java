package dao.definitions;

import java.util.List;
import java.util.Date;

import model.User;
import model.Conversation;

public interface ConversationDAO {
    
    public Conversation findConversation(Integer userId);
    
    public List<Conversation> find2(Integer userId);
    
    public List<Conversation> find(Integer userId);    

    public List<User> findConnections(Integer userId);
    
    public List<User> findConnecting(Integer userId);

    public Conversation startConversation(Integer user1, Integer user2, Date date, String header);

    public boolean stopConversation(Integer user1,Integer user2, Date date, String header); 
    
    public void update(Integer id, Conversation changes);    
    
}
