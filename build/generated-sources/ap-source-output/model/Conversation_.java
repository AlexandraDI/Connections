package model;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import model.Message;
import model.User;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2018-09-30T19:23:56")
@StaticMetamodel(Conversation.class)
public class Conversation_ { 

    public static volatile SingularAttribute<Conversation, Date> datetimeStarted;
    public static volatile ListAttribute<Conversation, Message> messageList;
    public static volatile SingularAttribute<Conversation, Integer> conversationId;
    public static volatile SingularAttribute<Conversation, User> user2Id;
    public static volatile SingularAttribute<Conversation, String> header;
    public static volatile SingularAttribute<Conversation, User> user1Id;
    public static volatile SingularAttribute<Conversation, Date> datetimeUpdated;

}