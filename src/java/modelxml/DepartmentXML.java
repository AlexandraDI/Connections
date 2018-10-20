/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelxml;

import model.*;
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

public class DepartmentXML implements Serializable {

    private Integer departmentId;
    private String name;
    private List<FieldOfStudy> fieldOfStudyList;
    private List<Education> educationList;
    private SchoolXML schoolId;

    public Integer getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(Integer departmentId) {
        this.departmentId = departmentId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<FieldOfStudy> getFieldOfStudyList() {
        return fieldOfStudyList;
    }

    public void setFieldOfStudyList(List<FieldOfStudy> fieldOfStudyList) {
        this.fieldOfStudyList = fieldOfStudyList;
    }

    public List<Education> getEducationList() {
        return educationList;
    }

    public void setEducationList(List<Education> educationList) {
        this.educationList = educationList;
    }

    public SchoolXML getSchoolId() {
        return schoolId;
    }

    public void setSchoolId(SchoolXML schoolId) {
        this.schoolId = schoolId;
    }

}
