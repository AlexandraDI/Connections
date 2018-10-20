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
@Table(name = "ad")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Ad.findAll", query = "SELECT a FROM Ad a")
    , @NamedQuery(name = "Ad.findByAdId", query = "SELECT a FROM Ad a WHERE a.adId = :adId")
    , @NamedQuery(name = "Ad.findByDescription", query = "SELECT a FROM Ad a WHERE a.description = :description")
    , @NamedQuery(name = "Ad.findByTitle", query = "SELECT a FROM Ad a WHERE a.title = :title")
    , @NamedQuery(name = "Ad.findByDatetimeCreated", query = "SELECT a FROM Ad a WHERE a.datetimeCreated = :datetimeCreated")
    , @NamedQuery(name = "Ad.findByApplicationDeadlineDate", query = "SELECT a FROM Ad a WHERE a.applicationDeadlineDate = :applicationDeadlineDate")})
public class Ad implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ad_id")
    private Integer adId;
    @Basic(optional = false)
    @Column(name = "description")
    private String description;
    @Basic(optional = false)
    @Column(name = "title")
    private String title;
    @Basic(optional = false)
    @Column(name = "datetime_created")
    @Temporal(TemporalType.TIMESTAMP)
    private Date datetimeCreated;
    @Column(name = "application_deadline_date")
    @Temporal(TemporalType.DATE)
    private Date applicationDeadlineDate;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "ad")
    private List<UserApplyAd> userApplyAdList;
    @JoinColumn(name = "job_id", referencedColumnName = "job_id")
    @ManyToOne(optional = false)
    private Job jobId;
    @JoinColumn(name = "user_id", referencedColumnName = "user_id")
    @ManyToOne(optional = false)
    private User userId;

    public Ad() {
    }

    public Ad(Integer adId) {
        this.adId = adId;
    }

    public Ad(Integer adId, String description, String title, Date datetimeCreated) {
        this.adId = adId;
        this.description = description;
        this.title = title;
        this.datetimeCreated = datetimeCreated;
    }

    public Integer getAdId() {
        return adId;
    }

    public void setAdId(Integer adId) {
        this.adId = adId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Date getDatetimeCreated() {
        return datetimeCreated;
    }

    public void setDatetimeCreated(Date datetimeCreated) {
        this.datetimeCreated = datetimeCreated;
    }

    public Date getApplicationDeadlineDate() {
        return applicationDeadlineDate;
    }

    public void setApplicationDeadlineDate(Date applicationDeadlineDate) {
        this.applicationDeadlineDate = applicationDeadlineDate;
    }

    @XmlTransient
    public List<UserApplyAd> getUserApplyAdList() {
        return userApplyAdList;
    }

    public void setUserApplyAdList(List<UserApplyAd> userApplyAdList) {
        this.userApplyAdList = userApplyAdList;
    }

    public Job getJobId() {
        return jobId;
    }

    public void setJobId(Job jobId) {
        this.jobId = jobId;
    }

    public User getUserId() {
        return userId;
    }

    public void setUserId(User userId) {
        this.userId = userId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (adId != null ? adId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Ad)) {
            return false;
        }
        Ad other = (Ad) object;
        if ((this.adId == null && other.adId != null) || (this.adId != null && !this.adId.equals(other.adId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.Ad[ adId=" + adId + " ]";
    }
    
}
