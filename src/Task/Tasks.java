package Task;

import java.time.LocalDateTime;

public class Tasks {

    private String taskHeading;
    private String taskDescription;
    private LocalDateTime ldt;
    private final int id;
    private static int count = 0;

    public enum TypeOfTask {
        PERSONAL("Личная"), WORK("Рабочая");
        private final String typeOfTask;

        TypeOfTask(String typeOfTask) {
            if (typeOfTask == null || typeOfTask.isEmpty() || typeOfTask.isBlank()) {
                throw new IllegalArgumentException();
            } else {
                this.typeOfTask = typeOfTask;
            }
        }

        public String getTypeOfTask() {
            return typeOfTask;
        }

        @Override
        public String toString() {
            return "Тип задачи: " + typeOfTask;
        }
    }

    public enum Repeatability {

        ONCE("Однократная"), DAILY("Ежедневная"),
        WEEKLY("Еженедельная"), MONTHLY("Ежемесячная"),
        ANNUAL("Ежегодная");

        private final String repeatability;

        Repeatability(String repeatability) {
            if (repeatability == null || repeatability.isEmpty() || repeatability.isBlank()) {
                throw new IllegalArgumentException();
            } else {
                this.repeatability = repeatability;
            }
        }

        public String getRepeatability() {
            return repeatability;
        }

        @Override
        public String toString() {
            return "Повторяемость: " + repeatability;
        }
    }

    public Tasks(String taskHeading, String taskDescription, TypeOfTask typeOfTask, Repeatability repeatability) {

        if (taskHeading == null || taskHeading.isEmpty() || taskHeading.isBlank()) {
            throw new IllegalArgumentException();
        } else {
            this.taskHeading = taskHeading;
        }

        if (taskDescription == null || taskDescription.isEmpty() || taskDescription.isBlank()) {
            throw new IllegalArgumentException();
        } else {
            this.taskDescription = taskDescription;
        }

        this.id = count;
        count++;
    }

    public void addTask() {
        System.out.println("Добавлена новая задача: " + getTaskHeading());
    }

    public void deleteTask() {
        System.out.println("Удалена задача: " + getTaskHeading());
    }

    public void getListTask() {

    }

    public String getTaskHeading() {
        return taskHeading;
    }


}
