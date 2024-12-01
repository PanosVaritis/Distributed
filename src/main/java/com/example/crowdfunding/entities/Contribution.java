package com.example.crowdfunding.entities;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
public class Contribution {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column
    private Integer Id;

    @Column
    private double amount;

    @Column
    private LocalDate date;

    @ManyToOne
    @JoinColumn(name = "project_id")
    private Project project;

    @ManyToOne
    @JoinColumn(name = "supporter_id")
    private Supporter supporter;


    public Contribution(Integer id, double amount, LocalDate date) {
        Id = id;
        this.amount = amount;
        this.date = date;
    }

    public Contribution(double amount, LocalDate date) {
        this.amount = amount;
        this.date = date;
    }

    public Contribution() {}

    public Integer getId() {
        return Id;
    }

    public void setId(Integer id) {
        Id = id;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public Project getProject() {
        return project;
    }

    public void setProject(Project project) {
        this.project = project;
    }

    public Supporter getSupporter() {
        return supporter;
    }

    public void setSupporter(Supporter supporter) {
        this.supporter = supporter;
    }
}
