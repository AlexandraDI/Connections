package model;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import model.Ad;
import model.User;
import model.UserApplyAdPK;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2018-09-30T19:23:56")
@StaticMetamodel(UserApplyAd.class)
public class UserApplyAd_ { 

    public static volatile SingularAttribute<UserApplyAd, Ad> ad;
    public static volatile SingularAttribute<UserApplyAd, Date> dateOfApplication;
    public static volatile SingularAttribute<UserApplyAd, User> user;
    public static volatile SingularAttribute<UserApplyAd, UserApplyAdPK> userApplyAdPK;

}