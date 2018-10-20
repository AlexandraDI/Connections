/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelxml;

import java.io.Serializable;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class JobXML implements Serializable {

    private Integer jobId;
    private String name;
    private String description;
    private Set<LanguageXML> languageList = new HashSet<>();
    private Set<SkillXML> skillList = new HashSet<>();

    public JobXML() {
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

    @XmlElementWrapper(name = "languages")
    @XmlElement(name = "language")
    public Set<LanguageXML> getLanguageList() {
        return languageList;
    }

    public void setLanguageList(Set<LanguageXML> languageList) {
        this.languageList = languageList;
    }

    @XmlElementWrapper(name = "skills")
    @XmlElement(name = "skill")
    public Set<SkillXML> getSkillList() {
        return skillList;
    }

    public void setSkillList(Set<SkillXML> skillList) {
        this.skillList = skillList;
    }

   
    
}
