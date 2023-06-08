package com.company.Employee;

import java.util.*;

public class TimeCard {


    private Date myDate= new Date();
    private String statue;
    private String description;
    private String type;
    String uniqueID = UUID.randomUUID().toString();


    public TimeCard(){

    }

    public TimeCard(String id,Date myDate, String statue, String description, String type) {
        this.uniqueID=id;
        this.myDate = myDate;
        this.statue = statue;
        this.description = description;
        this.type = type;
    }

    public String getUniqueID() {
        return uniqueID;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }



    public Date getMydate() {
        return myDate;
    }

    public void setMydate(Date mydate) {
        this.myDate = mydate;
    }


    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
    public String getStatue() {
        return statue;
    }

    public  void setStatue(String statue) {
        this.statue = statue;
    }





}
