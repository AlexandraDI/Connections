package model;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import model.Article;
import model.User;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2018-09-30T19:23:56")
@StaticMetamodel(Comment.class)
public class Comment_ { 

    public static volatile SingularAttribute<Comment, Date> datetimeCreated;
    public static volatile SingularAttribute<Comment, Article> articleId;
    public static volatile SingularAttribute<Comment, Integer> commentId;
    public static volatile SingularAttribute<Comment, User> userId;
    public static volatile SingularAttribute<Comment, String> content;

}