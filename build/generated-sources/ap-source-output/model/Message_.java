package model;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import model.Conversation;
import model.User;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2018-09-30T19:23:56")
@StaticMetamodel(Message.class)
public class Message_ { 

    public static volatile SingularAttribute<Message, User> senderId;
    public static volatile SingularAttribute<Message, Conversation> conversationId;
    public static volatile SingularAttribute<Message, Date> datetimeCreated;
    public static volatile SingularAttribute<Message, Integer> messageId;
    public static volatile SingularAttribute<Message, String> content;
    public static volatile SingularAttribute<Message, Integer> status;

}