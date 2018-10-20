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
@Table(name = "tools_and_technology")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ToolsAndTechnology.findAll", query = "SELECT t FROM ToolsAndTechnology t")
    , @NamedQuery(name = "ToolsAndTechnology.findByToolsAndTechnologyId", query = "SELECT t FROM ToolsAndTechnology t WHERE t.toolsAndTechnologyId = :toolsAndTechnologyId")
    , @NamedQuery(name = "ToolsAndTechnology.findByDescription", query = "SELECT t FROM ToolsAndTechnology t WHERE t.description = :description")})
public class ToolsAndTechnology implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "tools_and_technology_id")
    private Integer toolsAndTechnologyId;
    @Basic(optional = false)
    @Column(name = "description")
    private String description;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "toolsAndTechnologyId")
    private List<Skill> skillList;

    public ToolsAndTechnology() {
    }

    public ToolsAndTechnology(Integer toolsAndTechnologyId) {
        this.toolsAndTechnologyId = toolsAndTechnologyId;
    }

    public ToolsAndTechnology(Integer toolsAndTechnologyId, String description) {
        this.toolsAndTechnologyId = toolsAndTechnologyId;
        this.description = description;
    }

    public Integer getToolsAndTechnologyId() {
        return toolsAndTechnologyId;
    }

    public void setToolsAndTechnologyId(Integer toolsAndTechnologyId) {
        this.toolsAndTechnologyId = toolsAndTechnologyId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @XmlTransient
    public List<Skill> getSkillList() {
        return skillList;
    }

    public void setSkillList(List<Skill> skillList) {
        this.skillList = skillList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (toolsAndTechnologyId != null ? toolsAndTechnologyId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ToolsAndTechnology)) {
            return false;
        }
        ToolsAndTechnology other = (ToolsAndTechnology) object;
        if ((this.toolsAndTechnologyId == null && other.toolsAndTechnologyId != null) || (this.toolsAndTechnologyId != null && !this.toolsAndTechnologyId.equals(other.toolsAndTechnologyId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.ToolsAndTechnology[ toolsAndTechnologyId=" + toolsAndTechnologyId + " ]";
    }
    
}
