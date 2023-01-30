package Task;

import Excepiton.IncorrectArgumentException;
import Interfaces.Repeatable;

import java.time.LocalDateTime;
import java.util.Objects;

public abstract class Tasks implements Repeatable {

    private String taskHeading;
    private String taskDescription;
    private LocalDateTime timeTask;
    private TypeOfTask typeOfTask;
    private int id;
    private static int idCount = 0;

    public Tasks(String taskHeading, String taskDescription, LocalDateTime timeTask, TypeOfTask typeOfTask) throws IncorrectArgumentException {
        setTaskHeading(taskHeading);
        setTaskDescription(taskDescription);
        setTimeTask(timeTask);
        setTypeOfTask(typeOfTask);
        this.id = idCount++;
    }

    public String getTaskHeading() {
        return taskHeading;
    }

    public void setTaskHeading(String taskHeading) throws IncorrectArgumentException {
        if (taskHeading == null || taskHeading.isEmpty()) {
            throw new IncorrectArgumentException("Заголовок");
        } else {
            this.taskHeading = taskHeading;
        }
    }

    public String getTaskDescription() {
        return taskDescription;
    }

    public void setTaskDescription(String taskDescription) throws IncorrectArgumentException {
        if (taskDescription == null || taskDescription.isEmpty()) {
            throw new IncorrectArgumentException("Заголовок");
        } else {
            this.taskDescription = taskDescription;
        }
    }

    public LocalDateTime getTimeTask() {
        return timeTask;
    }

    public void setTimeTask(LocalDateTime timeTask) throws IncorrectArgumentException {
        if (timeTask == null) {
            throw new IncorrectArgumentException("Дата и время");
        } else {
            this.timeTask = timeTask;
        }
    }

    public TypeOfTask getTypeOfTask() {
        return typeOfTask;
    }

    public void setTypeOfTask(TypeOfTask typeOfTask) throws IncorrectArgumentException {
        if (typeOfTask == null) {
            throw new IncorrectArgumentException("Тип задачи");
        } else {
            this.typeOfTask = typeOfTask;
        }
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Tasks tasks = (Tasks) o;
        return id == tasks.id && Objects.equals(taskHeading, tasks.taskHeading) && Objects.equals(taskDescription, tasks.taskDescription) && Objects.equals(timeTask, tasks.timeTask) && typeOfTask == tasks.typeOfTask;
    }

    @Override
    public int hashCode() {
        return Objects.hash(taskHeading, taskDescription, timeTask, typeOfTask, id);
    }

    @Override
    public String toString() {
        return "Tasks{" +
                "taskHeading='" + taskHeading + '\'' +
                ", taskDescription='" + taskDescription + '\'' +
                ", timeTask=" + timeTask +
                ", typeOfTask=" + typeOfTask +
                ", id=" + id +
                '}';
    }
}
