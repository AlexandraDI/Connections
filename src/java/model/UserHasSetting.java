/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author user
 */
@Entity
@Table(name = "user_has_setting")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "UserHasSetting.findAll", query = "SELECT u FROM UserHasSetting u")
    , @NamedQuery(name = "UserHasSetting.findByUserId", query = "SELECT u FROM UserHasSetting u WHERE u.userHasSettingPK.userId = :userId")
    , @NamedQuery(name = "UserHasSetting.findBySettingId", query = "SELECT u FROM UserHasSetting u WHERE u.userHasSettingPK.settingId = :settingId")
    , @NamedQuery(name = "UserHasSetting.findByValue", query = "SELECT u FROM UserHasSetting u WHERE u.value = :value")})
public class UserHasSetting implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected UserHasSettingPK userHasSettingPK;
    @Basic(optional = false)
    @Column(name = "value")
    private String value;
    @JoinColumn(name = "setting_id", referencedColumnName = "setting_id", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Setting setting;
    @JoinColumn(name = "user_id", referencedColumnName = "user_id", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private User user;

    public UserHasSetting() {
    }

    public UserHasSetting(UserHasSettingPK userHasSettingPK) {
        this.userHasSettingPK = userHasSettingPK;
    }

    public UserHasSetting(UserHasSettingPK userHasSettingPK, String value) {
        this.userHasSettingPK = userHasSettingPK;
        this.value = value;
    }

    public UserHasSetting(int userId, int settingId) {
        this.userHasSettingPK = new UserHasSettingPK(userId, settingId);
    }

    public UserHasSettingPK getUserHasSettingPK() {
        return userHasSettingPK;
    }

    public void setUserHasSettingPK(UserHasSettingPK userHasSettingPK) {
        this.userHasSettingPK = userHasSettingPK;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public Setting getSetting() {
        return setting;
    }

    public void setSetting(Setting setting) {
        this.setting = setting;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (userHasSettingPK != null ? userHasSettingPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof UserHasSetting)) {
            return false;
        }
        UserHasSetting other = (UserHasSetting) object;
        if ((this.userHasSettingPK == null && other.userHasSettingPK != null) || (this.userHasSettingPK != null && !this.userHasSettingPK.equals(other.userHasSettingPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.UserHasSetting[ userHasSettingPK=" + userHasSettingPK + " ]";
    }
    
}
