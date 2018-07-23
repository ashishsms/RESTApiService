package com.homify.homify.business;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;

@Entity
@Table(name="PROFESSIONAL")
public class Professional {

    @Column(name = "HEADER")
    private Long header;
    @Column(name = "USER_NAME")
    private String userName;
    @Column(name = "FIRST_NAME")
    private String firstName;
    @Column(name = "LAST_NAME")
    private String lastName;
    @Column(name = "COMPANY_NAME")
    private String companyName;
    @Column(name = "PHONE")
    private String phone;
    @Column(name = "EMAIL")
    private String email;
    @Column(name = "WEBSITE")
    private String website;
    @Column(name = "CITY")
    private String city;
    @Column(name = "COUNTRY")
    private String country;
    @Column(name = "LATITUDE")
    private String latitude;
    @Column(name = "LONGITUDE")
    private String longitude;
    @Column(name = "UPDATE_DATE")
    private Date updateDate;
    @Column(name = "TYPE")
    private String type;
    @Column(name = "PASSWORD")
    private String password;
    @Column(name = "PROJECT")
    private Set<Project> project;

    public Professional(){

    }

    public Professional(Long header,String userName, String firstName, String lastName, String companyName, String phone, String email, String website, String city, String country, String latitude, String longitude, Date updateDate, String type) {
      // this.header = header;
        this.userName = userName;
        this.firstName = firstName;
        this.lastName = lastName;
        this.companyName = companyName;
        this.phone = phone;
        this.email = email;
        this.website = website;
        this.city = city;
        this.country = country;
        this.latitude = latitude;
        this.longitude = longitude;
        this.updateDate = updateDate;
        this.type = type;
    }

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    public Long getHeader() {
        return header;
    }

    public void setHeader(Long header) {
        this.header = header;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getWebsite() {
        return website;
    }

    public void setWebsite(String website) {
        this.website = website;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getLatitude() {
        return latitude;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }

    public String getLongitude() {
        return longitude;
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }

    public Date getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(Date updateDate) {
        this.updateDate = updateDate;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @OneToMany(mappedBy = "owner", cascade = CascadeType.ALL)
    public Set<Project> getProject() {
        return project;
    }

    public void setProject(Set<Project> project) {
        this.project = project;
    }

    @Override
    public String toString() {
        return "Professional{" + "firstName='" + firstName +  "lastName='" + lastName +'\'' + ", userName='" + userName + '\'' + ", companyName='" + companyName + '\''
                +", phone='" + phone + '\''  + ", email='" + email + '\'' +", website='" + website + '\'' +", city='" + city + '\'' +", country='" + country + '\'' + '}';
    }

}
