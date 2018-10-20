package model;

import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import model.Department;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2018-09-30T19:23:56")
@StaticMetamodel(FieldOfStudy.class)
public class FieldOfStudy_ { 

    public static volatile SingularAttribute<FieldOfStudy, Integer> fieldOfStudyId;
    public static volatile SingularAttribute<FieldOfStudy, String> name;
    public static volatile SingularAttribute<FieldOfStudy, String> description;
    public static volatile ListAttribute<FieldOfStudy, Department> departmentList;

}