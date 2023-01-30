package Task;

import Excepiton.IncorrectArgumentException;

import java.time.LocalDateTime;

public class YearlyTask extends Tasks {

    public YearlyTask(String taskHeading, String taskDescription, LocalDateTime timeTask, TypeOfTask typeOfTask) throws IncorrectArgumentException {
        super(taskHeading, taskDescription, timeTask, typeOfTask);
    }

    @Override
    public LocalDateTime getTaskRepeatable(LocalDateTime dateTime) {
        return dateTime.plusYears(1);
    }
}
