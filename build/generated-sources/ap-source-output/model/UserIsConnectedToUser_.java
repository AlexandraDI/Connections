package model;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import model.User;
import model.UserIsConnectedToUserPK;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2018-09-30T19:23:56")
@StaticMetamodel(UserIsConnectedToUser.class)
public class UserIsConnectedToUser_ { 

    public static volatile SingularAttribute<UserIsConnectedToUser, User> user1;
    public static volatile SingularAttribute<UserIsConnectedToUser, UserIsConnectedToUserPK> userIsConnectedToUserPK;
    public static volatile SingularAttribute<UserIsConnectedToUser, Date> datetimeConnectionMade;
    public static volatile SingularAttribute<UserIsConnectedToUser, User> user;

}