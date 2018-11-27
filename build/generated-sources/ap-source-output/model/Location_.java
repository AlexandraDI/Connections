package model;

import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import model.City;
import model.Company;
import model.School;
import model.User;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2018-11-27T16:46:16")
@StaticMetamodel(Location.class)
public class Location_ { 

    public static volatile ListAttribute<Location, School> schoolList;
    public static volatile SingularAttribute<Location, Integer> number;
    public static volatile ListAttribute<Location, User> userList;
    public static volatile ListAttribute<Location, User> userList1;
    public static volatile ListAttribute<Location, Company> companyList;
    public static volatile SingularAttribute<Location, Integer> locationId;
    public static volatile SingularAttribute<Location, String> street;
    public static volatile SingularAttribute<Location, String> otherDetails;
    public static volatile SingularAttribute<Location, Integer> postcode;
    public static volatile SingularAttribute<Location, City> cityId;

}