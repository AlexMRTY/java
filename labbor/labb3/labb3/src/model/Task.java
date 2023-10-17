package model;

import java.io.Serializable;
import java.time.LocalDate;

public class Task implements Comparable<Task>, Serializable{
    private final String description;
    private final int id;
    private String takenBy;
    private TaskState state;
    private LocalDate lastUpdate;
    private TaskPrio prio;

    /**
     * Constructor for a task
     *
     * @param descr
     * @param prio
     * @param id
     */
    Task(String descr, TaskPrio prio, int id) {
        this.description = descr;
        this.prio = prio;
        this.id = id;
        this.lastUpdate = LocalDate.now();
    }

    public int getId() {
        return this.id;
    }

    public String getDescription() {
        return description;
    }

    public TaskPrio getPrio() {
        final TaskPrio copy = prio;
        return copy;
    }

    public String getTakenBy() {
        return takenBy;
    }

    public TaskState getState() {
        return state;
    }

    /**
     * Assigns a user to the task
     * @param takenBy - the user that takes the task
     */
    public void setTakenBy(String takenBy) {
        if (takenBy == null) { throw new IllegalStateException("This task is already taken");}
        this.takenBy = takenBy;
        this.lastUpdate = LocalDate.now();
    }

    public void setState(TaskState state) {
        this.state = state;
        this.lastUpdate = LocalDate.now();
    }

    public void setPrio(TaskPrio prio) {
        this.prio = prio;
        this.lastUpdate = LocalDate.now();
    }

    public LocalDate getLastUpdate() {
        return lastUpdate;
    }

    @Override
    public int compareTo(Task other) {
        int result = this.prio.ordinal() - other.getPrio().ordinal();
        if(result == 0) {
            result = this.description.compareTo(other.getDescription());
        }
        return result;
    }

    @Override
    public boolean equals(Object other) {
        if (this == other) return true;
        if (other instanceof Task otherTask) {
            boolean r = this.prio == otherTask.getPrio();
            if (r) r = this.description.equals(otherTask.getDescription());
            return r;
        }
        return false;
    }

    @Override
    public String toString() {

        return String.format(
                "%n+----------------+-------------------------+%n" +
                "| %-14s | %-23s |%n" +
                "+----------------+-------------------------+%n" +
                "| %-14s | %-23s |%n" +
                "| %-14s | %-23s |%n" +
                "| %-14s | %-23s |%n" +
                "| %-14s | %-23s |%n" +
                "| %-14s | %-23s |%n" +
                "+----------------+-------------------------+%n",
                "ID:", this.id,
                "Taken By:", this.takenBy,
                "Description:", this.description,
                "Priority:", this.prio,
                "State:", this.state,
                "Last Updated:", this.lastUpdate
        );
    }
}
