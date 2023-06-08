package com.company.Admin;
import com.company.Employee.Employee;
import java.util.Scanner;

import static com.company.Admin.Admin.*;

public class AdminController implements AdminServices {

    Project project = new Project();
    Scanner inp_int = new Scanner(System.in);
    Scanner inp_Str = new Scanner(System.in);

    // USER'S FUNCTIONS

    //Function To Add User
    public void addUser() {
        System.out.println("Enter name ");
        String name = inp_Str.nextLine();
        System.out.println("Enter userName ");
        String userName = inp_Str.nextLine();
        System.out.println("Enter Password ");
        String password = inp_Str.nextLine();
        System.out.println("Enter type ");
        String type = inp_Str.nextLine();
        User user = new User(name, password, type,userName);
        users.add((user));

    }
    //function To getUser Info
    public void getUserInfo() {
        System.out.println("Enter user's id to get information about");
        String ID = inp_Str.nextLine();
        for (int i = 0; i < users.size(); i++) {
            if (users.get(i).getId().equals(ID))
                System.out.println(users.get(i).toString());
            }
    }
    public void getUsersInfo(){
        for(int i=0; i< users.size();i++){
            System.out.println(users.get(i).toString());
        }
    }
    //Function To Get Number Of User In the List
    public void getNumberOfUsers() {
        System.out.println("Number Of Users Is " + users.size());
    }
    //Function To Update User from the List
    public void updateUser() {
        System.out.println("Enter User's ID To Update ");
        String ID = inp_Str.nextLine();
        for (int i = 0; i < users.size(); i++) {
            if (users.get(i).getId() .equals(ID)) {
                System.out.println("Enter New Name");
                String name = inp_Str.nextLine();
                users.get(i).setName(name);
                System.out.println("Enter New Password");
                String passWord = inp_Str.nextLine();
                users.get(i).setPassword(passWord);
            }
        }
    }
    //Function To Delete User from the List
    public void deleteUser() {
        int index = -1;
        System.out.println("Enter User's ID To delete Users");
        String ID = inp_Str.nextLine();
        for (int i = 0; i < users.size(); i++) {
            if (users.get(i).getId().equals(ID))
                index = i;
        }
        if(index == -1){
            System.out.println("User not found");
        }
        else {
            users.remove(users.get(index));
            System.out.println("User deleted successfully.");
        }
    }
    //EMPLOYEE S'S FUNCTIONS

    //Function To Add Employee
    public void addEmployee() {
        System.out.println("Enter Employee's UserName ");
        String username = inp_Str.nextLine();
        System.out.println("Enter Employee's password ");
        String password = inp_Str.nextLine();
        System.out.println("Enter Employee Name ");
        String name = inp_Str.nextLine();
        System.out.println("Enter Employee Type");
        String type = inp_Str.nextLine();
        System.out.println("Enter Employee Phone");
        String phone = inp_Str.nextLine();
        System.out.println("Enter Employee Email");
        String email = inp_Str.nextLine();
        Employee employee = new Employee(username, password, name, type, email, phone);
        Employees.add(employee);
    }
    //Function To Get Employee information
    public void getEmployeeInfo() {
        System.out.println("Enter Employee's Id TO GEt Information About");
        String ID = inp_Str.nextLine();

        for (int i = 0; i < Employees.size(); i++) {
            if (Employees.get(i).getId().equals(ID)) {
                System.out.println(Employees.get(i).toString());
            }

        }
    }
    //Function To Get Employee Number
    public void getEmployeeNumber() {
        System.out.println("The Number Of Employees Is : " + Employees.size());
    }
    //Function To Update Employee
    public void updateEmployee() {
        System.out.println("Enter Employee's ID To Update ");
        String ID = inp_Str.nextLine();
        for (int i = 0; i < Employees.size(); i++) {
            if (Employees.get(i).getId().equals(ID)) {
                System.out.println("Enter New Name");
                String name = inp_Str.nextLine();
                Employees.get(i).setName(name);
                System.out.println("Enter New Type");
                String type = inp_Str.nextLine();
                Employees.get(i).setType(type);
                System.out.println("Enter New Phone");
                String phone = inp_Str.nextLine();
                Employees.get(i).setPhone(phone);
                System.out.println("Enter New Email");
                String email = inp_Str.nextLine();
                Employees.get(i).setEmail(email);
                System.out.println("Enter New UserName");
                String userName = inp_Str.nextLine();
                Employees.get(i).setUserName(userName);
                System.out.println("Enter New password");
                String Password = inp_Str.nextLine();
                Employees.get(i).setPassword(Password);
            }
        }
    }
    //Function TO delete Employee
    public void deleteEmployee() {
        int index = -1;
        System.out.println("Enter Employee's ID To delete Employee");
        String ID = inp_Str.nextLine();
        for (int i = 0; i < Employees.size(); i++) {
            if (Employees.get(i).getId().equals(ID))
                index = i;
        }
        if (index == -1) {
            System.out.println("You entered wrong id");
        } else {
            Employees.remove(Employees.get(index));
        }
    }
    public void getEmplyeesInfo(){
        for(int i=0;i< Employees.size();i++){
            System.out.println(Employees.get(i).toString());

            System.out.println();
        }
    }
    // Function TO get Requests
    public void getRequest(){


        for(int i=0; i< Employees.size(); i++){


            System.out.println("The Employee Id : "+Employees.get(i).getId());
            for(int j=0;j<Employees.get(i).getTC().size();j++) {
                System.out.println("Request id: "+Employees.get(i).getTC().get(j).getUniqueID());
                System.out.println("Request date : " + Employees.get(i).getTC().get(j).getMydate());
                System.out.println("Request Type: "+ Employees.get(i).getTC().get(j).getType());
                System.out.println("Request description: "+Employees.get(i).getTC().get(j).getDescription());

                System.out.println("Request statue: "+Employees.get(i).getTC().get(j).getStatue());

                System.out.println("-------------------------------");

            }
            System.out.println("-------------------------------");



        }

        System.out.println("Enter request id you want to approve/disapprove: ");
        String id = inp_Str.nextLine();
        System.out.println("1-Approve");
        System.out.println("2-Disapprove");
        int choice = inp_int.nextInt();

        for(int i=0;i<Employees.size();i++){
            for(int j=0;j<Employees.get(i).getTC().size();j++){
                if(id.equals(Employees.get(i).getTC().get(j).getUniqueID())){

                    if(choice == 1){
                        Employees.get(i).getTC().get(j).setStatue("Approved");
                        System.out.println("Done");
                    }else if (choice == 2 ){

                        Employees.get(i).getTC().get(j).setStatue("Disapproved");
                        System.out.println("Done");
                    }


                }
            }
        }


    }

    // projects functions
    public void addProject() {
        boolean found = false;
        System.out.println("Enter name ");
        String name = inp_Str.nextLine();
        System.out.println("Enter teamLeaderId ");
        String teamLeaderId = inp_Str.nextLine();
        // check if the team leader id exist
        for(int i=0;i< Employees.size();i++){
            if(Employees.get(i).getId().equals(teamLeaderId))
            {
                found = true;
                project = new Project(name, teamLeaderId);
                projects.add((project));
            }
        }
        if(!found){
            System.out.println("You entered team leader id wrong ");
        }



    }
    public void updateProject(){
        System.out.println("Enter Project's ID To Update ");
        String ID = inp_Str.nextLine();
        for (int i = 0; i < projects.size(); i++) {
            if (projects.get(i).getId().equals(ID)) {
                System.out.println("Enter New Name");
                String name = inp_Str.nextLine();
                projects.get(i).setName(name);
                System.out.println("Enter New teamLeader 's Id");
                String teamLeaderId = inp_Str.nextLine();
                projects.get(i).setTeamLeaderId(teamLeaderId);
            }
        }
    }
    public void deleteProject() {
        int index = -1;
        System.out.println("Enter Project's ID To delete The project");
        String ID = inp_Str.nextLine();
        for (int i = 0; i < projects.size(); i++) {
            if (projects.get(i).getId().equals(ID))
                index = i;
        }
        if (index == -1) {
            System.out.println("You entered wrong id");
        } else {
            projects.remove(projects.get(index));
        }
    }
    public void getProjectNumber(){
        System.out.println("The Number Of Project Is : " +projects.size());
    }
    public void getProjectInfo(){
        System.out.println("Enter Project's Id to get information about");
        String ID = inp_Str.nextLine();
        for (int i = 0; i < projects.size(); i++) {
            if (projects.get(i).getId().equals(ID))
                System.out.println(projects.get(i).toString());

            else
                System.out.println("There Is No Project with this Id");

        }
    }
    public void getProjectsInfo(){
        for(int i=0; i<projects.size();i++){
            System.out.println(projects.get(i).toString());
            System.out.println();
        }
    }
    public static int getProjectByID(String id) {
        int index = -1;
        for (int i = 0; i < projects.size(); i++) {
            if (projects.get(i).getId().equals(id)) {
                index = i;
                break;
            }

        }
        return index;
    }
}
