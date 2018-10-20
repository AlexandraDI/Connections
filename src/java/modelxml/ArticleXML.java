/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelxml;

import java.io.Serializable;
import java.util.Date;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class ArticleXML implements Serializable {

    private Integer articleId;
    private String title;
    private String content;
    private Date datetime_created;

    public ArticleXML() {
    }

    public Integer getArticleId() {
        return articleId;
    }

    public void setArticleId(Integer articleId) {
        this.articleId = articleId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Date getDatetime_created() {
        return datetime_created;
    }

    public void setDatetime_created(Date datetime_created) {
        this.datetime_created = datetime_created;
    }

    
}
