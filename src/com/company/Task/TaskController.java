package com.company.Task;
import java.util.Date;
import java.util.Scanner;
import static com.company.Admin.Admin.*;
import static com.company.Admin.AdminController.getProjectByID;

public class TaskController implements TaskServices{

    Scanner inp_int = new Scanner(System.in);
    Scanner inp_str = new Scanner(System.in);
    Task task = new Task();

    public void addTask(String projectId, String name, String teamLeaderId) {

        System.out.println("Enter The Task Phase");
        String takePhase = inp_str.nextLine();
        System.out.println("Enter The Estimation Hour");
        double estimationHour = inp_int.nextDouble();
        System.out.println("Enter The Priority");
        String priority = inp_str.nextLine();
        System.out.println("Enter Task's creatorName");
        String creatorName = inp_str.nextLine();
        System.out.println("Enter Task's Title");
        String title = inp_str.nextLine();
        System.out.println("Enter Task's description");
        String description = inp_str.nextLine();
        Date StartDate = new Date();
        System.out.println("Enter The DeadLine For Task");
        String EndTime = inp_str.nextLine();
        boolean flag = true;
        boolean found = false;
        while (flag) {
            System.out.println("Enter employee id");
            String employeeID = inp_str.nextLine();

            for (int i = 0; i < Employees.size(); i++) {
                if (Employees.get(i).getId().equals(employeeID)) {
                    task = new Task(name, teamLeaderId, title, description, creatorName, StartDate, EndTime, employeeID, takePhase, priority, estimationHour);
                    projects.get(getProjectByID(projectId)).setTasks(task);
                    flag = false;
                    found = true;

                }

            }
            if (!found) {
                System.out.println("Employee id is not found");
            }
            System.out.println("Task added successfully");
        }
    }
    //function To updateTasks   //team leader
    public void updateTask(String project_id, String task_id) {
        for (int i = 0; i < projects.get(getProjectByID(project_id)).getTasksSize(); i++) {
            if (projects.get(getProjectByID(project_id)).getTasks().get(i).getCode().equals( task_id)) {
                System.out.println("Enter New Creator Name");
                String creatorName = inp_str.next();
                projects.get(getProjectByID(project_id)).getTasks().get(i).setCreatorName(creatorName);
                System.out.println("Enter New Title");
                String title = inp_str.nextLine();
                projects.get(getProjectByID(project_id)).getTasks().get(i).setTitle(title);
                System.out.println("Enter New Description");
                String description = inp_str.nextLine();
                projects.get(getProjectByID(project_id)).getTasks().get(i).setDescription(description);
                System.out.println("Enter New DeadLine");
                String deadLine = inp_str.nextLine();
                projects.get(getProjectByID(project_id)).getTasks().get(i).setEndDate(deadLine);
                System.out.println("Enter employee id");
                String employeeID = inp_str.nextLine();
                projects.get(getProjectByID(project_id)).getTasks().get(i).setEmployeeId(employeeID);
            } else
                System.out.println("NO Tasks Has This Code ");
        }
    }
    public void calendar(String projectId) {

        for (int i = 0; i < projects.get(getProjectByID(projectId)).getTasksSize(); i++) {

            System.out.println("Task code: " + projects.get(getProjectByID(projectId)).getTasks().get(i).getCode());
            System.out.println("The Employee Id Works In The Task : " + projects.get(getProjectByID(projectId)).getTasks().get(i).getEmployeeId());
            System.out.println("The Title : " + projects.get(getProjectByID(projectId)).getTasks().get(i).getTitle());
            System.out.println("The Statue " + projects.get(getProjectByID(projectId)).getTasks().get(i).getTaskPhase());
            System.out.println("-------------------------------");


        }
        if(projects.get(getProjectByID(projectId)).getTasksSize() == 0){
            System.out.println("There is no tasks");
        }
    }
    public void taskLog(String project_id, String Task_id) {
        for (int i = 0; i < projects.get(getProjectByID(project_id)).getTasksSize(); i++) {
            System.out.println(i);
            if (projects.get(getProjectByID(project_id)).getTasks().get(i).getCode().equals(Task_id)) {
                Date d1 = projects.get(getProjectByID(project_id)).getTasks().get(i).getStartDate();
                Date d2 = new Date();
                long diff = d2.getTime() - d1.getTime();
                System.out.println("The Time's Spent Is : " + (diff / (1000 * 60 * 60 * 24)) + " Days " + (diff / (1000 * 60 * 60)) + " Hour " + (diff / (1000 * 60)) + " Min "+ (diff / (1000) + "sec"));

            }
        }

    }
    //Function To delete Task
    public void deleteTask(String project_id, String task_id) {
        int index = 0;

        for (int i = 0; i < projects.get(getProjectByID(project_id)).getTasksSize(); i++) {
            {
                if (projects.get(getProjectByID(project_id)).getTasks().get(i).getCode().equals( task_id))
                    index = i;
            }
            projects.get(getProjectByID(project_id)).removeTask(task_id);
        }

    }
    public void getTaskInfo(String project_id, String task_id) {

        for (int i = 0; i < projects.get(getProjectByID(project_id)).getTasksSize(); i++) {
            System.out.println(projects.get(getProjectByID(project_id)).getTaskById(task_id));


        }


    }
}