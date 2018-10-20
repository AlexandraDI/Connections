/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelxml;

import model.*;
import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.HashSet;
import java.util.Set;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class AdXML implements Serializable {

    private Integer adId;
    private String description;
    private String title;
    private Date datetimeCreated;
    private Date applicationDeadlineDate;
    private Set<UserApplyAdXML> userApplyAdList = new HashSet<>();
    private JobXML jobId;

    public AdXML() {
    }

    public Integer getAdId() {
        return adId;
    }

    public void setAdId(Integer adId) {
        this.adId = adId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Date getDatetimeCreated() {
        return datetimeCreated;
    }

    public void setDatetimeCreated(Date datetimeCreated) {
        this.datetimeCreated = datetimeCreated;
    }

    public Date getApplicationDeadlineDate() {
        return applicationDeadlineDate;
    }

    public void setApplicationDeadlineDate(Date applicationDeadlineDate) {
        this.applicationDeadlineDate = applicationDeadlineDate;
    }

    public JobXML getJobId() {
        return jobId;
    }

    public void setJobId(JobXML jobId) {
        this.jobId = jobId;
    }

    @XmlElementWrapper(name = "appplications")
    @XmlElement(name = "application")
    public Set<UserApplyAdXML> getUserApplyAdList() {
        return userApplyAdList;
    }

    public void setUserApplyAdList(Set<UserApplyAdXML> userApplyAdList) {
        this.userApplyAdList = userApplyAdList;
    }
    

    

}
