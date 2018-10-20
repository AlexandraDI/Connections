/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author user
 */
@Entity
@Table(name = "user")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "User.findAll", query = "SELECT u FROM User u")
    , @NamedQuery(name = "User.findByUserId", query = "SELECT u FROM User u WHERE u.userId = :userId")
    , @NamedQuery(name = "User.findByFirstname", query = "SELECT u FROM User u WHERE u.firstname = :firstname")
    , @NamedQuery(name = "User.findBySurname", query = "SELECT u FROM User u WHERE u.surname = :surname")
    , @NamedQuery(name = "User.findByEmail", query = "SELECT u FROM User u WHERE u.email = :email")
    , @NamedQuery(name = "User.findByQuery", query = "SELECT u FROM User u WHERE u.firstname like :what or u.surname like :what")
    , @NamedQuery(name = "User.findByPassword", query = "SELECT u FROM User u WHERE u.password = :password")
    , @NamedQuery(name = "User.findByBirthday", query = "SELECT u FROM User u WHERE u.birthday = :birthday")
    , @NamedQuery(name = "User.findByPhoneNumber", query = "SELECT u FROM User u WHERE u.phoneNumber = :phoneNumber")
    , @NamedQuery(name = "User.findByOtherInterests", query = "SELECT u FROM User u WHERE u.otherInterests = :otherInterests")
    , @NamedQuery(name = "User.findByFacebookUrl", query = "SELECT u FROM User u WHERE u.facebookUrl = :facebookUrl")
    , @NamedQuery(name = "User.findByPictureUrl", query = "SELECT u FROM User u WHERE u.pictureUrl = :pictureUrl")})
public class User implements Serializable {

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "user")
    private List<Reaction> reactionList;

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "user_id")
    private Integer userId;
    @Basic(optional = false)
    @Column(name = "firstname")
    private String firstname;
    @Basic(optional = false)
    @Column(name = "surname")
    private String surname;
    @Basic(optional = false)
    @Column(name = "email")
    private String email;
    @Basic(optional = false)
    @Column(name = "password")
    private String password;
    @Column(name = "birthday")
    @Temporal(TemporalType.DATE)
    private Date birthday;
    @Column(name = "phone_number")
    private Integer phoneNumber;
    @Column(name = "other_interests")
    private String otherInterests;
    @Column(name = "facebook_url")
    private String facebookUrl;
    @Column(name = "picture_url")
    private String pictureUrl;
    @ManyToMany(mappedBy = "userList")
    private List<Interest> interestList;
    @ManyToMany(mappedBy = "userList")
    private List<Language> languageList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "userId")
    private List<Education> educationList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "user")
    private List<UserIsConnectedToUser> userIsConnectedToUserList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "user1")
    private List<UserIsConnectedToUser> userIsConnectedToUserList1;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "user")
    private List<UserApplyAd> userApplyAdList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "userId")
    private List<Administrator> administratorList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "user1Id")
    private List<Conversation> conversationList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "user2Id")
    private List<Conversation> conversationList1;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "user")
    private List<UserHasSetting> userHasSettingList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "userId")
    private List<Ad> adList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "user")
    private List<UserConnectionRequestUser> userConnectionRequestUserList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "user1")
    private List<UserConnectionRequestUser> userConnectionRequestUserList1;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "senderId")
    private List<Message> messageList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "authorId")
    private List<Article> articleList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "user")
    private List<UserHasSkill> userHasSkillList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "userId")
    private List<Comment> commentList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "user")
    private List<UserFollowsUser> userFollowsUserList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "user1")
    private List<UserFollowsUser> userFollowsUserList1;
    @JoinColumn(name = "birthplace", referencedColumnName = "location_id")
    @ManyToOne
    private Location birthplace;
    @JoinColumn(name = "curent_location", referencedColumnName = "location_id")
    @ManyToOne
    private Location curentLocation;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "userId")
    private List<ProfessionalExperience> professionalExperienceList;

    public User() {
    }

    public User(Integer userId) {
        this.userId = userId;
    }

    public User(Integer userId, String firstname, String surname, String email, String password) {
        this.userId = userId;
        this.firstname = firstname;
        this.surname = surname;
        this.email = email;
        this.password = password;
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

    @XmlTransient
    public List<Interest> getInterestList() {
        return interestList;
    }

    public void setInterestList(List<Interest> interestList) {
        this.interestList = interestList;
    }

    @XmlTransient
    public List<Language> getLanguageList() {
        return languageList;
    }

    public void setLanguageList(List<Language> languageList) {
        this.languageList = languageList;
    }

    @XmlTransient
    public List<Education> getEducationList() {
        return educationList;
    }

    public void setEducationList(List<Education> educationList) {
        this.educationList = educationList;
    }

    @XmlTransient
    public List<UserIsConnectedToUser> getUserIsConnectedToUserList() {
        return userIsConnectedToUserList;
    }

    public void setUserIsConnectedToUserList(List<UserIsConnectedToUser> userIsConnectedToUserList) {
        this.userIsConnectedToUserList = userIsConnectedToUserList;
    }

    @XmlTransient
    public List<UserIsConnectedToUser> getUserIsConnectedToUserList1() {
        return userIsConnectedToUserList1;
    }

    public void setUserIsConnectedToUserList1(List<UserIsConnectedToUser> userIsConnectedToUserList1) {
        this.userIsConnectedToUserList1 = userIsConnectedToUserList1;
    }

    @XmlTransient
    public List<UserApplyAd> getUserApplyAdList() {
        return userApplyAdList;
    }

    public void setUserApplyAdList(List<UserApplyAd> userApplyAdList) {
        this.userApplyAdList = userApplyAdList;
    }

    @XmlTransient
    public List<Administrator> getAdministratorList() {
        return administratorList;
    }

    public void setAdministratorList(List<Administrator> administratorList) {
        this.administratorList = administratorList;
    }

    @XmlTransient
    public List<Conversation> getConversationList() {
        return conversationList;
    }

    public void setConversationList(List<Conversation> conversationList) {
        this.conversationList = conversationList;
    }

    @XmlTransient
    public List<Conversation> getConversationList1() {
        return conversationList1;
    }

    public void setConversationList1(List<Conversation> conversationList1) {
        this.conversationList1 = conversationList1;
    }

    @XmlTransient
    public List<UserHasSetting> getUserHasSettingList() {
        return userHasSettingList;
    }

    public void setUserHasSettingList(List<UserHasSetting> userHasSettingList) {
        this.userHasSettingList = userHasSettingList;
    }

    @XmlTransient
    public List<Ad> getAdList() {
        return adList;
    }

    public void setAdList(List<Ad> adList) {
        this.adList = adList;
    }

    @XmlTransient
    public List<UserConnectionRequestUser> getUserConnectionRequestUserList() {
        return userConnectionRequestUserList;
    }

    public void setUserConnectionRequestUserList(List<UserConnectionRequestUser> userConnectionRequestUserList) {
        this.userConnectionRequestUserList = userConnectionRequestUserList;
    }

    @XmlTransient
    public List<UserConnectionRequestUser> getUserConnectionRequestUserList1() {
        return userConnectionRequestUserList1;
    }

    public void setUserConnectionRequestUserList1(List<UserConnectionRequestUser> userConnectionRequestUserList1) {
        this.userConnectionRequestUserList1 = userConnectionRequestUserList1;
    }

    @XmlTransient
    public List<Message> getMessageList() {
        return messageList;
    }

    public void setMessageList(List<Message> messageList) {
        this.messageList = messageList;
    }

    @XmlTransient
    public List<Article> getArticleList() {
        return articleList;
    }

    public void setArticleList(List<Article> articleList) {
        this.articleList = articleList;
    }

    @XmlTransient
    public List<UserHasSkill> getUserHasSkillList() {
        return userHasSkillList;
    }

    public void setUserHasSkillList(List<UserHasSkill> userHasSkillList) {
        this.userHasSkillList = userHasSkillList;
    }

    @XmlTransient
    public List<Comment> getCommentList() {
        return commentList;
    }

    public void setCommentList(List<Comment> commentList) {
        this.commentList = commentList;
    }

    @XmlTransient
    public List<UserFollowsUser> getUserFollowsUserList() {
        return userFollowsUserList;
    }

    public void setUserFollowsUserList(List<UserFollowsUser> userFollowsUserList) {
        this.userFollowsUserList = userFollowsUserList;
    }

    @XmlTransient
    public List<UserFollowsUser> getUserFollowsUserList1() {
        return userFollowsUserList1;
    }

    public void setUserFollowsUserList1(List<UserFollowsUser> userFollowsUserList1) {
        this.userFollowsUserList1 = userFollowsUserList1;
    }

    public Location getBirthplace() {
        return birthplace;
    }

    public void setBirthplace(Location birthplace) {
        this.birthplace = birthplace;
    }

    public Location getCurentLocation() {
        return curentLocation;
    }

    public void setCurentLocation(Location curentLocation) {
        this.curentLocation = curentLocation;
    }

    @XmlTransient
    public List<ProfessionalExperience> getProfessionalExperienceList() {
        return professionalExperienceList;
    }

    public void setProfessionalExperienceList(List<ProfessionalExperience> professionalExperienceList) {
        this.professionalExperienceList = professionalExperienceList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (userId != null ? userId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof User)) {
            return false;
        }
        User other = (User) object;
        if ((this.userId == null && other.userId != null) || (this.userId != null && !this.userId.equals(other.userId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.User[ userId=" + userId + " ]";
    }

    @XmlTransient
    public List<Reaction> getReactionList() {
        return reactionList;
    }

    public void setReactionList(List<Reaction> reactionList) {
        this.reactionList = reactionList;
    }
    
}
