package Service;

import Excepiton.TaskNotFoundException;
import Task.Tasks;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class TaskService {
    private final Map<Integer, Tasks> tasksMap = new HashMap<>();

    public void add(Tasks tasks) {
        this.tasksMap.put(tasks.getId(), tasks);
    }

    public void remove(int idTask) throws TaskNotFoundException {
        if (this.tasksMap.containsKey(idTask)) {
            this.tasksMap.remove(idTask);
        } else {
            throw new TaskNotFoundException(idTask);
        }
    }

    public Collection<Tasks> getTasksForThisDay(LocalDate localDate) {
        Collection<Tasks> tasksForThisDay = new ArrayList<>();
        for (Tasks tasks : tasksMap.values()) {

            if (tasks.appersIn(localDate)) {
                tasksForThisDay.add(tasks);
            }
        }
        return tasksForThisDay;
    }
}
