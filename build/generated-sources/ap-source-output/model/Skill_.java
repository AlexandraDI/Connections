package model;

import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import model.Job;
import model.ToolsAndTechnology;
import model.UserHasSkill;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2018-11-27T16:46:16")
@StaticMetamodel(Skill.class)
public class Skill_ { 

    public static volatile SingularAttribute<Skill, Integer> skillId;
    public static volatile SingularAttribute<Skill, String> description;
    public static volatile ListAttribute<Skill, Job> jobList;
    public static volatile SingularAttribute<Skill, ToolsAndTechnology> toolsAndTechnologyId;
    public static volatile ListAttribute<Skill, UserHasSkill> userHasSkillList;

}