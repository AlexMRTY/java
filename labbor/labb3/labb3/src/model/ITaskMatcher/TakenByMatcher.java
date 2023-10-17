package model.ITaskMatcher;

import model.Task;

import java.util.Objects;

public class TakenByMatcher implements ITaskMatcher{

    private final String takenBy;

    public TakenByMatcher(String takenBy) {
        this.takenBy = takenBy;
    }
    @Override
    public boolean match(Task task) {
        return this.takenBy.toLowerCase().contains(task.getTakenBy().toLowerCase());
    }
}
