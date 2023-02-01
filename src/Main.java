import Excepiton.IncorrectArgumentException;
import Excepiton.TaskNotFoundException;
import Service.TaskService;
import Task.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Scanner;

public class Main {

    private static TaskService taskService = new TaskService();

    public static void main(String[] args) {

        try (Scanner scanner = new Scanner(System.in)) {
            label:
            while (true) {
                printMenu();
                System.out.print("Выберите пункт меню: ");
                if (scanner.hasNextInt()) {
                    int menu = scanner.nextInt();
                    switch (menu) {
                        case 1:
                            inputTask(scanner);
                            break;
                        case 2:
                            deleteTask(scanner);
                            break;
                        case 3:
                            getTasksForThisDay(scanner);
                            break;
                        case 0:
                            break label;
                    }
                } else {
                    scanner.next();
                    System.out.println("Выберите пункт меню из списка!");
                }
            }
        } catch (IncorrectArgumentException | TaskNotFoundException e) {
            System.out.println(e.getMessage());
        }
    }

    private static void inputTask(Scanner scanner) throws IncorrectArgumentException {
        System.out.print("Введите название задачи: ");
        String taskHeading = scanner.next();

        System.out.print("Описание задачи: ");
        String taskDescription = scanner.next();

        System.out.print("Укажите тип задачи(личная - 1, рабочая - 2): ");
        TypeOfTask typeOfTask = null;

        int selectTypeOfTask = scanner.nextInt();
        if (selectTypeOfTask == 1) {
            typeOfTask = TypeOfTask.PERSONAL;
        } else if (selectTypeOfTask == 2) {
            typeOfTask = TypeOfTask.WORK;
        } else {
            System.out.println("Выберите тип задачи");
            scanner.nextInt();
        }

        System.out.println("Введите год задачи: ");
        int year = scanner.nextInt();
        System.out.println("Введите месяц задачи: ");
        int month = scanner.nextInt();
        System.out.println("Введите день задачи: ");
        int day = scanner.nextInt();
        System.out.println("Введите часы задачи: ");
        int hours = scanner.nextInt();
        System.out.println("Введите минуты задачи: ");
        int minutes = scanner.nextInt();
        LocalDateTime localDateTime = LocalDateTime.of(year, month, day, hours, minutes);

        System.out.println("Повтор задачи(разовая - 1, ежедневная - 2, еженедельная - 3, ежемесячная - 4, ежегодная - 5");
        int taskRepeatable = scanner.nextInt();
        Tasks task;
        switch (taskRepeatable) {
            case 1 ->
                    task = new OneTimeTask(taskHeading, taskDescription, localDateTime, typeOfTask); // почему не видит timeTask ??
            case 2 -> task = new DailyTask(taskHeading, taskDescription, localDateTime, typeOfTask);
            case 3 -> task = new WeeklyTask(taskHeading, taskDescription, localDateTime, typeOfTask);
            case 4 -> task = new MonthlyTask(taskHeading, taskDescription, localDateTime, typeOfTask);
            case 5 -> task = new YearlyTask(taskHeading, taskDescription, localDateTime, typeOfTask);
            default -> {
                System.out.println("Выберите повторяемость");
                scanner.nextInt();
                return;
            }
        }
        taskService.add(task);
        System.out.println(task);
    }

    private static void deleteTask(Scanner scanner) throws TaskNotFoundException {
        System.out.print("Введите id задачи для удаления ");
        int id = scanner.nextInt();
        taskService.remove(id);
        System.out.println();
    }

    public static void getTasksForThisDay(Scanner scanner) {
        System.out.println("Введите год задачи: ");
        int year = scanner.nextInt();
        System.out.println("Введите месяц задачи: ");
        int month = scanner.nextInt();
        System.out.println("Введите день задачи: ");
        int day = scanner.nextInt();
        LocalDate localDate = LocalDate.of(year, month, day);
        System.out.println(taskService.getTasksForThisDay(localDate));
    }

    private static void printMenu() {
        System.out.println(
                """
                        1. Добавить задачу
                        2. Удалить задачу
                        3. Получить задачу на указанный день
                        0. Выход
                        """
        );
    }


}



