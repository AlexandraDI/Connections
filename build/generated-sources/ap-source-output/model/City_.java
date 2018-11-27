package model;

import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import model.Country;
import model.Location;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2018-11-27T16:46:16")
@StaticMetamodel(City.class)
public class City_ { 

    public static volatile ListAttribute<City, Location> locationList;
    public static volatile SingularAttribute<City, String> name;
    public static volatile SingularAttribute<City, Integer> cityId;
    public static volatile SingularAttribute<City, Country> countryId;

}