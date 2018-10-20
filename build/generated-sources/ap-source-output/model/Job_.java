package model;

import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import model.Ad;
import model.Company;
import model.FieldOfWork;
import model.Language;
import model.ProfessionalExperience;
import model.Skill;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2018-09-30T19:23:56")
@StaticMetamodel(Job.class)
public class Job_ { 

    public static volatile SingularAttribute<Job, Integer> jobId;
    public static volatile ListAttribute<Job, Skill> skillList;
    public static volatile ListAttribute<Job, ProfessionalExperience> professionalExperienceList;
    public static volatile ListAttribute<Job, Company> companyList;
    public static volatile SingularAttribute<Job, String> name;
    public static volatile SingularAttribute<Job, String> description;
    public static volatile ListAttribute<Job, Ad> adList;
    public static volatile ListAttribute<Job, Language> languageList;
    public static volatile SingularAttribute<Job, FieldOfWork> fieldOfWorkId;

}