package model;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import model.User;
import model.UserFollowsUserPK;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2018-11-27T16:46:16")
@StaticMetamodel(UserFollowsUser.class)
public class UserFollowsUser_ { 

    public static volatile SingularAttribute<UserFollowsUser, User> user1;
    public static volatile SingularAttribute<UserFollowsUser, UserFollowsUserPK> userFollowsUserPK;
    public static volatile SingularAttribute<UserFollowsUser, Date> datetimeFollowed;
    public static volatile SingularAttribute<UserFollowsUser, User> user;

}