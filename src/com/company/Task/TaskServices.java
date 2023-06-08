package com.company.Task;

public interface TaskServices  {

    public void addTask(String projectId, String name, String teamLeaderId);
    public void updateTask(String project_id,String task_id);
    public void calendar(String projectId);
    public void taskLog(String project_id, String Task_id);
    public void deleteTask(String project_id,String task_id);
    public void getTaskInfo(String project_id,String task_id);

}
