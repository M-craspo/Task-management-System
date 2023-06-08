package com.company.Employee;
import com.company.Admin.User;
import com.company.Task.TaskController;
import com.company.Task.TaskServices;

import java.util.ArrayList;

public class Employee extends User {

    private String employeeType;
    private String email;
    private String phone;
    static ArrayList<TimeCard> TC =new ArrayList<>();
    public TaskServices taskController = new TaskController();


    public ArrayList<TimeCard> getTC() {
        return TC;
    }

    public  void setTC(TimeCard TC) {
        this.TC.add(TC);
    }


    public String getEmployeeType() {
        return employeeType;
    }

    public void setEmployeeType(String type) {
        this.employeeType = type;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }



    public Employee(){

    }

    public Employee(String username ,String password,String name,String employeeType,String email,String phone){
        super.setUserName(username);
        super.setPassword(password);
        super.setName(name);
        this.employeeType=employeeType;
        this.email=email;
        this.phone=phone;
        super.setType("employee");

    }



    public String toString(){
        return "name : "+getName()
                +"\nuserName: "+ getUserName()
                +"\npassword: " + getPassword()
                +"\nType : "+getEmployeeType()
                +"\nID : "+getId()
                +"\nEmail : "+getEmail()
                +"\nphone : "+getPhone();
    }


}
