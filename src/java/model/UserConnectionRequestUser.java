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
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
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
@Table(name = "user_connection_request_user")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "UserConnectionRequestUser.findAll", query = "SELECT u FROM UserConnectionRequestUser u")
    , @NamedQuery(name = "UserConnectionRequestUser.findByUser1Id", query = "SELECT u FROM UserConnectionRequestUser u WHERE u.userConnectionRequestUserPK.user1Id = :user1Id")
    , @NamedQuery(name = "UserConnectionRequestUser.findByUser2Id", query = "SELECT u FROM UserConnectionRequestUser u WHERE u.userConnectionRequestUserPK.user2Id = :user2Id")
//    , @NamedQuery(name = "UserConnectionRequestUser.findByPK", query = "SELECT u FROM UserConnectionRequestUser u WHERE u.UserConnectionRequestUserPK.user1Id = :user1Id and u.UserConnectionRequestUserPK.user2Id = :user2Id")        
    , @NamedQuery(name = "UserConnectionRequestUser.findByStatus", query = "SELECT u FROM UserConnectionRequestUser u WHERE u.status = :status")
    , @NamedQuery(name = "UserConnectionRequestUser.findByDateOfRequest", query = "SELECT u FROM UserConnectionRequestUser u WHERE u.dateOfRequest = :dateOfRequest")})
public class UserConnectionRequestUser implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected UserConnectionRequestUserPK userConnectionRequestUserPK;
    @Basic(optional = false)
    @Column(name = "status")
    private int status;
    @Basic(optional = false)
    @Column(name = "date_of_request")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateOfRequest;
    @JoinColumn(name = "user1_id", referencedColumnName = "user_id", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private User user;
    @JoinColumn(name = "user2_id", referencedColumnName = "user_id", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private User user1;

    public UserConnectionRequestUser() {
    }

    public UserConnectionRequestUser(UserConnectionRequestUserPK userConnectionRequestUserPK) {
        this.userConnectionRequestUserPK = userConnectionRequestUserPK;
    }

    public UserConnectionRequestUser(UserConnectionRequestUserPK userConnectionRequestUserPK, int status, Date dateOfRequest) {
        this.userConnectionRequestUserPK = userConnectionRequestUserPK;
        this.status = status;
        this.dateOfRequest = dateOfRequest;
    }

    public UserConnectionRequestUser(int user1Id, int user2Id) {
        this.userConnectionRequestUserPK = new UserConnectionRequestUserPK(user1Id, user2Id);
    }

    public UserConnectionRequestUserPK getUserConnectionRequestUserPK() {
        return userConnectionRequestUserPK;
    }

    public void setUserConnectionRequestUserPK(UserConnectionRequestUserPK userConnectionRequestUserPK) {
        this.userConnectionRequestUserPK = userConnectionRequestUserPK;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public Date getDateOfRequest() {
        return dateOfRequest;
    }

    public void setDateOfRequest(Date dateOfRequest) {
        this.dateOfRequest = dateOfRequest;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public User getUser1() {
        return user1;
    }

    public void setUser1(User user1) {
        this.user1 = user1;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (userConnectionRequestUserPK != null ? userConnectionRequestUserPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof UserConnectionRequestUser)) {
            return false;
        }
        UserConnectionRequestUser other = (UserConnectionRequestUser) object;
        if ((this.userConnectionRequestUserPK == null && other.userConnectionRequestUserPK != null) || (this.userConnectionRequestUserPK != null && !this.userConnectionRequestUserPK.equals(other.userConnectionRequestUserPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.UserConnectionRequestUser[ userConnectionRequestUserPK=" + userConnectionRequestUserPK + " ]";
    }
    
}
