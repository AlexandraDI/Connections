/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author user
 */
@Entity
@Table(name = "comment")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Comment.findAll", query = "SELECT c FROM Comment c")
    , @NamedQuery(name = "Comment.findByCommentId", query = "SELECT c FROM Comment c WHERE c.commentId = :commentId")
    , @NamedQuery(name = "Comment.findByContent", query = "SELECT c FROM Comment c WHERE c.content = :content")
    , @NamedQuery(name = "Comment.findByDatetimeCreated", query = "SELECT c FROM Comment c WHERE c.datetimeCreated = :datetimeCreated")})
public class Comment implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "comment_id")
    private Integer commentId;
    @Basic(optional = false)
    @Column(name = "content")
    private String content;
    @Basic(optional = false)
    @Column(name = "datetime_created")
    @Temporal(TemporalType.TIMESTAMP)
    private Date datetimeCreated;
    @JoinColumn(name = "article_id", referencedColumnName = "article_id")
    @ManyToOne(optional = false)
    private Article articleId;
    @JoinColumn(name = "user_id", referencedColumnName = "user_id")
    @ManyToOne(optional = false)
    private User userId;

    public Comment() {
    }

    public Comment(Integer commentId) {
        this.commentId = commentId;
    }

    public Comment(Integer commentId, String content, Date datetimeCreated) {
        this.commentId = commentId;
        this.content = content;
        this.datetimeCreated = datetimeCreated;
    }

    public Integer getCommentId() {
        return commentId;
    }

    public void setCommentId(Integer commentId) {
        this.commentId = commentId;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Date getDatetimeCreated() {
        return datetimeCreated;
    }

    public void setDatetimeCreated(Date datetimeCreated) {
        this.datetimeCreated = datetimeCreated;
    }

    public Article getArticleId() {
        return articleId;
    }

    public void setArticleId(Article articleId) {
        this.articleId = articleId;
    }

    public User getUserId() {
        return userId;
    }

    public void setUserId(User userId) {
        this.userId = userId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (commentId != null ? commentId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Comment)) {
            return false;
        }
        Comment other = (Comment) object;
        if ((this.commentId == null && other.commentId != null) || (this.commentId != null && !this.commentId.equals(other.commentId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.Comment[ commentId=" + commentId + " ]";
    }
    
}
