package model;

import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import model.City;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2018-09-30T19:23:56")
@StaticMetamodel(Country.class)
public class Country_ { 

    public static volatile SingularAttribute<Country, String> name;
    public static volatile ListAttribute<Country, City> cityList;
    public static volatile SingularAttribute<Country, Integer> countryId;

}