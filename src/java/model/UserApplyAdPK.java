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
public class UserApplyAdPK implements Serializable {

    @Basic(optional = false)
    @Column(name = "user_id")
    private int userId;
    @Basic(optional = false)
    @Column(name = "ad_id")
    private int adId;

    public UserApplyAdPK() {
    }

    public UserApplyAdPK(int userId, int adId) {
        this.userId = userId;
        this.adId = adId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getAdId() {
        return adId;
    }

    public void setAdId(int adId) {
        this.adId = adId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) userId;
        hash += (int) adId;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof UserApplyAdPK)) {
            return false;
        }
        UserApplyAdPK other = (UserApplyAdPK) object;
        if (this.userId != other.userId) {
            return false;
        }
        if (this.adId != other.adId) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.UserApplyAdPK[ userId=" + userId + ", adId=" + adId + " ]";
    }
    
}
