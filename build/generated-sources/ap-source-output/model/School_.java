package model;

import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import model.Certification;
import model.Department;
import model.Location;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2018-11-27T16:46:16")
@StaticMetamodel(School.class)
public class School_ { 

    public static volatile ListAttribute<School, Certification> certificationList;
    public static volatile SingularAttribute<School, String> level;
    public static volatile SingularAttribute<School, Location> locationId;
    public static volatile SingularAttribute<School, Integer> schoolId;
    public static volatile SingularAttribute<School, String> name;
    public static volatile ListAttribute<School, Department> departmentList;

}