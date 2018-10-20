/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelxml;

import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;

public class UserXML implements Serializable {

    private Integer userId;
    private String firstname;
    private String surname;
    private String email;
    private String password;
    private Date birthday;
    private Integer phoneNumber;
    private String otherInterests;
    private String facebookUrl;
    private String pictureUrl;

//    private List<Interest> interestList;
    private Set<LanguageXML> languageList = new HashSet<>();
    private Set<SkillXML> skillList = new HashSet<>();
    private Set<ReactionXML> reactionList = new HashSet<>();
//    private List<UserIsConnectedToUser> userIsConnectedToUserList;
    private Set<AdXML> adList = new HashSet<>();
//    private List<UserConnectionRequestUser> userConnectionRequestUserList;
//    private List<UserConnectionRequestUser> userConnectionRequestUserList1;
//    private List<Message> messageList;
    private Set<ArticleXML> articleList = new HashSet<>();
    private Set<ProfessionalExperienceXML> experienceList = new HashSet<>();
    private Set<CommentXML> commentList = new HashSet<>();
    private Set<Integer> connected = new HashSet<>();
//    private List<UserFollowsUser> userFollowsUserList1;
    private Set<CountryXML> countryList = new HashSet<>();
    private Set<CityXML> cityList = new HashSet<>();
    private Set<LocationXML> locationList = new HashSet<>();
    private Set<SchoolXML> schoolList = new HashSet<>();
    private Set<DepartmentXML> departmentList = new HashSet<>();
    private Set<EducationXML> educationList = new HashSet<>();

    public UserXML() {
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public Integer getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(Integer phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getOtherInterests() {
        return otherInterests;
    }

    public void setOtherInterests(String otherInterests) {
        this.otherInterests = otherInterests;
    }

    public String getFacebookUrl() {
        return facebookUrl;
    }

    public void setFacebookUrl(String facebookUrl) {
        this.facebookUrl = facebookUrl;
    }

    public String getPictureUrl() {
        return pictureUrl;
    }

    public void setPictureUrl(String pictureUrl) {
        this.pictureUrl = pictureUrl;
    }

    @XmlElementWrapper(name = "articles")
    @XmlElement(name = "article")
    public Set<ArticleXML> getArticleList() {
        return articleList;
    }

    public void setArticleList(Set<ArticleXML> articleList) {
        this.articleList = articleList;
    }

    @XmlElementWrapper(name = "ads")
    @XmlElement(name = "ad")
    public Set<AdXML> getAdList() {
        return adList;
    }

    public void setAdList(Set<AdXML> adList) {
        this.adList = adList;
    }

    @XmlElementWrapper(name = "professionalexperiences")
    @XmlElement(name = "professionalexperience")
    public Set<ProfessionalExperienceXML> getExperienceList() {
        return experienceList;
    }

    public void setExperienceList(Set<ProfessionalExperienceXML> experienceList) {
        this.experienceList = experienceList;
    }

    @XmlElementWrapper(name = "languages")
    @XmlElement(name = "language")
    public Set<LanguageXML> getLanguageList() {
        return languageList;
    }

    public void setLanguageList(Set<LanguageXML> languageList) {
        this.languageList = languageList;
    }

    @XmlElementWrapper(name = "skills")
    @XmlElement(name = "skill")
    public Set<SkillXML> getSkillList() {
        return skillList;
    }

    public void setSkillList(Set<SkillXML> skillList) {
        this.skillList = skillList;
    }

    public Set<Integer> getConnected() {
        return connected;
    }

    public void setConnected(Set<Integer> connected) {
        this.connected = connected;
    }

    @XmlElementWrapper(name = "comments")
    @XmlElement(name = "comment")
    public Set<CommentXML> getCommentList() {
        return commentList;
    }

    public void setCommentList(Set<CommentXML> commentList) {
        this.commentList = commentList;
    }

    @XmlElementWrapper(name = "reactions")
    @XmlElement(name = "reaction")
    public Set<ReactionXML> getReactionList() {
        return reactionList;
    }

    public void setReactionList(Set<ReactionXML> reactionList) {
        this.reactionList = reactionList;
    }
//////////////////////////////////////////////////////////////////////////////////////////////

    
    @XmlElementWrapper(name = "countries")
    @XmlElement(name = "country")
    public Set<CountryXML> getCountryList() {
        return countryList;
    }

    public void setCountryList(Set<CountryXML> countryList) {
        this.countryList = countryList;
    }

    
    @XmlElementWrapper(name = "cities")
    @XmlElement(name = "city")
    public Set<CityXML> getCityList() {
        return cityList;
    }

    public void setCityList(Set<CityXML> cityList) {
        this.cityList = cityList;
    }

    
    @XmlElementWrapper(name = "locations")
    @XmlElement(name = "location")
    public Set<LocationXML> getLocationList() {
        return locationList;
    }

    public void setLocationList(Set<LocationXML> locationList) {
        this.locationList = locationList;
    }

    @XmlElementWrapper(name = "schools")
    @XmlElement(name = "school")
    public Set<SchoolXML> getSchoolList() {
        return schoolList;
    }

    public void setSchoolList(Set<SchoolXML> schoolList) {
        this.schoolList = schoolList;
    }

    @XmlElementWrapper(name = "departments")
    @XmlElement(name = "department")
    public Set<DepartmentXML> getDepartmentList() {
        return departmentList;
    }

    public void setDepartmentList(Set<DepartmentXML> departmentList) {
        this.departmentList = departmentList;
    }

    @XmlElementWrapper(name = "educations")
    @XmlElement(name = "education")
    public Set<EducationXML> getEducationList() {
        return educationList;
    }

    public void setEducationList(Set<EducationXML> educationList) {
        this.educationList = educationList;
    }
}
