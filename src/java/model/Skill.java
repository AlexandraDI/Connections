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
@Table(name = "skill")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Skill.findAll", query = "SELECT s FROM Skill s")
    , @NamedQuery(name = "Skill.findBySkillId", query = "SELECT s FROM Skill s WHERE s.skillId = :skillId")
    , @NamedQuery(name = "Skill.findByDescription", query = "SELECT s FROM Skill s WHERE s.description = :description")})
public class Skill implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "skill_id")
    private Integer skillId;
    @Basic(optional = false)
    @Column(name = "description")
    private String description;
    @ManyToMany(mappedBy = "skillList")
    private List<Job> jobList;
    @JoinColumn(name = "tools_and_technology_id", referencedColumnName = "tools_and_technology_id")
    @ManyToOne(optional = false)
    private ToolsAndTechnology toolsAndTechnologyId;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "skill")
    private List<UserHasSkill> userHasSkillList;

    public Skill() {
    }

    public Skill(Integer skillId) {
        this.skillId = skillId;
    }

    public Skill(Integer skillId, String description) {
        this.skillId = skillId;
        this.description = description;
    }

    public Integer getSkillId() {
        return skillId;
    }

    public void setSkillId(Integer skillId) {
        this.skillId = skillId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @XmlTransient
    public List<Job> getJobList() {
        return jobList;
    }

    public void setJobList(List<Job> jobList) {
        this.jobList = jobList;
    }

    public ToolsAndTechnology getToolsAndTechnologyId() {
        return toolsAndTechnologyId;
    }

    public void setToolsAndTechnologyId(ToolsAndTechnology toolsAndTechnologyId) {
        this.toolsAndTechnologyId = toolsAndTechnologyId;
    }

    @XmlTransient
    public List<UserHasSkill> getUserHasSkillList() {
        return userHasSkillList;
    }

    public void setUserHasSkillList(List<UserHasSkill> userHasSkillList) {
        this.userHasSkillList = userHasSkillList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (skillId != null ? skillId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Skill)) {
            return false;
        }
        Skill other = (Skill) object;
        if ((this.skillId == null && other.skillId != null) || (this.skillId != null && !this.skillId.equals(other.skillId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.Skill[ skillId=" + skillId + " ]";
    }
    
}
