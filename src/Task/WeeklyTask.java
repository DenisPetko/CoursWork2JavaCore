package Task;

import Excepiton.IncorrectArgumentException;

import java.time.LocalDateTime;

public class WeeklyTask extends Tasks {

    public WeeklyTask(String taskHeading, String taskDescription, LocalDateTime timeTask, TypeOfTask typeOfTask) throws IncorrectArgumentException {
        super(taskHeading, taskDescription, timeTask, typeOfTask);
    }

    @Override
    public LocalDateTime getTaskRepeatable(LocalDateTime dateTime) {
        return dateTime.plusWeeks(1);
    }
}
