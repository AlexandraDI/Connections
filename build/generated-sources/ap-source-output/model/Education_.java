package model;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import model.Department;
import model.User;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2018-09-30T19:23:56")
@StaticMetamodel(Education.class)
public class Education_ { 

    public static volatile SingularAttribute<Education, Date> entryYear;
    public static volatile SingularAttribute<Education, String> honour;
    public static volatile SingularAttribute<Education, Integer> educationId;
    public static volatile SingularAttribute<Education, Department> departmentId;
    public static volatile SingularAttribute<Education, String> degree;
    public static volatile SingularAttribute<Education, Date> endYear;
    public static volatile SingularAttribute<Education, User> userId;

}