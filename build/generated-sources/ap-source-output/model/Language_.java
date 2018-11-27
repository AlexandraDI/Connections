package model;

import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import model.Job;
import model.User;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2018-11-27T16:46:16")
@StaticMetamodel(Language.class)
public class Language_ { 

    public static volatile ListAttribute<Language, User> userList;
    public static volatile SingularAttribute<Language, Integer> languageId;
    public static volatile SingularAttribute<Language, String> language;
    public static volatile ListAttribute<Language, Job> jobList;

}