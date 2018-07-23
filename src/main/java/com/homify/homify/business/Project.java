package com.homify.homify.business;


import javax.persistence.*;

@Entity
@Table(name="PROJECT")
public class Project {

    @Column(name = "HEADER")
    private Long projectHeader;
    @Column(name = "TITLE")
    private String title;
    @Column(name = "DESCRIPTION")
    private String description;
    @Column(name = "DURATION")
    private String duration;
    @Column(name = "OWNER")
    private Professional owner;
    @Column(name = "TYPE")
    private String type;

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    public Long getProjectHeader() {
        return projectHeader;
    }

    public void setProjectHeader(Long header) {
        this.projectHeader = header;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }


    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @ManyToOne
    @JoinColumn(name = "header")
    public Professional getOwner() {
        return owner;
    }

    public void setOwner(Professional owner) {
        this.owner = owner;
    }

}
