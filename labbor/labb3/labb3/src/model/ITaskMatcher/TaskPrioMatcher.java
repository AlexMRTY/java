package model.ITaskMatcher;

import model.Task;
import model.TaskPrio;

public class TaskPrioMatcher implements ITaskMatcher{
    private final TaskPrio prio;

    public TaskPrioMatcher(TaskPrio prio){
        this.prio = prio;
    }

    @Override
    public boolean match(Task task) {
        return task.getPrio() == this.prio;
    }
}
