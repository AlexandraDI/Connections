package model;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import model.Comment;
import model.Reaction;
import model.User;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2018-09-30T19:23:56")
@StaticMetamodel(Article.class)
public class Article_ { 

    public static volatile ListAttribute<Article, Comment> commentList;
    public static volatile ListAttribute<Article, Reaction> reactionList;
    public static volatile SingularAttribute<Article, Integer> articleId;
    public static volatile SingularAttribute<Article, Date> datetimeCreated;
    public static volatile SingularAttribute<Article, String> title;
    public static volatile SingularAttribute<Article, User> authorId;
    public static volatile SingularAttribute<Article, String> content;

}