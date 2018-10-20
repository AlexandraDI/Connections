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
@Table(name = "user_follows_user")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "UserFollowsUser.findAll", query = "SELECT u FROM UserFollowsUser u")
    , @NamedQuery(name = "UserFollowsUser.findByUser1Id", query = "SELECT u FROM UserFollowsUser u WHERE u.userFollowsUserPK.user1Id = :user1Id")
    , @NamedQuery(name = "UserFollowsUser.findByUser2Id", query = "SELECT u FROM UserFollowsUser u WHERE u.userFollowsUserPK.user2Id = :user2Id")
    , @NamedQuery(name = "UserFollowsUser.findByDatetimeFollowed", query = "SELECT u FROM UserFollowsUser u WHERE u.datetimeFollowed = :datetimeFollowed")})
public class UserFollowsUser implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected UserFollowsUserPK userFollowsUserPK;
    @Basic(optional = false)
    @Column(name = "datetime_followed")
    @Temporal(TemporalType.TIMESTAMP)
    private Date datetimeFollowed;
    @JoinColumn(name = "user1_id", referencedColumnName = "user_id", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private User user;
    @JoinColumn(name = "user2_id", referencedColumnName = "user_id", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private User user1;

    public UserFollowsUser() {
    }

    public UserFollowsUser(UserFollowsUserPK userFollowsUserPK) {
        this.userFollowsUserPK = userFollowsUserPK;
    }

    public UserFollowsUser(UserFollowsUserPK userFollowsUserPK, Date datetimeFollowed) {
        this.userFollowsUserPK = userFollowsUserPK;
        this.datetimeFollowed = datetimeFollowed;
    }

    public UserFollowsUser(int user1Id, int user2Id) {
        this.userFollowsUserPK = new UserFollowsUserPK(user1Id, user2Id);
    }

    public UserFollowsUserPK getUserFollowsUserPK() {
        return userFollowsUserPK;
    }

    public void setUserFollowsUserPK(UserFollowsUserPK userFollowsUserPK) {
        this.userFollowsUserPK = userFollowsUserPK;
    }

    public Date getDatetimeFollowed() {
        return datetimeFollowed;
    }

    public void setDatetimeFollowed(Date datetimeFollowed) {
        this.datetimeFollowed = datetimeFollowed;
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
        hash += (userFollowsUserPK != null ? userFollowsUserPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof UserFollowsUser)) {
            return false;
        }
        UserFollowsUser other = (UserFollowsUser) object;
        if ((this.userFollowsUserPK == null && other.userFollowsUserPK != null) || (this.userFollowsUserPK != null && !this.userFollowsUserPK.equals(other.userFollowsUserPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.UserFollowsUser[ userFollowsUserPK=" + userFollowsUserPK + " ]";
    }
    
}
