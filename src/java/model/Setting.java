/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author user
 */
@Entity
@Table(name = "setting")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Setting.findAll", query = "SELECT s FROM Setting s")
    , @NamedQuery(name = "Setting.findBySettingId", query = "SELECT s FROM Setting s WHERE s.settingId = :settingId")
    , @NamedQuery(name = "Setting.findByDescription", query = "SELECT s FROM Setting s WHERE s.description = :description")})
public class Setting implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "setting_id")
    private Integer settingId;
    @Basic(optional = false)
    @Column(name = "description")
    private String description;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "setting")
    private List<UserHasSetting> userHasSettingList;

    public Setting() {
    }

    public Setting(Integer settingId) {
        this.settingId = settingId;
    }

    public Setting(Integer settingId, String description) {
        this.settingId = settingId;
        this.description = description;
    }

    public Integer getSettingId() {
        return settingId;
    }

    public void setSettingId(Integer settingId) {
        this.settingId = settingId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @XmlTransient
    public List<UserHasSetting> getUserHasSettingList() {
        return userHasSettingList;
    }

    public void setUserHasSettingList(List<UserHasSetting> userHasSettingList) {
        this.userHasSettingList = userHasSettingList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (settingId != null ? settingId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Setting)) {
            return false;
        }
        Setting other = (Setting) object;
        if ((this.settingId == null && other.settingId != null) || (this.settingId != null && !this.settingId.equals(other.settingId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.Setting[ settingId=" + settingId + " ]";
    }
    
}
