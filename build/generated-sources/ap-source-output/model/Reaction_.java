package model;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import model.Article;
import model.ReactionPK;
import model.User;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2018-09-30T19:23:56")
@StaticMetamodel(Reaction.class)
public class Reaction_ { 

    public static volatile SingularAttribute<Reaction, Integer> reaction;
    public static volatile SingularAttribute<Reaction, ReactionPK> reactionPK;
    public static volatile SingularAttribute<Reaction, User> user;
    public static volatile SingularAttribute<Reaction, Article> article;

}