/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelxml;

import model.*;
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

public class ToolsAndTechnologyXML implements Serializable {

    private Integer toolsAndTechnologyId;
    private String description;

    public ToolsAndTechnologyXML() {
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

    
}
