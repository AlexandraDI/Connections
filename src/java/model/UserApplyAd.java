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
@Table(name = "user_apply_ad")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "UserApplyAd.findAll", query = "SELECT u FROM UserApplyAd u")
    , @NamedQuery(name = "UserApplyAd.findByUserId", query = "SELECT u FROM UserApplyAd u WHERE u.userApplyAdPK.userId = :userId")
    , @NamedQuery(name = "UserApplyAd.findByAdId", query = "SELECT u FROM UserApplyAd u WHERE u.userApplyAdPK.adId = :adId")
    , @NamedQuery(name = "UserApplyAd.findByDateOfApplication", query = "SELECT u FROM UserApplyAd u WHERE u.dateOfApplication = :dateOfApplication")})
public class UserApplyAd implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected UserApplyAdPK userApplyAdPK;
    @Basic(optional = false)
    @Column(name = "date_of_application")
    @Temporal(TemporalType.DATE)
    private Date dateOfApplication;
    @JoinColumn(name = "ad_id", referencedColumnName = "ad_id", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Ad ad;
    @JoinColumn(name = "user_id", referencedColumnName = "user_id", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private User user;

    public UserApplyAd() {
    }

    public UserApplyAd(UserApplyAdPK userApplyAdPK) {
        this.userApplyAdPK = userApplyAdPK;
    }

    public UserApplyAd(UserApplyAdPK userApplyAdPK, Date dateOfApplication) {
        this.userApplyAdPK = userApplyAdPK;
        this.dateOfApplication = dateOfApplication;
    }

    public UserApplyAd(int userId, int adId) {
        this.userApplyAdPK = new UserApplyAdPK(userId, adId);
    }

    public UserApplyAdPK getUserApplyAdPK() {
        return userApplyAdPK;
    }

    public void setUserApplyAdPK(UserApplyAdPK userApplyAdPK) {
        this.userApplyAdPK = userApplyAdPK;
    }

    public Date getDateOfApplication() {
        return dateOfApplication;
    }

    public void setDateOfApplication(Date dateOfApplication) {
        this.dateOfApplication = dateOfApplication;
    }

    public Ad getAd() {
        return ad;
    }

    public void setAd(Ad ad) {
        this.ad = ad;
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
        hash += (userApplyAdPK != null ? userApplyAdPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof UserApplyAd)) {
            return false;
        }
        UserApplyAd other = (UserApplyAd) object;
        if ((this.userApplyAdPK == null && other.userApplyAdPK != null) || (this.userApplyAdPK != null && !this.userApplyAdPK.equals(other.userApplyAdPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.UserApplyAd[ userApplyAdPK=" + userApplyAdPK + " ]";
    }
    
}
