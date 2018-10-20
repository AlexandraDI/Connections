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
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
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
@Table(name = "job")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Job.findAll", query = "SELECT j FROM Job j")
    , @NamedQuery(name = "Job.findByJobId", query = "SELECT j FROM Job j WHERE j.jobId = :jobId")
    , @NamedQuery(name = "Job.findByName", query = "SELECT j FROM Job j WHERE j.name = :name")
    , @NamedQuery(name = "Job.findByDescription", query = "SELECT j FROM Job j WHERE j.description = :description")})
public class Job implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "job_id")
    private Integer jobId;
    @Basic(optional = false)
    @Column(name = "name")
    private String name;
    @Basic(optional = false)
    @Column(name = "description")
    private String description;
    @JoinTable(name = "job_requires_language", joinColumns = {
        @JoinColumn(name = "job_id", referencedColumnName = "job_id")}, inverseJoinColumns = {
        @JoinColumn(name = "language_id", referencedColumnName = "language_id")})
    @ManyToMany
    private List<Language> languageList;
    @ManyToMany(mappedBy = "jobList")
    private List<Company> companyList;
    @JoinTable(name = "job_has_skill", joinColumns = {
        @JoinColumn(name = "job_id", referencedColumnName = "job_id")}, inverseJoinColumns = {
        @JoinColumn(name = "skill_id", referencedColumnName = "skill_id")})
    @ManyToMany
    private List<Skill> skillList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "jobId")
    private List<Ad> adList;
    @JoinColumn(name = "field_of_work_id", referencedColumnName = "field_of_work_id")
    @ManyToOne(optional = false)
    private FieldOfWork fieldOfWorkId;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "jobId")
    private List<ProfessionalExperience> professionalExperienceList;

    public Job() {
    }

    public Job(Integer jobId) {
        this.jobId = jobId;
    }

    public Job(Integer jobId, String name, String description) {
        this.jobId = jobId;
        this.name = name;
        this.description = description;
    }

    public Integer getJobId() {
        return jobId;
    }

    public void setJobId(Integer jobId) {
        this.jobId = jobId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @XmlTransient
    public List<Language> getLanguageList() {
        return languageList;
    }

    public void setLanguageList(List<Language> languageList) {
        this.languageList = languageList;
    }

    @XmlTransient
    public List<Company> getCompanyList() {
        return companyList;
    }

    public void setCompanyList(List<Company> companyList) {
        this.companyList = companyList;
    }

    @XmlTransient
    public List<Skill> getSkillList() {
        return skillList;
    }

    public void setSkillList(List<Skill> skillList) {
        this.skillList = skillList;
    }

    @XmlTransient
    public List<Ad> getAdList() {
        return adList;
    }

    public void setAdList(List<Ad> adList) {
        this.adList = adList;
    }

    public FieldOfWork getFieldOfWorkId() {
        return fieldOfWorkId;
    }

    public void setFieldOfWorkId(FieldOfWork fieldOfWorkId) {
        this.fieldOfWorkId = fieldOfWorkId;
    }

    @XmlTransient
    public List<ProfessionalExperience> getProfessionalExperienceList() {
        return professionalExperienceList;
    }

    public void setProfessionalExperienceList(List<ProfessionalExperience> professionalExperienceList) {
        this.professionalExperienceList = professionalExperienceList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (jobId != null ? jobId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Job)) {
            return false;
        }
        Job other = (Job) object;
        if ((this.jobId == null && other.jobId != null) || (this.jobId != null && !this.jobId.equals(other.jobId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.Job[ jobId=" + jobId + " ]";
    }
    
}
