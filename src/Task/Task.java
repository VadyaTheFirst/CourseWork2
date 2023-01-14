package Task;

import java.time.LocalDate;
import java.time.LocalDateTime;

public abstract class Task implements Comparable<Task> {   /*Абстрактный класс "модель задачи" c интерфейсом Comparable
     Интерфейс Comparable позволяет нам определять порядок между объектами, выявляя, является ли объект больше, меньше или равным другому.*/

    private static int counter = 0;
    private final int id;   //Счётчик id
    private final String title;   //Заголовок задачи
    private final String description;   //Описание задачи
    private final LocalDateTime taskDateTime;   //Дата первого выполнения задачи
    private final TaskType taskType;   //Тип задачи

    //Конструктор
    public Task(String title, String description, LocalDateTime taskDateTime, TaskType taskType) {
        this.id = counter++;
        this.title = title;
        this.description = description;
        this.taskDateTime = taskDateTime;
        this.taskType = taskType;
    }


    public abstract boolean appearsIn(LocalDate localDate);

    public abstract Repeatability getRepeatabilityType();


    public int compareTo(Task otherTask) {
        if (otherTask == null) {
            return 1;
        }
        return this.taskDateTime.toLocalTime().compareTo(otherTask.taskDateTime.toLocalTime());  //Сравниваем время
    }



    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public LocalDateTime getTaskDateTime() {
        return taskDateTime;
    }

    public TaskType getTaskType() {
        return taskType;
    }

}