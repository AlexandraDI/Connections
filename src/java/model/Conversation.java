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
@Table(name = "conversation")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Conversation.findAll", query = "SELECT c FROM Conversation c")
    , @NamedQuery(name = "Conversation.findByConversationId", query = "SELECT c FROM Conversation c WHERE c.conversationId = :conversationId")
    , @NamedQuery(name = "Conversation.findByHeader", query = "SELECT c FROM Conversation c WHERE c.header = :header")
    , @NamedQuery(name = "Conversation.findByDatetimeStarted", query = "SELECT c FROM Conversation c WHERE c.datetimeStarted = :datetimeStarted")
    , @NamedQuery(name = "Conversation.findByDatetimeUpdated", query = "SELECT c FROM Conversation c WHERE c.datetimeUpdated = :datetimeUpdated")})
public class Conversation implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "conversation_id")
    private Integer conversationId;
    @Column(name = "header")
    private String header;
    @Basic(optional = false)
    @Column(name = "datetime_started")
    @Temporal(TemporalType.TIMESTAMP)
    private Date datetimeStarted;
    @Basic(optional = false)
    @Column(name = "datetime_updated")
    @Temporal(TemporalType.TIMESTAMP)
    private Date datetimeUpdated;
    @JoinColumn(name = "user1_id", referencedColumnName = "user_id")
    @ManyToOne(optional = false)
    private User user1Id;
    @JoinColumn(name = "user2_id", referencedColumnName = "user_id")
    @ManyToOne(optional = false)
    private User user2Id;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "conversationId")
    private List<Message> messageList;

    public Conversation() {
    }

    public Conversation(Integer conversationId) {
        this.conversationId = conversationId;
    }

    public Conversation(Integer conversationId, Date datetimeStarted, Date datetimeUpdated) {
        this.conversationId = conversationId;
        this.datetimeStarted = datetimeStarted;
        this.datetimeUpdated = datetimeUpdated;
    }

    public Integer getConversationId() {
        return conversationId;
    }

    public void setConversationId(Integer conversationId) {
        this.conversationId = conversationId;
    }

    public String getHeader() {
        return header;
    }

    public void setHeader(String header) {
        this.header = header;
    }

    public Date getDatetimeStarted() {
        return datetimeStarted;
    }

    public void setDatetimeStarted(Date datetimeStarted) {
        this.datetimeStarted = datetimeStarted;
    }

    public Date getDatetimeUpdated() {
        return datetimeUpdated;
    }

    public void setDatetimeUpdated(Date datetimeUpdated) {
        this.datetimeUpdated = datetimeUpdated;
    }

    public User getUser1Id() {
        return user1Id;
    }

    public void setUser1Id(User user1Id) {
        this.user1Id = user1Id;
    }

    public User getUser2Id() {
        return user2Id;
    }

    public void setUser2Id(User user2Id) {
        this.user2Id = user2Id;
    }

    @XmlTransient
    public List<Message> getMessageList() {
        return messageList;
    }

    public void setMessageList(List<Message> messageList) {
        this.messageList = messageList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (conversationId != null ? conversationId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Conversation)) {
            return false;
        }
        Conversation other = (Conversation) object;
        if ((this.conversationId == null && other.conversationId != null) || (this.conversationId != null && !this.conversationId.equals(other.conversationId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.Conversation[ conversationId=" + conversationId + " ]";
    }
    
}
