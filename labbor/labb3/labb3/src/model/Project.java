package model;

import model.ITaskMatcher.ITaskMatcher;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Project implements Comparable<Project>, Serializable {
    private final String title;
    private final int id;
    private final String description;
    private LocalDate created;
    private static int nextTaskId = 0;
    private final ArrayList<Task> taskList;

    Project (String title, String description, int id){
        this.title = title;
        this.description = description;
        this.id = id;
        this.created = LocalDate.now();

        taskList = new ArrayList<>();
    }

    public String getTitle() {
        return this.title;
    }

    public int getProjectId() {
        return this.id;
    }

    public String getDescription() {
        return this.description;
    }

    /**
     * Returns task with the given id
     * @return taskList
     */
    public Task getTaskById(int id) {
        for (Task task : taskList) {
            if (task.getId() == id) {
                return task;
            }
        }
        return null; // Task does not exist
    }

    /**
     * Returns a list of tasks with the given description
     * @param matcher - matcher to be used
     * @return list of tasks matching the given condition
     */
    public ArrayList<Task> findTasks(ITaskMatcher matcher) {
        ArrayList<Task> result = new ArrayList<>();
        for (Task task : taskList) {
            if (matcher.match(task)){
                result.add(task);
            }
        }
        Collections.sort(result);
        return result;
    }

    public Task addTask(String descr, TaskPrio prio) {
        Task newTask = new Task(descr, prio, nextTaskId);
        taskList.add(newTask);
        nextTaskId++;
        return newTask;
    }

    public boolean removeTask(Task task) {
        return taskList.remove(task);
    }

    /**
     * Returns the state of the project
     * @return the state of the project
     */
    public ProjectState getState() {
        if (taskList.size() == 0) return ProjectState.EMPTY;
        ProjectState state = ProjectState.COMPLETED;
        for (Task task : taskList) {
            if (task.getState() != TaskState.DONE) {
                state = ProjectState.ONGOING;
                break;
            }
        }
        return state;
    }

/**
     * Returns the date of the last update
     * @return the date of the last update
     */
    public LocalDate getLastUpdated() {
        if(taskList.size()==0) return this.created;
        LocalDate lastUpdated = taskList.get(0).getLastUpdate();
        for (Task task: taskList) {
            if (task.getLastUpdate().isAfter(lastUpdated)) {
                lastUpdated = task.getLastUpdate();
            }
        }
        return lastUpdated;
    }

    @Override
    public int compareTo(Project other) {
        return this.title.compareTo(other.getTitle());
    }

    @Override
    public boolean equals(Object other) {
        if (this == other) return true;
        if (other instanceof Project otherProject) {
            return this.title.equals(otherProject.getTitle());
        }
        return false;
    }

    @Override
    public String toString() {
        return String.format(
                "%n+------------------+-------------------------+%n" +
                "| %-16s | %-23s |%n" +
                "+------------------+-------------------------+%n" +
                "| %-16s | %-23s |%n" +
                "| %-16s | %-23s |%n" +
                "| %-16s | %-23s |%n" +
                "| %-16s | %-23s |%n" +
                "| %-16s | %-23d |%n" +
                "+------------------+-------------------------+%n",
                "ID:", this.id,
                "Title:", this.title,
                "Description:", this.description,
                "State:", getState(),
                "Created:", this.created,
                "Number of Tasks:", taskList.size()
        );
    }
}