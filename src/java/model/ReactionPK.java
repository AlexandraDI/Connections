/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 *
 * @author alex
 */
@Embeddable
public class ReactionPK implements Serializable {

    @Basic(optional = false)
    @Column(name = "article_id")
    private int articleId;
    @Basic(optional = false)
    @Column(name = "user_id")
    private int userId;

    public ReactionPK() {
    }

    public ReactionPK(int articleId, int userId) {
        this.articleId = articleId;
        this.userId = userId;
    }

    public int getArticleId() {
        return articleId;
    }

    public void setArticleId(int articleId) {
        this.articleId = articleId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) articleId;
        hash += (int) userId;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ReactionPK)) {
            return false;
        }
        ReactionPK other = (ReactionPK) object;
        if (this.articleId != other.articleId) {
            return false;
        }
        if (this.userId != other.userId) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.ReactionPK[ articleId=" + articleId + ", userId=" + userId + " ]";
    }
    
}
