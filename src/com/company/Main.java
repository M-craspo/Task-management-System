package com.company;
import com.company.Admin.Admin;
import com.company.Employee.*;
import com.company.Admin.User;
import com.company.Task.*;
import java.util.*;
import static com.company.Admin.Admin.*;
import static com.company.Admin.AdminController.getProjectByID;

public class Main {

    public static void main(String[] args) {

        User user = new Admin("mohamed", "123", "admin", "mohamed");
        Employee employee= new Employee("1","1","1","teamLeader","1","1");
        Employee employee2= new Employee("2","2","2","normal","1","1");


        users.add(user);
        users.add(employee);
        users.add(employee2);

        Employees.add(employee);
        Employees.add(employee2);

        Scanner inp_str = new Scanner(System.in);
        int choice = 0;

        boolean found = false;
        while(!found || choice == 0) {
            found = false;
            System.out.println("Enter userName");
            String userName = inp_str.nextLine();
            System.out.println("Enter Password");
            String passWord = inp_str.nextLine();


            for (int i = 0; i < users.size(); i++) {
                if (userName.equals(users.get(i).getUserName()) && passWord.equals(users.get(i).getPassword()) && users.get(i).getType().equals("admin")) {
                    choice = loginAdmin((Admin)users.get(i));
                    found = true;
                } else if (userName.equals(users.get(i).getUserName()) && passWord.equals(users.get(i).getPassword()) && users.get(i).getType().equals("employee")) {
                    choice = loginEmployee((Employee) users.get(i));
                    found = true;


                }
            }
            if (!found) {
                System.out.println("You entered wrong userName or password");
            }

        }

    }

    //Log in by Admin
    public static int loginAdmin(Admin admin){
        Scanner inp_int = new Scanner(System.in);
        Scanner inp_str = new Scanner(System.in);
        int c = -1;
        int op =-1;
        do {
            System.out.println("1_User's List");
            System.out.println("2_Employee's List");
            System.out.println("3_Project's List");
            System.out.println("4_Task phases");
            System.out.println("5_logout ");
            c = inp_int.nextInt();
            switch (c) {
                case 1 -> {
                    System.out.println("1_Add User");
                    System.out.println("2_Update User");
                    System.out.println("3_delete User");
                    System.out.println("4_Get Number Of Users");
                    System.out.println("5_Get User Information");
                    System.out.println("6_Get all users information");
                    int n = inp_int.nextInt();
                    switch (n) {
                        case 1 -> admin.adminController.addUser();
                        case 2 -> admin.adminController.updateUser();
                        case 3 -> admin.adminController.deleteUser();
                        case 4 -> admin.adminController.getNumberOfUsers();
                        case 5 -> admin.adminController.getUserInfo();
                        case 6->  admin.adminController.getUsersInfo();
                    }
                }
                case 2 -> {
                    System.out.println("1_Add Employee");
                    System.out.println("2_Update Employee");
                    System.out.println("3_delete Employee");
                    System.out.println("4_Get Number Of Employee");
                    System.out.println("5_Get Employee Information");
                    System.out.println("6_Get all Employees Information" );
                    System.out.println("7_Show Requests And Attendances");


                    int n = inp_int.nextInt();
                    switch (n) {
                        case 1 -> admin.adminController.addEmployee();
                        case 2 -> admin.adminController.updateEmployee();
                        case 3 -> admin.adminController.deleteEmployee();
                        case 4 -> admin.adminController.getEmployeeNumber();
                        case 5 -> admin.adminController.getEmployeeInfo();
                        case 6 -> admin.adminController.getEmplyeesInfo();
                        case 7 -> admin.adminController.getRequest();
                    }
                }
                case 3 -> {
                    System.out.println("1_Add Project");
                    System.out.println("2_Update Project");
                    System.out.println("3_delete Project");
                    System.out.println("4_Get Number Of Project");
                    System.out.println("5_Get Project Information");
                    System.out.println("6_Get all projects information");
                    int num = inp_int.nextInt();
                    switch (num) {
                        case 1 -> admin.adminController.addProject();
                        case 2 -> admin.adminController.updateProject();
                        case 3 -> admin.adminController.deleteProject();
                        case 4 -> admin.adminController.getProjectNumber();
                        case 5 -> admin.adminController.getProjectInfo();
                        case 6 -> admin.adminController.getProjectsInfo();
                    }
                }
                case 4-> {
                    for(int i=0;i<projects.size();i++){
                        System.out.println("Project number: " + (i+1));
                        for(int j=0;j<projects.get(i).getTasksSize();j++){
                            System.out.println(projects.get(i).getTasks().get(j).getId());
                            System.out.println(projects.get(i).getTasks().get(j).getTaskPhase());
                        }
                    }
                    System.out.println("Enter task id u want to change the phase: ");
                    String id=inp_str.nextLine();
                    System.out.println("Enter new task phase: ");
                    String taskPhase=inp_str.nextLine();
                    for(int i=0;i<projects.size();i++){
                        for(int j=0;j<projects.get(i).getTasksSize();j++){
                            if(projects.get(i).getTasks().get(j).getId().equals(id)){
                                projects.get(i).getTasks().get(j).setTaskPhase(taskPhase);
                            }
                        }
                    }

                }
                case 5 -> {
                    return 0;
                }

            }
        }while(op!=0);
        return 1;
    }

    //Log in by Employee
    public static int loginEmployee(Employee employee) {
        Scanner inp_int = new Scanner(System.in);
        Scanner inp_str = new Scanner(System.in);
        boolean found = false;

        System.out.println("1_Absence Request ");
        System.out.println("2_Attendance ");
        System.out.println("3_Leave Request ");
        System.out.println("4_View requests statues: ");
        System.out.println("5_Logout");

        int m=inp_int.nextInt();
        switch (m)
        {
            case 1 ->{
                TimeCard timecard =new TimeCard();
                timecard.setStatue("pending");
                timecard.setType("Absence");
                System.out.println("Enter Description");
                String Des=inp_str.nextLine();
                timecard.setDescription(Des);

                System.out.println("Done");
            }
            case 2 ->{
                TimeCard timecard =new TimeCard();
                timecard.setStatue("pending");
                timecard.setType("Record");
                employee.setTC(timecard);
                System.out.println("Done");

            }

            case 3 ->{
                TimeCard timecard =new TimeCard();
                timecard.setStatue("pending");
                timecard.setType("Leave");
                System.out.println("Enter Description");
                String Des=inp_str.nextLine();
                timecard.setDescription(Des);
                employee.setTC(timecard);
                System.out.println("Your Req Done");
            }
            case 4->{
                for (int j=0;j<employee.getTC().size();j++){
                    if(employee.getTC().size() == 0){
                        System.out.println("You have no requests");
                    }
                    System.out.println(employee.getTC().get(j).getUniqueID());
                    System.out.println(employee.getTC().get(j).getType());
                    System.out.println(employee.getTC().get(j).getDescription());
                    System.out.println(employee.getTC().get(j).getStatue());
                    System.out.println("---------------------------------");
                }

            }
            case 5-> {
                return 0;
            }
        }

        if (employee.getEmployeeType().equalsIgnoreCase("teamLeader")) {

            System.out.println("Projects: ");
            for (int j = 0; j < projects.size(); j++) {

                if (projects.get(j).getTeamLeaderId().equals(employee.getId())) {
                    System.out.println(projects.get(j).getId() + " _ " + projects.get(j).getName());
                    found = true;
                }
            }
            if(!found){
                System.out.println("You have no projects contact admin to add new one");
            }else {
                int loop = -1;
                do {
                    System.out.println("Enter project id: ");
                    String project_id = inp_str.nextLine();
                    for (int j = 0; j < projects.size(); j++) {
                        if (projects.get(j).getId().equals(project_id)) {
                            System.out.println("a_Show Calender");
                            System.out.println("b_Task Log ");
                            System.out.println("c_Task's Page");
                            System.out.println("d_Logout");
                            String op = inp_str.next();
                            switch (op) {
                                case "a":
                                    employee.taskController.calendar(project_id);
                                    break;
                                case "b":
                                    System.out.println("Enter Task's Id");
                                    String task_id = inp_str.next();
                                    employee.taskController.taskLog(project_id, task_id);
                                    break;

                                case "c": {
                                    System.out.println("1_Add Task");
                                    System.out.println("2_update Task");
                                    System.out.println("3_Delete Task");
                                    System.out.println("4_Get Information About Task");
                                    // evaluate , resign task
                                    int n = inp_int.nextInt();
                                    switch (n) {
                                        case 1 -> employee.taskController.addTask(project_id, projects.get(getProjectByID(project_id)).getName(), projects.get(getProjectByID(project_id)).getTeamLeaderId());

                                        case 2 -> {
                                            System.out.println("Enter Task's Id");
                                            task_id = inp_str.next();
                                            employee.taskController.updateTask(project_id, task_id);
                                        }

                                        case 3 -> {
                                            System.out.println("Enter Task's Id");
                                            task_id = inp_str.next();
                                            employee.taskController.deleteTask(project_id, task_id);
                                        }

                                        case 4 -> {
                                            System.out.println("Enter Task's Id");
                                            task_id = inp_str.next();
                                            employee.taskController.getTaskInfo(project_id, task_id);

                                        }
                                    }
                                }
                                case "d" :{
                                    loop = 0;
                                    break;
                                }
                            }
                        }
                    }
                }while(loop!=0);
            }
            return 0;
        }else if (employee.getEmployeeType().equalsIgnoreCase("normal")){
            //only show his tasks'
            // employee module ...
            // projects works on ' employee -> projects

            System.out.println("1_show my tasks");

            int choice = inp_int.nextInt();
            switch (choice){
                case 1->{
                    for(int k=0;k<projects.size();k++){
                        for(int j=0;j<projects.get(k).getTasksSize();j++){
                            if(projects.get(k).getTasks().get(j).getEmployeeId().equals(employee.getId())){
                                System.out.println(projects.get(k).getTasks().get(j).toString());

                            }
                        }
                    }
                }

            }
            return 0;


        }
        return 1;
    }


}









