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
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
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
@Table(name = "language")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Language.findAll", query = "SELECT l FROM Language l order by l.language asc")
    , @NamedQuery(name = "Language.findByLanguageId", query = "SELECT l FROM Language l WHERE l.languageId = :languageId")
    , @NamedQuery(name = "Language.findByLanguage", query = "SELECT l FROM Language l WHERE l.language = :language")})
public class Language implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "language_id")
    private Integer languageId;
    @Basic(optional = false)
    @Column(name = "language")
    private String language;
    @ManyToMany(mappedBy = "languageList")
    private List<Job> jobList;
    @JoinTable(name = "user_has_language", joinColumns = {
        @JoinColumn(name = "language_id", referencedColumnName = "language_id")}, inverseJoinColumns = {
        @JoinColumn(name = "user_id", referencedColumnName = "user_id")})
    @ManyToMany
    private List<User> userList;

    public Language() {
    }

    public Language(Integer languageId) {
        this.languageId = languageId;
    }

    public Language(Integer languageId, String language) {
        this.languageId = languageId;
        this.language = language;
    }

    public Integer getLanguageId() {
        return languageId;
    }

    public void setLanguageId(Integer languageId) {
        this.languageId = languageId;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    @XmlTransient
    public List<Job> getJobList() {
        return jobList;
    }

    public void setJobList(List<Job> jobList) {
        this.jobList = jobList;
    }

    @XmlTransient
    public List<User> getUserList() {
        return userList;
    }

    public void setUserList(List<User> userList) {
        this.userList = userList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (languageId != null ? languageId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Language)) {
            return false;
        }
        Language other = (Language) object;
        if ((this.languageId == null && other.languageId != null) || (this.languageId != null && !this.languageId.equals(other.languageId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.Language[ languageId=" + languageId + " ]";
    }
    
}
