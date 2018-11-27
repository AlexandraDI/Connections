package model;

import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import model.User;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2018-11-27T16:46:16")
@StaticMetamodel(Interest.class)
public class Interest_ { 

    public static volatile ListAttribute<Interest, User> userList;
    public static volatile SingularAttribute<Interest, Integer> interestId;
    public static volatile SingularAttribute<Interest, String> name;
    public static volatile SingularAttribute<Interest, String> description;

}