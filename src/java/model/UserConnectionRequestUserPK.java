/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 *
 * @author user
 */
@Embeddable
public class UserConnectionRequestUserPK implements Serializable {

    @Basic(optional = false)
    @Column(name = "user1_id")
    private int user1Id;
    @Basic(optional = false)
    @Column(name = "user2_id")
    private int user2Id;

    public UserConnectionRequestUserPK() {
    }

    public UserConnectionRequestUserPK(int user1Id, int user2Id) {
        this.user1Id = user1Id;
        this.user2Id = user2Id;
    }

    public int getUser1Id() {
        return user1Id;
    }

    public void setUser1Id(int user1Id) {
        this.user1Id = user1Id;
    }

    public int getUser2Id() {
        return user2Id;
    }

    public void setUser2Id(int user2Id) {
        this.user2Id = user2Id;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) user1Id;
        hash += (int) user2Id;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof UserConnectionRequestUserPK)) {
            return false;
        }
        UserConnectionRequestUserPK other = (UserConnectionRequestUserPK) object;
        if (this.user1Id != other.user1Id) {
            return false;
        }
        if (this.user2Id != other.user2Id) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.UserConnectionRequestUserPK[ user1Id=" + user1Id + ", user2Id=" + user2Id + " ]";
    }
    
}
