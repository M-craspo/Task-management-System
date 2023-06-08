package com.company.Admin;

import com.company.Task.Task;

import java.util.ArrayList;
import java.util.UUID;

public class Project {


    private String name;
    String id = UUID.randomUUID().toString();
    String teamLeaderId = UUID.randomUUID().toString();

    public ArrayList<Task> getTasks() {
        return Tasks;
    }
    private  ArrayList<Task> Tasks = new ArrayList<>();

    public void setTasks(Task task) {
        this.Tasks.add(task);
    }
    public int getTasksSize(){
        return this.Tasks.size();

    }
    public int getTaskById(String id){
        int index = -1;
        for(int i=0; i<Tasks.size(); i++){
            System.out.println(i);
            if(Tasks.get(i).getId().equals(id) ){
                index = i;

                break;
            }
        }


        return index;

    }

    public Project(){

    }
    public Project(String name, String teamLeaderId) {
        this.name = name;
        this.teamLeaderId = teamLeaderId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        id = id;
    }

    public String getTeamLeaderId() {
        return teamLeaderId;
    }

    public void setTeamLeaderId(String teamLeaderId) {
        this.teamLeaderId = teamLeaderId;
    }

    public String toString(){
        return "Name : "+getName()
                +"\nId : "+getId()
                +"\nTeam Leader : "+getTeamLeaderId();
    }

    public void removeTask(String task_id)
    {
        Tasks.remove(task_id);
    }
}
