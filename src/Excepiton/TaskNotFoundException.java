package Excepiton;

public class TaskNotFoundException extends Exception {
    public TaskNotFoundException(Integer idTask) {
        super(idTask + " - Задачи с таким id нет");
    }
}
