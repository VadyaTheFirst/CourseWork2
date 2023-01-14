package Task;

import java.time.LocalDate;
import java.util.*;

public class Schedule {   //Класс "График"

    private final Map<Integer, Task> tasks = new HashMap<>();

    //Методы
    public void addTask(Task task) {
        this.tasks.put(task.getId(), task);
    }

    public Collection<Task> getAllTasks() {
        return this.tasks.values();
    }

    public Collection<Task> getTaskForDay(LocalDate date) {
        TreeSet<Task> taskForDate = new TreeSet<>();
        for (Task task : tasks.values()) {
            if (task.appearsIn(date)) {
                taskForDate.add(task);
            }
        }
        return taskForDate;  //Возвращаем задачу на определенную дату
    }

    public void removeTask(int id) throws TaskNotFoundException {
        if (this.tasks.containsKey(id)) {
            this.tasks.remove(id);
        } else {
            throw new TaskNotFoundException();
        }
    }
}