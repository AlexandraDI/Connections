/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelxml;

import model.*;
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

public class EducationXML implements Serializable {

    private Integer educationId;
    private String degree;
    private Date entryYear;
    private Date endYear;
    private String honour;
    private DepartmentXML departmentId;

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

    public DepartmentXML getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(DepartmentXML departmentId) {
        this.departmentId = departmentId;
    }

    
}
