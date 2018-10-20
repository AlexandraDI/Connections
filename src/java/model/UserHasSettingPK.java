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
public class UserHasSettingPK implements Serializable {

    @Basic(optional = false)
    @Column(name = "user_id")
    private int userId;
    @Basic(optional = false)
    @Column(name = "setting_id")
    private int settingId;

    public UserHasSettingPK() {
    }

    public UserHasSettingPK(int userId, int settingId) {
        this.userId = userId;
        this.settingId = settingId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getSettingId() {
        return settingId;
    }

    public void setSettingId(int settingId) {
        this.settingId = settingId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) userId;
        hash += (int) settingId;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof UserHasSettingPK)) {
            return false;
        }
        UserHasSettingPK other = (UserHasSettingPK) object;
        if (this.userId != other.userId) {
            return false;
        }
        if (this.settingId != other.settingId) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.UserHasSettingPK[ userId=" + userId + ", settingId=" + settingId + " ]";
    }
    
}
