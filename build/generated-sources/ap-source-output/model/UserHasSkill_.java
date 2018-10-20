package model;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import model.Certification;
import model.Skill;
import model.User;
import model.UserHasSkillPK;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2018-09-30T19:23:56")
@StaticMetamodel(UserHasSkill.class)
public class UserHasSkill_ { 

    public static volatile SingularAttribute<UserHasSkill, Certification> certificationId;
    public static volatile SingularAttribute<UserHasSkill, UserHasSkillPK> userHasSkillPK;
    public static volatile SingularAttribute<UserHasSkill, Skill> skill;
    public static volatile SingularAttribute<UserHasSkill, User> user;

}