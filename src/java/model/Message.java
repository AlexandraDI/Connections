/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author user
 */
@Entity
@Table(name = "message")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Message.findAll", query = "SELECT m FROM Message m")
    , @NamedQuery(name = "Message.findByMessageId", query = "SELECT m FROM Message m WHERE m.messageId = :messageId")
    , @NamedQuery(name = "Message.findByDatetimeCreated", query = "SELECT m FROM Message m WHERE m.datetimeCreated = :datetimeCreated")
    , @NamedQuery(name = "Message.findByContent", query = "SELECT m FROM Message m WHERE m.content = :content")
    , @NamedQuery(name = "Message.findByStatus", query = "SELECT m FROM Message m WHERE m.status = :status")})
public class Message implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "message_id")
    private Integer messageId;
    @Basic(optional = false)
    @Column(name = "datetime_created")
    @Temporal(TemporalType.TIMESTAMP)
    private Date datetimeCreated;
    @Basic(optional = false)
    @Column(name = "content")
    private String content;
    @Basic(optional = false)
    @Column(name = "status")
    private int status;
    @JoinColumn(name = "conversation_id", referencedColumnName = "conversation_id")
    @ManyToOne(optional = false)
    private Conversation conversationId;
    @JoinColumn(name = "sender_id", referencedColumnName = "user_id")
    @ManyToOne(optional = false)
    private User senderId;

    public Message() {
    }

    public Message(Integer messageId) {
        this.messageId = messageId;
    }

    public Message(Integer messageId, Date datetimeCreated, String content, int status) {
        this.messageId = messageId;
        this.datetimeCreated = datetimeCreated;
        this.content = content;
        this.status = status;
    }

    public Integer getMessageId() {
        return messageId;
    }

    public void setMessageId(Integer messageId) {
        this.messageId = messageId;
    }

    public Date getDatetimeCreated() {
        return datetimeCreated;
    }

    public void setDatetimeCreated(Date datetimeCreated) {
        this.datetimeCreated = datetimeCreated;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public Conversation getConversationId() {
        return conversationId;
    }

    public void setConversationId(Conversation conversationId) {
        this.conversationId = conversationId;
    }

    public User getSenderId() {
        return senderId;
    }

    public void setSenderId(User senderId) {
        this.senderId = senderId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (messageId != null ? messageId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Message)) {
            return false;
        }
        Message other = (Message) object;
        if ((this.messageId == null && other.messageId != null) || (this.messageId != null && !this.messageId.equals(other.messageId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.Message[ messageId=" + messageId + " ]";
    }
    
}
