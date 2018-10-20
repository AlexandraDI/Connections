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
@Table(name = "user_is_connected_to_user")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "UserIsConnectedToUser.findAll", query = "SELECT u FROM UserIsConnectedToUser u")
    , @NamedQuery(name = "UserIsConnectedToUser.findByUser1Id", query = "SELECT u FROM UserIsConnectedToUser u WHERE u.userIsConnectedToUserPK.user1Id = :user1Id")
    , @NamedQuery(name = "UserIsConnectedToUser.findByUser2Id", query = "SELECT u FROM UserIsConnectedToUser u WHERE u.userIsConnectedToUserPK.user2Id = :user2Id")
    , @NamedQuery(name = "UserIsConnectedToUser.findByDatetimeConnectionMade", query = "SELECT u FROM UserIsConnectedToUser u WHERE u.datetimeConnectionMade = :datetimeConnectionMade")})
public class UserIsConnectedToUser implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected UserIsConnectedToUserPK userIsConnectedToUserPK;
    @Basic(optional = false)
    @Column(name = "datetime_connection_made")
    @Temporal(TemporalType.TIMESTAMP)
    private Date datetimeConnectionMade;
    @JoinColumn(name = "user1_id", referencedColumnName = "user_id", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private User user;
    @JoinColumn(name = "user2_id", referencedColumnName = "user_id", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private User user1;

    public UserIsConnectedToUser() {
    }

    public UserIsConnectedToUser(UserIsConnectedToUserPK userIsConnectedToUserPK) {
        this.userIsConnectedToUserPK = userIsConnectedToUserPK;
    }

    public UserIsConnectedToUser(UserIsConnectedToUserPK userIsConnectedToUserPK, Date datetimeConnectionMade) {
        this.userIsConnectedToUserPK = userIsConnectedToUserPK;
        this.datetimeConnectionMade = datetimeConnectionMade;
    }

    public UserIsConnectedToUser(int user1Id, int user2Id) {
        this.userIsConnectedToUserPK = new UserIsConnectedToUserPK(user1Id, user2Id);
    }

    public UserIsConnectedToUserPK getUserIsConnectedToUserPK() {
        return userIsConnectedToUserPK;
    }

    public void setUserIsConnectedToUserPK(UserIsConnectedToUserPK userIsConnectedToUserPK) {
        this.userIsConnectedToUserPK = userIsConnectedToUserPK;
    }

    public Date getDatetimeConnectionMade() {
        return datetimeConnectionMade;
    }

    public void setDatetimeConnectionMade(Date datetimeConnectionMade) {
        this.datetimeConnectionMade = datetimeConnectionMade;
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
        hash += (userIsConnectedToUserPK != null ? userIsConnectedToUserPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof UserIsConnectedToUser)) {
            return false;
        }
        UserIsConnectedToUser other = (UserIsConnectedToUser) object;
        if ((this.userIsConnectedToUserPK == null && other.userIsConnectedToUserPK != null) || (this.userIsConnectedToUserPK != null && !this.userIsConnectedToUserPK.equals(other.userIsConnectedToUserPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.UserIsConnectedToUser[ userIsConnectedToUserPK=" + userIsConnectedToUserPK + " ]";
    }
    
}
