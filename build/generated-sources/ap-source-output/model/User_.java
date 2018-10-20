package model;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import model.Ad;
import model.Administrator;
import model.Article;
import model.Comment;
import model.Conversation;
import model.Education;
import model.Interest;
import model.Language;
import model.Location;
import model.Message;
import model.ProfessionalExperience;
import model.Reaction;
import model.UserApplyAd;
import model.UserConnectionRequestUser;
import model.UserFollowsUser;
import model.UserHasSetting;
import model.UserHasSkill;
import model.UserIsConnectedToUser;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2018-09-30T19:23:56")
@StaticMetamodel(User.class)
public class User_ { 

    public static volatile SingularAttribute<User, Date> birthday;
    public static volatile ListAttribute<User, Comment> commentList;
    public static volatile SingularAttribute<User, String> firstname;
    public static volatile ListAttribute<User, UserFollowsUser> userFollowsUserList;
    public static volatile ListAttribute<User, Conversation> conversationList1;
    public static volatile ListAttribute<User, Ad> adList;
    public static volatile ListAttribute<User, UserHasSkill> userHasSkillList;
    public static volatile ListAttribute<User, UserIsConnectedToUser> userIsConnectedToUserList1;
    public static volatile ListAttribute<User, Administrator> administratorList;
    public static volatile SingularAttribute<User, String> password;
    public static volatile SingularAttribute<User, String> facebookUrl;
    public static volatile ListAttribute<User, UserHasSetting> userHasSettingList;
    public static volatile SingularAttribute<User, String> otherInterests;
    public static volatile ListAttribute<User, Reaction> reactionList;
    public static volatile ListAttribute<User, ProfessionalExperience> professionalExperienceList;
    public static volatile SingularAttribute<User, String> surname;
    public static volatile ListAttribute<User, Language> languageList;
    public static volatile SingularAttribute<User, String> email;
    public static volatile ListAttribute<User, UserApplyAd> userApplyAdList;
    public static volatile ListAttribute<User, Interest> interestList;
    public static volatile ListAttribute<User, UserConnectionRequestUser> userConnectionRequestUserList;
    public static volatile ListAttribute<User, Education> educationList;
    public static volatile SingularAttribute<User, String> pictureUrl;
    public static volatile ListAttribute<User, Conversation> conversationList;
    public static volatile ListAttribute<User, UserIsConnectedToUser> userIsConnectedToUserList;
    public static volatile SingularAttribute<User, Integer> userId;
    public static volatile ListAttribute<User, UserFollowsUser> userFollowsUserList1;
    public static volatile SingularAttribute<User, Integer> phoneNumber;
    public static volatile ListAttribute<User, UserConnectionRequestUser> userConnectionRequestUserList1;
    public static volatile ListAttribute<User, Message> messageList;
    public static volatile SingularAttribute<User, Location> birthplace;
    public static volatile ListAttribute<User, Article> articleList;
    public static volatile SingularAttribute<User, Location> curentLocation;

}