/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author user
 */
@Entity
@Table(name = "field_of_study")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "FieldOfStudy.findAll", query = "SELECT f FROM FieldOfStudy f")
    , @NamedQuery(name = "FieldOfStudy.findByFieldOfStudyId", query = "SELECT f FROM FieldOfStudy f WHERE f.fieldOfStudyId = :fieldOfStudyId")
    , @NamedQuery(name = "FieldOfStudy.findByName", query = "SELECT f FROM FieldOfStudy f WHERE f.name = :name")
    , @NamedQuery(name = "FieldOfStudy.findByDescription", query = "SELECT f FROM FieldOfStudy f WHERE f.description = :description")})
public class FieldOfStudy implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "field_of_study_id")
    private Integer fieldOfStudyId;
    @Basic(optional = false)
    @Column(name = "name")
    private String name;
    @Basic(optional = false)
    @Column(name = "description")
    private String description;
    @ManyToMany(mappedBy = "fieldOfStudyList")
    private List<Department> departmentList;

    public FieldOfStudy() {
    }

    public FieldOfStudy(Integer fieldOfStudyId) {
        this.fieldOfStudyId = fieldOfStudyId;
    }

    public FieldOfStudy(Integer fieldOfStudyId, String name, String description) {
        this.fieldOfStudyId = fieldOfStudyId;
        this.name = name;
        this.description = description;
    }

    public Integer getFieldOfStudyId() {
        return fieldOfStudyId;
    }

    public void setFieldOfStudyId(Integer fieldOfStudyId) {
        this.fieldOfStudyId = fieldOfStudyId;
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
    public List<Department> getDepartmentList() {
        return departmentList;
    }

    public void setDepartmentList(List<Department> departmentList) {
        this.departmentList = departmentList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (fieldOfStudyId != null ? fieldOfStudyId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof FieldOfStudy)) {
            return false;
        }
        FieldOfStudy other = (FieldOfStudy) object;
        if ((this.fieldOfStudyId == null && other.fieldOfStudyId != null) || (this.fieldOfStudyId != null && !this.fieldOfStudyId.equals(other.fieldOfStudyId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.FieldOfStudy[ fieldOfStudyId=" + fieldOfStudyId + " ]";
    }
    
}
