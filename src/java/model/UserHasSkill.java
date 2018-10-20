/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author user
 */
@Entity
@Table(name = "user_has_skill")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "UserHasSkill.findAll", query = "SELECT u FROM UserHasSkill u")
    , @NamedQuery(name = "UserHasSkill.findByUserId", query = "SELECT u FROM UserHasSkill u WHERE u.userHasSkillPK.userId = :userId")
    , @NamedQuery(name = "UserHasSkill.findBySkillId", query = "SELECT u FROM UserHasSkill u WHERE u.userHasSkillPK.skillId = :skillId")})
public class UserHasSkill implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected UserHasSkillPK userHasSkillPK;
    @JoinColumn(name = "certification_id", referencedColumnName = "certification_id")
    @ManyToOne
    private Certification certificationId;
    @JoinColumn(name = "skill_id", referencedColumnName = "skill_id", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Skill skill;
    @JoinColumn(name = "user_id", referencedColumnName = "user_id", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private User user;

    public UserHasSkill() {
    }

    public UserHasSkill(UserHasSkillPK userHasSkillPK) {
        this.userHasSkillPK = userHasSkillPK;
    }

    public UserHasSkill(int userId, int skillId) {
        this.userHasSkillPK = new UserHasSkillPK(userId, skillId);
    }

    public UserHasSkillPK getUserHasSkillPK() {
        return userHasSkillPK;
    }

    public void setUserHasSkillPK(UserHasSkillPK userHasSkillPK) {
        this.userHasSkillPK = userHasSkillPK;
    }

    public Certification getCertificationId() {
        return certificationId;
    }

    public void setCertificationId(Certification certificationId) {
        this.certificationId = certificationId;
    }

    public Skill getSkill() {
        return skill;
    }

    public void setSkill(Skill skill) {
        this.skill = skill;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (userHasSkillPK != null ? userHasSkillPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof UserHasSkill)) {
            return false;
        }
        UserHasSkill other = (UserHasSkill) object;
        if ((this.userHasSkillPK == null && other.userHasSkillPK != null) || (this.userHasSkillPK != null && !this.userHasSkillPK.equals(other.userHasSkillPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.UserHasSkill[ userHasSkillPK=" + userHasSkillPK + " ]";
    }
    
}
