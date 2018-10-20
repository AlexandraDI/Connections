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
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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
@Table(name = "professional_experience")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ProfessionalExperience.findAll", query = "SELECT p FROM ProfessionalExperience p")
    , @NamedQuery(name = "ProfessionalExperience.findByProfessionalExperienceId", query = "SELECT p FROM ProfessionalExperience p WHERE p.professionalExperienceId = :professionalExperienceId")
    , @NamedQuery(name = "ProfessionalExperience.findByDateStarted", query = "SELECT p FROM ProfessionalExperience p WHERE p.dateStarted = :dateStarted")
    , @NamedQuery(name = "ProfessionalExperience.findByDateEnded", query = "SELECT p FROM ProfessionalExperience p WHERE p.dateEnded = :dateEnded")})
public class ProfessionalExperience implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "professional_experience_id")
    private Integer professionalExperienceId;
    @Basic(optional = false)
    @Column(name = "date_started")
    @Temporal(TemporalType.DATE)
    private Date dateStarted;
    @Column(name = "date_ended")
    @Temporal(TemporalType.DATE)
    private Date dateEnded;
    @JoinColumn(name = "job_id", referencedColumnName = "job_id")
    @ManyToOne(optional = false)
    private Job jobId;
    @JoinColumn(name = "user_id", referencedColumnName = "user_id")
    @ManyToOne(optional = false)
    private User userId;

    public ProfessionalExperience() {
    }

    public ProfessionalExperience(Integer professionalExperienceId) {
        this.professionalExperienceId = professionalExperienceId;
    }

    public ProfessionalExperience(Integer professionalExperienceId, Date dateStarted) {
        this.professionalExperienceId = professionalExperienceId;
        this.dateStarted = dateStarted;
    }

    public Integer getProfessionalExperienceId() {
        return professionalExperienceId;
    }

    public void setProfessionalExperienceId(Integer professionalExperienceId) {
        this.professionalExperienceId = professionalExperienceId;
    }

    public Date getDateStarted() {
        return dateStarted;
    }

    public void setDateStarted(Date dateStarted) {
        this.dateStarted = dateStarted;
    }

    public Date getDateEnded() {
        return dateEnded;
    }

    public void setDateEnded(Date dateEnded) {
        this.dateEnded = dateEnded;
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
        hash += (professionalExperienceId != null ? professionalExperienceId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ProfessionalExperience)) {
            return false;
        }
        ProfessionalExperience other = (ProfessionalExperience) object;
        if ((this.professionalExperienceId == null && other.professionalExperienceId != null) || (this.professionalExperienceId != null && !this.professionalExperienceId.equals(other.professionalExperienceId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.ProfessionalExperience[ professionalExperienceId=" + professionalExperienceId + " ]";
    }
    
}
