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
import javax.persistence.ManyToMany;
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
@Table(name = "field_of_work")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "FieldOfWork.findAll", query = "SELECT f FROM FieldOfWork f")
    , @NamedQuery(name = "FieldOfWork.findByFieldOfWorkId", query = "SELECT f FROM FieldOfWork f WHERE f.fieldOfWorkId = :fieldOfWorkId")
    , @NamedQuery(name = "FieldOfWork.findByName", query = "SELECT f FROM FieldOfWork f WHERE f.name = :name")
    , @NamedQuery(name = "FieldOfWork.findByDescription", query = "SELECT f FROM FieldOfWork f WHERE f.description = :description")})
public class FieldOfWork implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "field_of_work_id")
    private Integer fieldOfWorkId;
    @Basic(optional = false)
    @Column(name = "name")
    private String name;
    @Column(name = "description")
    private String description;
    @ManyToMany(mappedBy = "fieldOfWorkList")
    private List<Company> companyList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "fieldOfWorkId")
    private List<Job> jobList;

    public FieldOfWork() {
    }

    public FieldOfWork(Integer fieldOfWorkId) {
        this.fieldOfWorkId = fieldOfWorkId;
    }

    public FieldOfWork(Integer fieldOfWorkId, String name) {
        this.fieldOfWorkId = fieldOfWorkId;
        this.name = name;
    }

    public Integer getFieldOfWorkId() {
        return fieldOfWorkId;
    }

    public void setFieldOfWorkId(Integer fieldOfWorkId) {
        this.fieldOfWorkId = fieldOfWorkId;
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
    public List<Company> getCompanyList() {
        return companyList;
    }

    public void setCompanyList(List<Company> companyList) {
        this.companyList = companyList;
    }

    @XmlTransient
    public List<Job> getJobList() {
        return jobList;
    }

    public void setJobList(List<Job> jobList) {
        this.jobList = jobList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (fieldOfWorkId != null ? fieldOfWorkId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof FieldOfWork)) {
            return false;
        }
        FieldOfWork other = (FieldOfWork) object;
        if ((this.fieldOfWorkId == null && other.fieldOfWorkId != null) || (this.fieldOfWorkId != null && !this.fieldOfWorkId.equals(other.fieldOfWorkId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.FieldOfWork[ fieldOfWorkId=" + fieldOfWorkId + " ]";
    }
    
}
