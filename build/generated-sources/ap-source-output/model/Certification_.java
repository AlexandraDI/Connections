package model;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import model.Department;
import model.School;
import model.UserHasSkill;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2018-11-27T16:46:16")
@StaticMetamodel(Certification.class)
public class Certification_ { 

    public static volatile SingularAttribute<Certification, Date> dateOfExpiration;
    public static volatile SingularAttribute<Certification, Integer> certificationId;
    public static volatile SingularAttribute<Certification, Department> departmentId;
    public static volatile SingularAttribute<Certification, School> schoolId;
    public static volatile SingularAttribute<Certification, String> description;
    public static volatile ListAttribute<Certification, UserHasSkill> userHasSkillList;
    public static volatile SingularAttribute<Certification, Date> dateEstablished;

}