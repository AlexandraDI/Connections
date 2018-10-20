package model;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import model.FieldOfWork;
import model.Job;
import model.Location;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2018-09-30T19:23:56")
@StaticMetamodel(Company.class)
public class Company_ { 

    public static volatile SingularAttribute<Company, Integer> companyId;
    public static volatile ListAttribute<Company, FieldOfWork> fieldOfWorkList;
    public static volatile SingularAttribute<Company, Date> yearCreated;
    public static volatile SingularAttribute<Company, Location> locationId;
    public static volatile SingularAttribute<Company, String> name;
    public static volatile ListAttribute<Company, Job> jobList;

}