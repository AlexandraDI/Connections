package dao.definitions;

import java.util.List;
import java.util.Date;
import model.Comment;


public interface CommentDAO {

    public Comment find(Integer id);

    public List<Comment> list();

    public void create(Comment entity);
    
    public boolean startComment(Integer userId, Integer articleId, Date date, String content);

    public void update(Integer id, Comment entity);
    
    public boolean remove(Integer id);   
    
}
