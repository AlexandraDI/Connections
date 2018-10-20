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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Table(name = "location")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Location.findAll", query = "SELECT l FROM Location l")
    , @NamedQuery(name = "Location.findByLocationId", query = "SELECT l FROM Location l WHERE l.locationId = :locationId")
    , @NamedQuery(name = "Location.findByStreet", query = "SELECT l FROM Location l WHERE l.street = :street")
    , @NamedQuery(name = "Location.findByNumber", query = "SELECT l FROM Location l WHERE l.number = :number")
    , @NamedQuery(name = "Location.findByPostcode", query = "SELECT l FROM Location l WHERE l.postcode = :postcode")
    , @NamedQuery(name = "Location.findByOtherDetails", query = "SELECT l FROM Location l WHERE l.otherDetails = :otherDetails")})
public class Location implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "location_id")
    private Integer locationId;
    @Column(name = "street")
    private String street;
    @Column(name = "number")
    private Integer number;
    @Column(name = "postcode")
    private Integer postcode;
    @Column(name = "other_details")
    private String otherDetails;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "locationId")
    private List<School> schoolList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "locationId")
    private List<Company> companyList;
    @JoinColumn(name = "city_id", referencedColumnName = "city_id")
    @ManyToOne(optional = false)
    private City cityId;
    @OneToMany(mappedBy = "birthplace")
    private List<User> userList;
    @OneToMany(mappedBy = "curentLocation")
    private List<User> userList1;

    public Location() {
    }

    public Location(Integer locationId) {
        this.locationId = locationId;
    }

    public Integer getLocationId() {
        return locationId;
    }

    public void setLocationId(Integer locationId) {
        this.locationId = locationId;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public Integer getPostcode() {
        return postcode;
    }

    public void setPostcode(Integer postcode) {
        this.postcode = postcode;
    }

    public String getOtherDetails() {
        return otherDetails;
    }

    public void setOtherDetails(String otherDetails) {
        this.otherDetails = otherDetails;
    }

    @XmlTransient
    public List<School> getSchoolList() {
        return schoolList;
    }

    public void setSchoolList(List<School> schoolList) {
        this.schoolList = schoolList;
    }

    @XmlTransient
    public List<Company> getCompanyList() {
        return companyList;
    }

    public void setCompanyList(List<Company> companyList) {
        this.companyList = companyList;
    }

    public City getCityId() {
        return cityId;
    }

    public void setCityId(City cityId) {
        this.cityId = cityId;
    }

    @XmlTransient
    public List<User> getUserList() {
        return userList;
    }

    public void setUserList(List<User> userList) {
        this.userList = userList;
    }

    @XmlTransient
    public List<User> getUserList1() {
        return userList1;
    }

    public void setUserList1(List<User> userList1) {
        this.userList1 = userList1;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (locationId != null ? locationId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Location)) {
            return false;
        }
        Location other = (Location) object;
        if ((this.locationId == null && other.locationId != null) || (this.locationId != null && !this.locationId.equals(other.locationId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.Location[ locationId=" + locationId + " ]";
    }
    
}
