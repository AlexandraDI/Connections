package model;

import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import model.Certification;
import model.Education;
import model.FieldOfStudy;
import model.School;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2018-09-30T19:23:56")
@StaticMetamodel(Department.class)
public class Department_ { 

    public static volatile ListAttribute<Department, FieldOfStudy> fieldOfStudyList;
    public static volatile ListAttribute<Department, Certification> certificationList;
    public static volatile ListAttribute<Department, Education> educationList;
    public static volatile SingularAttribute<Department, Integer> departmentId;
    public static volatile SingularAttribute<Department, School> schoolId;
    public static volatile SingularAttribute<Department, String> name;

}