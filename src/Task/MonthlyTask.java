package Task;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class MonthlyTask extends Task {


    public MonthlyTask(String title, String description, LocalDateTime taskDateTime, TaskType taskType) {
        super(title, description, taskDateTime, taskType);
    }

    //Методы
    @Override
    public boolean appearsIn(LocalDate localDate) {   //Метод сравнения даты задач
        LocalDate taskDate = this.getTaskDateTime().toLocalDate();
        return localDate.equals(taskDate) ||
                (localDate.isAfter(taskDate)) &&
                        (localDate.isAfter(taskDate)) && localDate.getDayOfMonth() == localDate.getDayOfMonth();

    }


    @Override
    public Repeatability getRepeatabilityType() {
        return Repeatability.MONTHLY;
    }


}
