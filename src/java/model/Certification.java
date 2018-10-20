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
@Table(name = "certification")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Certification.findAll", query = "SELECT c FROM Certification c")
    , @NamedQuery(name = "Certification.findByCertificationId", query = "SELECT c FROM Certification c WHERE c.certificationId = :certificationId")
    , @NamedQuery(name = "Certification.findByDescription", query = "SELECT c FROM Certification c WHERE c.description = :description")
    , @NamedQuery(name = "Certification.findByDateEstablished", query = "SELECT c FROM Certification c WHERE c.dateEstablished = :dateEstablished")
    , @NamedQuery(name = "Certification.findByDateOfExpiration", query = "SELECT c FROM Certification c WHERE c.dateOfExpiration = :dateOfExpiration")})
public class Certification implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "certification_id")
    private Integer certificationId;
    @Basic(optional = false)
    @Column(name = "description")
    private String description;
    @Basic(optional = false)
    @Column(name = "date_established")
    @Temporal(TemporalType.DATE)
    private Date dateEstablished;
    @Column(name = "date_of_expiration")
    @Temporal(TemporalType.DATE)
    private Date dateOfExpiration;
    @OneToMany(mappedBy = "certificationId")
    private List<UserHasSkill> userHasSkillList;
    @JoinColumn(name = "department_id", referencedColumnName = "department_id")
    @ManyToOne
    private Department departmentId;
    @JoinColumn(name = "school_id", referencedColumnName = "school_id")
    @ManyToOne(optional = false)
    private School schoolId;

    public Certification() {
    }

    public Certification(Integer certificationId) {
        this.certificationId = certificationId;
    }

    public Certification(Integer certificationId, String description, Date dateEstablished) {
        this.certificationId = certificationId;
        this.description = description;
        this.dateEstablished = dateEstablished;
    }

    public Integer getCertificationId() {
        return certificationId;
    }

    public void setCertificationId(Integer certificationId) {
        this.certificationId = certificationId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getDateEstablished() {
        return dateEstablished;
    }

    public void setDateEstablished(Date dateEstablished) {
        this.dateEstablished = dateEstablished;
    }

    public Date getDateOfExpiration() {
        return dateOfExpiration;
    }

    public void setDateOfExpiration(Date dateOfExpiration) {
        this.dateOfExpiration = dateOfExpiration;
    }

    @XmlTransient
    public List<UserHasSkill> getUserHasSkillList() {
        return userHasSkillList;
    }

    public void setUserHasSkillList(List<UserHasSkill> userHasSkillList) {
        this.userHasSkillList = userHasSkillList;
    }

    public Department getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(Department departmentId) {
        this.departmentId = departmentId;
    }

    public School getSchoolId() {
        return schoolId;
    }

    public void setSchoolId(School schoolId) {
        this.schoolId = schoolId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (certificationId != null ? certificationId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Certification)) {
            return false;
        }
        Certification other = (Certification) object;
        if ((this.certificationId == null && other.certificationId != null) || (this.certificationId != null && !this.certificationId.equals(other.certificationId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.Certification[ certificationId=" + certificationId + " ]";
    }
    
}
