package com.company.Task;


import com.company.Admin.Project;

import java.util.*;

public class Task extends Project {
    String code = UUID.randomUUID().toString();
    private String title;
    private String description;
    private String creatorName;
    private Date StartDate;
    private String EndDate;
    private String employeeId;
    private String taskPhase;
    private String priority;
    private Double estimationHour;


    public String getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(String employeeId) {
        this.employeeId = employeeId;
    }

    public String getTaskPhase() {
        return taskPhase;
    }

    public void setTaskPhase(String taskPhase) {
        this.taskPhase = taskPhase;
    }

    public String getPriority() {
        return priority;
    }

    public void setPriority(String priority) {
        this.priority = priority;
    }

    public double getEstimationHour() {
        return estimationHour;
    }

    public void setEstimationHour(double estimationHour) {
        this.estimationHour = estimationHour;
    }


    public Task(){
    }

    public Task(String name,String teamLeaderId,String title,String description,String creatorName,Date startDate,String EndDate,String employeeId,String takePhase,String priority,double estimationHour){
        super.setName(name);
        super.setTeamLeaderId(teamLeaderId);
        this.taskPhase=takePhase;
        this.priority=priority;
        this.title=title;
        this.description=description;
        this.creatorName=creatorName;
        this.StartDate=new Date();
        this.EndDate=EndDate;
        this.employeeId=employeeId;
        this.taskPhase=takePhase;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
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

    public String getCreatorName() {
        return creatorName;
    }

    public void setCreatorName(String creatorName) {
        this.creatorName = creatorName;
    }

    public Date getStartDate() {
        return StartDate;
    }

    public String getEndDate() {
        return EndDate;
    }

    public void setEndDate(String endDate) {
        EndDate = endDate;
    }
    public String toString(){
        return "Code : "+getCode()
                +"\nCreatorName : "+getCreatorName()
                +"\nTitle : "+getTitle()
                +"\nDescription : "+getDescription()
                +"\nTask phase: "+ getTaskPhase()
                +"\nStartDate : "+getStartDate()
                +"\nDeadLine : "+getEndDate();

    }


    }




