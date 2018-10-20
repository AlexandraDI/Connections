package dao.definitions;

import java.util.List;

import model.Article;

public interface ArticleDAO {

    public Article find(Integer id);

    public List<Article> list();

    public void create(Article article);

    public void update(Integer id, Article article);
    
    public boolean remove(Integer id);   
}
