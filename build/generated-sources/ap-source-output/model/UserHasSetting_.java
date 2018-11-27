package model;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import model.Setting;
import model.User;
import model.UserHasSettingPK;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2018-11-27T16:46:16")
@StaticMetamodel(UserHasSetting.class)
public class UserHasSetting_ { 

    public static volatile SingularAttribute<UserHasSetting, UserHasSettingPK> userHasSettingPK;
    public static volatile SingularAttribute<UserHasSetting, String> value;
    public static volatile SingularAttribute<UserHasSetting, User> user;
    public static volatile SingularAttribute<UserHasSetting, Setting> setting;

}