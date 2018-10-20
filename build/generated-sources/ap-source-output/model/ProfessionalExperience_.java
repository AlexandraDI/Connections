package model;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import model.Job;
import model.User;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2018-09-30T19:23:56")
@StaticMetamodel(ProfessionalExperience.class)
public class ProfessionalExperience_ { 

    public static volatile SingularAttribute<ProfessionalExperience, Job> jobId;
    public static volatile SingularAttribute<ProfessionalExperience, Date> dateStarted;
    public static volatile SingularAttribute<ProfessionalExperience, Date> dateEnded;
    public static volatile SingularAttribute<ProfessionalExperience, User> userId;
    public static volatile SingularAttribute<ProfessionalExperience, Integer> professionalExperienceId;

}