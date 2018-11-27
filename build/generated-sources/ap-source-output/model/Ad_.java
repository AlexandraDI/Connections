package model;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import model.Job;
import model.User;
import model.UserApplyAd;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2018-11-27T16:46:16")
@StaticMetamodel(Ad.class)
public class Ad_ { 

    public static volatile SingularAttribute<Ad, Job> jobId;
    public static volatile SingularAttribute<Ad, Integer> adId;
    public static volatile SingularAttribute<Ad, Date> applicationDeadlineDate;
    public static volatile SingularAttribute<Ad, Date> datetimeCreated;
    public static volatile SingularAttribute<Ad, String> description;
    public static volatile SingularAttribute<Ad, String> title;
    public static volatile SingularAttribute<Ad, User> userId;
    public static volatile ListAttribute<Ad, UserApplyAd> userApplyAdList;

}