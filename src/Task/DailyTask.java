package Task;

import Excepiton.IncorrectArgumentException;

import java.time.LocalDateTime;

public class DailyTask extends Tasks{

    public DailyTask(String taskHeading, String taskDescription, LocalDateTime timeTask, TypeOfTask typeOfTask) throws IncorrectArgumentException {
        super(taskHeading, taskDescription, timeTask, typeOfTask);
    }

    @Override
    public LocalDateTime getTaskRepeatable(LocalDateTime dateTime) {
        return dateTime.plusDays(1);
    }
}
