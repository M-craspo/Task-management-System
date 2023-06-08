package com.company.Admin;

import com.company.Employee.Employee;

import java.util.*;

public class Admin extends User {

    public AdminServices adminController = new AdminController();

    public static final ArrayList<User> users = new ArrayList<>();
    public static final ArrayList<Employee> Employees = new ArrayList<>();
    public static final ArrayList<Project> projects = new ArrayList<>();

    public Admin() {
    }

    public Admin(String name, String password, String type, String userName) {
        super(name, password, type, userName);
    }



}


