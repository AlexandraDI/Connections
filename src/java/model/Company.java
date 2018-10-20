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
@Table(name = "company")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Company.findAll", query = "SELECT c FROM Company c")
    , @NamedQuery(name = "Company.findByCompanyId", query = "SELECT c FROM Company c WHERE c.companyId = :companyId")
    , @NamedQuery(name = "Company.findByName", query = "SELECT c FROM Company c WHERE c.name = :name")
    , @NamedQuery(name = "Company.findByYearCreated", query = "SELECT c FROM Company c WHERE c.yearCreated = :yearCreated")})
public class Company implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "company_id")
    private Integer companyId;
    @Basic(optional = false)
    @Column(name = "name")
    private String name;
    @Basic(optional = false)
    @Column(name = "year_created")
    @Temporal(TemporalType.DATE)
    private Date yearCreated;
    @JoinTable(name = "company_has_job", joinColumns = {
        @JoinColumn(name = "company_id", referencedColumnName = "company_id")}, inverseJoinColumns = {
        @JoinColumn(name = "job_id", referencedColumnName = "job_id")})
    @ManyToMany
    private List<Job> jobList;
    @JoinTable(name = "company_has_field_of_work", joinColumns = {
        @JoinColumn(name = "company_id", referencedColumnName = "company_id")}, inverseJoinColumns = {
        @JoinColumn(name = "field_of_work_id", referencedColumnName = "field_of_work_id")})
    @ManyToMany
    private List<FieldOfWork> fieldOfWorkList;
    @JoinColumn(name = "location_id", referencedColumnName = "location_id")
    @ManyToOne(optional = false)
    private Location locationId;

    public Company() {
    }

    public Company(Integer companyId) {
        this.companyId = companyId;
    }

    public Company(Integer companyId, String name, Date yearCreated) {
        this.companyId = companyId;
        this.name = name;
        this.yearCreated = yearCreated;
    }

    public Integer getCompanyId() {
        return companyId;
    }

    public void setCompanyId(Integer companyId) {
        this.companyId = companyId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getYearCreated() {
        return yearCreated;
    }

    public void setYearCreated(Date yearCreated) {
        this.yearCreated = yearCreated;
    }

    @XmlTransient
    public List<Job> getJobList() {
        return jobList;
    }

    public void setJobList(List<Job> jobList) {
        this.jobList = jobList;
    }

    @XmlTransient
    public List<FieldOfWork> getFieldOfWorkList() {
        return fieldOfWorkList;
    }

    public void setFieldOfWorkList(List<FieldOfWork> fieldOfWorkList) {
        this.fieldOfWorkList = fieldOfWorkList;
    }

    public Location getLocationId() {
        return locationId;
    }

    public void setLocationId(Location locationId) {
        this.locationId = locationId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (companyId != null ? companyId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Company)) {
            return false;
        }
        Company other = (Company) object;
        if ((this.companyId == null && other.companyId != null) || (this.companyId != null && !this.companyId.equals(other.companyId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.Company[ companyId=" + companyId + " ]";
    }
    
}
