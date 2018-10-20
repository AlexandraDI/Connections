/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelxml;

import dao.ArticleDAOImpl;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;
import model.Ad;
import model.Article;
import model.City;
import model.Comment;
import model.Country;
import model.Department;
import model.Education;
import model.Job;
import model.Language;
import model.Location;
import model.ProfessionalExperience;
import model.Reaction;
import model.School;
import model.Skill;
import model.ToolsAndTechnology;
import model.UserApplyAd;
import model.UserHasSkill;
import model.UserIsConnectedToUser;

@XmlRootElement
public class Catalog {

    private Set<UserXML> users = new HashSet<>();

    @XmlElementWrapper(name = "users")
    @XmlElement(name = "user")
    public Set<UserXML> getUsers() {
        return users;
    }

    public void setUsers(Set<UserXML> users) {
        this.users = users;
    }

    // -----------------------------------------------------------
    private ArticleXML toXML(Article a) {
        ArticleXML xmlobject = new ArticleXML();
        xmlobject.setArticleId(a.getArticleId());
        xmlobject.setTitle(a.getTitle());
        xmlobject.setContent(a.getContent());
        xmlobject.setDatetime_created(a.getDatetimeCreated());
        return xmlobject;
    }

    private AdXML toXML(Ad ad) {
        AdXML xmlobject = new AdXML();

        xmlobject.setAdId(ad.getAdId());
        xmlobject.setApplicationDeadlineDate(ad.getApplicationDeadlineDate());
        xmlobject.setDatetimeCreated(ad.getDatetimeCreated());
        xmlobject.setDescription(ad.getDescription());
        xmlobject.setTitle(ad.getTitle());

        xmlobject.setJobId(toXML(ad.getJobId()));

        for (UserApplyAd aaa : ad.getUserApplyAdList()) {
            xmlobject.getUserApplyAdList().add(toXML(aaa));
        }

        return xmlobject;
    }

    private UserXML toXML(model.User u) {
        UserXML xmlobject = new UserXML();
        xmlobject.setFirstname(u.getFirstname());
        xmlobject.setSurname(u.getSurname());
        xmlobject.setBirthday(u.getBirthday());
        xmlobject.setEmail(u.getEmail());
        xmlobject.setFacebookUrl(u.getFacebookUrl());
        xmlobject.setPhoneNumber(u.getPhoneNumber());
        xmlobject.setPictureUrl(u.getPictureUrl());
        xmlobject.setUserId(u.getUserId());

        for (Article a : u.getArticleList()) {
            xmlobject.getArticleList().add(toXML(a));
        }

        for (Ad a : u.getAdList()) {
            xmlobject.getAdList().add(toXML(a));
        }

        for (ProfessionalExperience a : u.getProfessionalExperienceList()) {
            xmlobject.getExperienceList().add(toXML(a));
        }

        for (Language l : u.getLanguageList()) {
            xmlobject.getLanguageList().add(toXML(l));
        }

        for (UserHasSkill l : u.getUserHasSkillList()) {
            Skill s = l.getSkill();

            xmlobject.getSkillList().add(toXML(s));
        }

        for (UserIsConnectedToUser x : u.getUserIsConnectedToUserList()) {
            xmlobject.getConnected().add(x.getUser1().getUserId());
        }

        for (UserIsConnectedToUser x : u.getUserIsConnectedToUserList1()) {
            xmlobject.getConnected().add(x.getUser().getUserId());
        }

        for (Comment c : u.getCommentList()) {
            xmlobject.getCommentList().add(toXML(c));
        }

        for (Reaction r : u.getReactionList()) {
            xmlobject.getReactionList().add(toXML(r));
        }

        for ( Education ed : u.getEducationList()){
            xmlobject.getEducationList().add(toXML(ed));
        }
            
        return xmlobject;
    }

    public void add(model.User u) {
        this.users.add(toXML(u));
    }

    private JobXML toXML(Job job) {
        JobXML xmlobject = new JobXML();

        xmlobject.setDescription(job.getDescription());
        xmlobject.setJobId(job.getJobId());
        xmlobject.setName(job.getName());

        for (Skill s : job.getSkillList()) {
            xmlobject.getSkillList().add(toXML(s));
        }

        for (Language l : job.getLanguageList()) {
            xmlobject.getLanguageList().add(toXML(l));
        }

        return xmlobject;
    }

    private SkillXML toXML(Skill s) {
        SkillXML xmlo = new SkillXML();

        xmlo.setDescription(s.getDescription());
        xmlo.setSkillId(s.getSkillId());
        xmlo.setToolsAndTechnologyId(toXML(s.getToolsAndTechnologyId()));

        return xmlo;

    }

    private LanguageXML toXML(Language l) {
        LanguageXML xmlo = new LanguageXML();

        xmlo.setLanguage(l.getLanguage());
        xmlo.setLanguageId(l.getLanguageId());

        return xmlo;
    }

    private ToolsAndTechnologyXML toXML(ToolsAndTechnology toolsAndTechnologyId) {
        ToolsAndTechnologyXML xmlo = new ToolsAndTechnologyXML();

        xmlo.setDescription(toolsAndTechnologyId.getDescription());
        xmlo.setToolsAndTechnologyId(toolsAndTechnologyId.getToolsAndTechnologyId());

        return xmlo;
    }

    private UserApplyAdXML toXML(UserApplyAd aaa) {
        UserApplyAdXML xmlo = new UserApplyAdXML();

        xmlo.setDateOfApplication(aaa.getDateOfApplication());
        xmlo.setUserId(aaa.getUser().getUserId());

        return xmlo;
    }

    private ProfessionalExperienceXML toXML(ProfessionalExperience a) {
        ProfessionalExperienceXML xmlo = new ProfessionalExperienceXML();

        xmlo.setDateEnded(a.getDateEnded());
        xmlo.setDateStarted(a.getDateStarted());
        xmlo.setJobId(toXML(a.getJobId()));
        xmlo.setProfessionalExperienceId(a.getProfessionalExperienceId());

        return xmlo;
    }

    private CommentXML toXML(Comment c) {
        CommentXML xmlo = new CommentXML();

        xmlo.setArticleId(c.getArticleId().getArticleId());
        xmlo.setCommentId(c.getCommentId());
        xmlo.setContent(c.getContent());
        xmlo.setDatetimeCreated(c.getDatetimeCreated());

        return xmlo;
    }

    private ReactionXML toXML(Reaction r) {
        ReactionXML xmlo = new ReactionXML();
        xmlo.setArticle(r.getArticle().getArticleId());
        xmlo.setReaction(r.getReaction());

        return xmlo;
    }

    private CountryXML toXML(Country co) {
        CountryXML xmlo = new CountryXML();

        xmlo.setCountryId(co.getCountryId());
        xmlo.setName(co.getName());

        return xmlo;
    }

    private CityXML toXML(City ci) {
        CityXML xmlo = new CityXML();

        xmlo.setCityId(ci.getCityId());
        xmlo.setName(ci.getName());

        return xmlo;
    }

    private LocationXML toXML(Location lo) {
        LocationXML xmlo = new LocationXML();

        xmlo.setLocationId(lo.getLocationId());
        xmlo.setNumber(lo.getNumber());
        xmlo.setStreet(lo.getStreet());
        xmlo.setPostcode(lo.getPostcode());
        xmlo.setOtherDetails(lo.getOtherDetails());

        return xmlo;
    }

    private SchoolXML toXML(School sc) {
        SchoolXML xmlo = new SchoolXML();

        xmlo.setSchoolId(sc.getSchoolId());
        xmlo.setName(sc.getName());
        xmlo.setLevel(sc.getLevel());

        return xmlo;
    }

    private DepartmentXML toXML(Department de) {
        DepartmentXML xmlo = new DepartmentXML();

        xmlo.setDepartmentId(de.getDepartmentId());
        xmlo.setName(de.getName());

        return xmlo;
    }

    private EducationXML toXML(Education ed) {
        EducationXML xmlo = new EducationXML();
        
        xmlo.setEducationId(ed.getEducationId());
        xmlo.setDegree(ed.getDegree());
        xmlo.setEntryYear(ed.getEntryYear());
        xmlo.setEndYear(ed.getEndYear());
        xmlo.setHonour(ed.getHonour());
        
        return xmlo;
    }
}
