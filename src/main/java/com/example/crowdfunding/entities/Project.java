package com.example.crowdfunding.entities;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class Project {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column
    private Integer id;

    @Column
    private String title;

    @Column
    private String description;

    @Column
    private double requiredFunding;

    @Column
    private double totalFunding;

    @Column
    private boolean status;
    //True if the project is approved by the admin, false if the project has yet to be approved

    @ManyToMany(cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH})
    @JoinTable(
            name = "supporter_student",
            joinColumns = @JoinColumn(name = "project_id"),
            inverseJoinColumns = @JoinColumn(name = "supporter_id"),
            uniqueConstraints = @UniqueConstraint(columnNames = {"project_id", "supporter_id"})

    )
    private List<Supporter> supporters;
//
//    @ManyToOne
//    @JoinColumn(name = "creator_id")
//    public Creator creator;

    public Project(Integer id, String title, String description, double requiredFunding) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.requiredFunding = requiredFunding;
        this.totalFunding = 0;
        this.status = false;
    }

    public Project (String title, String description, double requiredFunding){
        this.description = description;
        this.title = title;
        this.requiredFunding = requiredFunding;
        this.totalFunding = 0;
        this.status = false;
    }

    public Project(){
        this.status = false;
        this.totalFunding = 0;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    public double getRequiredFunding() {
        return requiredFunding;
    }

    public void setRequiredFunding(double requiredFunding) {
        this.requiredFunding = requiredFunding;
    }

    public double getTotalFunding() {
        return totalFunding;
    }

    public void setTotalFunding(double totalFunding) {
        this.totalFunding = totalFunding;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public List<Supporter> getSupporters() {
        return supporters;
    }

    public void setSupporters(List<Supporter> supporters) {
        this.supporters = supporters;
    }

    @Override
    public String toString() {
        return "Project{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", requiredFunding=" + requiredFunding +
                ", totalFunding=" + totalFunding +
                ", status=" + status +
                '}';
    }
}
