package model;

import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import model.UserHasSetting;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2018-09-30T19:23:56")
@StaticMetamodel(Setting.class)
public class Setting_ { 

    public static volatile ListAttribute<Setting, UserHasSetting> userHasSettingList;
    public static volatile SingularAttribute<Setting, String> description;
    public static volatile SingularAttribute<Setting, Integer> settingId;

}