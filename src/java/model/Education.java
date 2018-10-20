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
 * @author alex
 */
@Entity
@Table(name = "education")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Education.findAll", query = "SELECT e FROM Education e")
    , @NamedQuery(name = "Education.findByEducationId", query = "SELECT e FROM Education e WHERE e.educationId = :educationId")
    , @NamedQuery(name = "Education.findByDegree", query = "SELECT e FROM Education e WHERE e.degree = :degree")
    , @NamedQuery(name = "Education.findByEntryYear", query = "SELECT e FROM Education e WHERE e.entryYear = :entryYear")
    , @NamedQuery(name = "Education.findByEndYear", query = "SELECT e FROM Education e WHERE e.endYear = :endYear")
    , @NamedQuery(name = "Education.findByHonour", query = "SELECT e FROM Education e WHERE e.honour = :honour")})
public class Education implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "education_id")
    private Integer educationId;
    @Basic(optional = false)
    @Column(name = "degree")
    private String degree;
    @Column(name = "entry_year")
    @Temporal(TemporalType.DATE)
    private Date entryYear;
    @Column(name = "end_year")
    @Temporal(TemporalType.DATE)
    private Date endYear;
    @Column(name = "honour")
    private String honour;
    @JoinColumn(name = "department_id", referencedColumnName = "department_id")
    @ManyToOne(optional = false)
    private Department departmentId;
    @JoinColumn(name = "user_id", referencedColumnName = "user_id")
    @ManyToOne(optional = false)
    private User userId;

    public Education() {
    }

    public Education(Integer educationId) {
        this.educationId = educationId;
    }

    public Education(Integer educationId, String degree) {
        this.educationId = educationId;
        this.degree = degree;
    }

    public Integer getEducationId() {
        return educationId;
    }

    public void setEducationId(Integer educationId) {
        this.educationId = educationId;
    }

    public String getDegree() {
        return degree;
    }

    public void setDegree(String degree) {
        this.degree = degree;
    }

    public Date getEntryYear() {
        return entryYear;
    }

    public void setEntryYear(Date entryYear) {
        this.entryYear = entryYear;
    }

    public Date getEndYear() {
        return endYear;
    }

    public void setEndYear(Date endYear) {
        this.endYear = endYear;
    }

    public String getHonour() {
        return honour;
    }

    public void setHonour(String honour) {
        this.honour = honour;
    }

    public Department getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(Department departmentId) {
        this.departmentId = departmentId;
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
        hash += (educationId != null ? educationId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Education)) {
            return false;
        }
        Education other = (Education) object;
        if ((this.educationId == null && other.educationId != null) || (this.educationId != null && !this.educationId.equals(other.educationId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.Education[ educationId=" + educationId + " ]";
    }
    
}
