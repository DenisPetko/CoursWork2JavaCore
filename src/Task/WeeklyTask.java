package Task;

import Excepiton.IncorrectArgumentException;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class WeeklyTask extends Tasks {

    public WeeklyTask(String taskHeading, String taskDescription, LocalDateTime timeTask, TypeOfTask typeOfTask) throws IncorrectArgumentException {
        super(taskHeading, taskDescription, timeTask, typeOfTask);
    }

    @Override
    public boolean appersIn(LocalDate localDate) {
        return (localDate.isEqual(getTimeTask().toLocalDate()) || localDate.isAfter(getTimeTask().toLocalDate())) && localDate.getDayOfWeek()==getTimeTask().toLocalDate().getDayOfWeek();
    }

}
