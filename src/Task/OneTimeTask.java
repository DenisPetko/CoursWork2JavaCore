package Task;

import Excepiton.IncorrectArgumentException;

import java.time.LocalDateTime;

public class OneTimeTask extends Tasks{

    public OneTimeTask(String taskHeading, String taskDescription, LocalDateTime timeTask, TypeOfTask typeOfTask) throws IncorrectArgumentException {
        super(taskHeading, taskDescription, timeTask, typeOfTask);
    }

    @Override
    public LocalDateTime getTaskRepeatable(LocalDateTime dateTime) {
        return null;
    }
}
