/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelxml;

import model.*;
import java.io.Serializable;
import java.util.Date;

/**
 *
 * @author user
 */
public class ProfessionalExperienceXML implements Serializable {

    private Integer professionalExperienceId;
    private Date dateStarted;
    private Date dateEnded;
    private JobXML jobId;

    public Integer getProfessionalExperienceId() {
        return professionalExperienceId;
    }

    public void setProfessionalExperienceId(Integer professionalExperienceId) {
        this.professionalExperienceId = professionalExperienceId;
    }

    public Date getDateStarted() {
        return dateStarted;
    }

    public void setDateStarted(Date dateStarted) {
        this.dateStarted = dateStarted;
    }

    public Date getDateEnded() {
        return dateEnded;
    }

    public void setDateEnded(Date dateEnded) {
        this.dateEnded = dateEnded;
    }

    public JobXML getJobId() {
        return jobId;
    }

    public void setJobId(JobXML jobId) {
        this.jobId = jobId;
    }



    
}
