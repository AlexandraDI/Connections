package model;

import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import model.Company;
import model.Job;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2018-09-30T19:23:56")
@StaticMetamodel(FieldOfWork.class)
public class FieldOfWork_ { 

    public static volatile ListAttribute<FieldOfWork, Company> companyList;
    public static volatile SingularAttribute<FieldOfWork, String> name;
    public static volatile SingularAttribute<FieldOfWork, String> description;
    public static volatile ListAttribute<FieldOfWork, Job> jobList;
    public static volatile SingularAttribute<FieldOfWork, Integer> fieldOfWorkId;

}