package model;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import model.User;
import model.UserConnectionRequestUserPK;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2018-11-27T16:46:16")
@StaticMetamodel(UserConnectionRequestUser.class)
public class UserConnectionRequestUser_ { 

    public static volatile SingularAttribute<UserConnectionRequestUser, User> user1;
    public static volatile SingularAttribute<UserConnectionRequestUser, Date> dateOfRequest;
    public static volatile SingularAttribute<UserConnectionRequestUser, User> user;
    public static volatile SingularAttribute<UserConnectionRequestUser, UserConnectionRequestUserPK> userConnectionRequestUserPK;
    public static volatile SingularAttribute<UserConnectionRequestUser, Integer> status;

}